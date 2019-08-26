import { Component, OnInit } from '@angular/core';
import { DriverModel } from 'src/app/models/driver.model';
import { DriversService } from 'src/app/services/drivers.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-drivers',
  templateUrl: './drivers.component.html',
  styleUrls: ['./drivers.component.css']
})
export class DriversComponent implements OnInit {

  drivers: DriverModel[] = [];
  loading = false;
  pageOfItems: Array<any>;

  constructor(private driversService: DriversService) { }

  ngOnInit() {
    this.loading = true;
    this.findAll();
  }

  findAll() {
    this.driversService.findAll()
    .subscribe(resp => {
      console.log(resp);
      this.drivers = resp;
      this.loading = false;
    });
  }

  deleteDriver(driver: DriverModel, index: number) {
    
    Swal.fire({
      title: 'Are you sure?',
      text: `Are you sure you want to delete to ${driver.name} ${driver.surname}?`,
      type: 'question',
      showConfirmButton: true,
      showCancelButton: true
    }).then(resp => {
      if(resp.value){
        this.pageOfItems.splice(index, 1);
        this.driversService.deleteDriver(driver.iddrivers).subscribe();
      }
    });
  }

  onChangePage(pageOfItems: Array<any>) {
    // update current page of items
    this.pageOfItems = pageOfItems;
}


}
