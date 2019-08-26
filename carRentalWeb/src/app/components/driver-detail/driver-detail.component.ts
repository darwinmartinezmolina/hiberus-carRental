import { Component, OnInit } from '@angular/core';
import { DriverModel } from '../../models/driver.model';
import { NgForm } from '@angular/forms';
import { DriversService } from '../../services/drivers.service';
import Swal from 'sweetalert2';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

// Environment as env
import { environment as env } from '../../../environments/environment';

@Component({
  selector: 'app-driver-detail',
  templateUrl: './driver-detail.component.html',
  styleUrls: ['./driver-detail.component.css']
})
export class DriverDetailComponent implements OnInit {

  driver = new DriverModel();
  drivers: any[];

  licenses = env.LICENSES;

  constructor(private driversService: DriversService,
    private route: ActivatedRoute ) { }

  ngOnInit() {

    const id = this.route.snapshot.paramMap.get('id');

    if (id !== 'new') {
      this.driversService.getDriver(id).subscribe( resp => {
        this.driver = resp;
      });
    }
  }

  save(form: NgForm) {

    if (form.invalid) {
      console.log('Invalid form');

      Swal.fire({
        title: 'Warning',
        text: 'Please review the fields',
        type: 'warning',
        allowOutsideClick: false
      });

      return;
    }

    Swal.fire({
      title: 'Wait',
      text: 'Saving data',
      type: 'info',
      allowOutsideClick: false
    });
    Swal.showLoading();

    let request: Observable<any>;

    if (this.driver.iddrivers) {
      request = this.driversService.updateDriver(this.driver);
    } else {
      request = this.driversService.addDriver(this.driver);
    }

    request.subscribe(resp => {
      console.log(resp);
      this.driver = resp;

      Swal.fire({
        title: this.driver.name + ' ' + this.driver.surname,
        text: 'Updated',
        type: 'success'
      });


    });
  }

}
