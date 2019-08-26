import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { JwPaginationComponent } from 'jw-angular-pagination';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

// routes
import { APP_ROUTING } from './app.routes';

// services

// components
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { DriversComponent } from './components/drivers/drivers.component';
import { TripsComponent } from './components/trips/trips.component';
import { TripDetailComponent } from './components/trip-detail/trip-detail.component';
import { DriverDetailComponent } from './components/driver-detail/driver-detail.component';
import { VehicleDetailComponent } from './components/vehicle-detail/vehicle-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    VehiclesComponent,
    DriversComponent,
    TripsComponent,
    TripDetailComponent,
    DriverDetailComponent,
    VehicleDetailComponent,
    JwPaginationComponent
  ],
  imports: [
    BrowserModule,
    APP_ROUTING,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
