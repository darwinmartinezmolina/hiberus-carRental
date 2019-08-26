import { Component, OnInit } from '@angular/core';
import { VehicleModel } from 'src/app/models/vehicle.model';
import { NgForm } from '@angular/forms';
import { VehiclesService } from 'src/app/services/vehicles.service';
import Swal from 'sweetalert2';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

// Environment as env
import { environment as env } from '../../../environments/environment';

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {

  vehicle = new VehicleModel();

  licenses = env.LICENSES;

  constructor(private vehiclessService: VehiclesService,
    private route: ActivatedRoute) { }

  ngOnInit() {

    const id = this.route.snapshot.paramMap.get('id');

    if (id !== 'new') {
      this.vehiclessService.getVehicle(id).subscribe( resp => {
        this.vehicle = resp;
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

    if (this.vehicle.idvehicles) {
      request = this.vehiclessService.updateVehicle(this.vehicle);
    } else {
      request = this.vehiclessService.addVehicle(this.vehicle);
    }

    request.subscribe(resp => {
      console.log(resp);
      this.vehicle = resp;

      Swal.fire({
        title: this.vehicle.brand + ' ' + this.vehicle.model + ' - ' + this.vehicle.plate,
        text: 'Updated',
        type: 'success'
      });

    });
  }

}
