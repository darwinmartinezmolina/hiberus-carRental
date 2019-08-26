import { Component, OnInit } from '@angular/core';
import { VehicleModel } from 'src/app/models/vehicle.model';
import { VehiclesService } from 'src/app/services/vehicles.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicles: VehicleModel[] = [];
  loading = false;
  pageOfItems: Array<any>;

  constructor(private vehiclesService: VehiclesService) { }

  ngOnInit() {
    this.loading = true;
    this.findAll();
  }

  findAll() {
    this.vehiclesService.findAll()
    .subscribe(resp => {
      console.log(resp);
      this.vehicles = resp;
      this.loading = false;
    });
  }
  
  deleteVehicle(vehicle: VehicleModel, index: number) {
    
    Swal.fire({
      title: 'Are you sure?',
      text: `Are you sure you want to delete to ${vehicle.model}?`,
      type: 'question',
      showConfirmButton: true,
      showCancelButton: true
    }).then(resp => {
      if (resp.value){
        this.pageOfItems.splice(index, 1);
        this.vehiclesService.deleteVehicle(vehicle.idvehicles).subscribe();
      }
    });
  }

  onChangePage(pageOfItems: Array<any>) {
    // update current page of items
    this.pageOfItems = pageOfItems;
}

}
