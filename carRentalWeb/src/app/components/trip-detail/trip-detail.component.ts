import { Component, OnInit } from '@angular/core';
import { TripModel } from 'src/app/models/trip.model';
import { NgForm } from '@angular/forms';
import { TripsService } from 'src/app/services/trips.service';
import Swal from 'sweetalert2';
import { Observable } from 'rxjs';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { VehiclesService } from 'src/app/services/vehicles.service';
import { VehicleModel } from 'src/app/models/vehicle.model';
import { DriversService } from 'src/app/services/drivers.service';
import { DriverModel } from 'src/app/models/driver.model';


@Component({
  selector: 'app-trip-detail',
  templateUrl: './trip-detail.component.html',
  styleUrls: ['./trip-detail.component.css']
})
export class TripDetailComponent implements OnInit {

  trip = new TripModel();
  vehicles: VehicleModel[] = [];
  drivers: DriverModel[] = [];
  selectedVehicle: VehicleModel;

  constructor(private tripsService: TripsService, private vehiclesService: VehiclesService,
              private driversService: DriversService
    ) { }

  ngOnInit() {
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

    this.tripsService.addTrip(this.trip)
      .subscribe(resp => {
        console.log(resp);
        this.trip = resp;
      });

    Swal.fire({
        title: this.selectedVehicle.brand + ' - ' + this.selectedVehicle.model + '(' + this.trip.date + ')',
        text: 'Updated',
        type: 'success'
      });

  }

  findVehiclesAvailables(date: Date) {
    console.log(date);

    this.vehiclesService.findVehiclesAvailables(date)
    .subscribe(resp => {
      this.vehicles = resp;
    });
  }

  findDriversAvailables(date: Date, license: string) {
    this.trip.idVehicles = this.selectedVehicle.idvehicles;
    this.driversService.findDriversAvailables(date, license)
    .subscribe(resp => {
      this.drivers = resp;
      console.log(this.drivers);
    });
  }




}
