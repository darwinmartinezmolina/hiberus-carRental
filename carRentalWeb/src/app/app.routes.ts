import { RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DriversComponent } from './components/drivers/drivers.component';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { TripsComponent } from './components/trips/trips.component';
import { DriverDetailComponent } from './components/driver-detail/driver-detail.component';
import { VehicleDetailComponent } from './components/vehicle-detail/vehicle-detail.component';
import { TripDetailComponent } from './components/trip-detail/trip-detail.component';

const APP_ROUTES: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'drivers', component: DriversComponent },
    { path: 'driver-detail/:id', component: DriverDetailComponent },
    { path: 'vehicles', component: VehiclesComponent },
    { path: 'vehicle-detail/:id', component: VehicleDetailComponent },
    { path: 'trips', component: TripsComponent },
    { path: 'trip-detail/:id', component: TripDetailComponent },
    { path: '**', pathMatch: 'full', redirectTo: ''}
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES, { useHash: true});