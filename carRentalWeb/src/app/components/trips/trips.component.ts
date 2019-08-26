import { Component, OnInit } from '@angular/core';
import { TripModel } from 'src/app/models/trip.model';
import { TripsService } from 'src/app/services/trips.service';

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css']
})
export class TripsComponent implements OnInit {

  trips: TripModel[] = [];
  loading = false;
  pageOfItems: Array<any>;
  

  constructor(private tripsService: TripsService) { }

  ngOnInit() {
    this.findAll();
    this.loading = true;
  }

  findAll() {
    this.tripsService.findAll()
    .subscribe(resp => {
      console.log(resp);
      this.trips = resp;
      this.loading = false;
    });
  }

  onChangePage(pageOfItems: Array<any>) {
    // update current page of items
    this.pageOfItems = pageOfItems;
}

}
