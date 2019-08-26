import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TripModel } from '../models/trip.model';

// Environment as env
import { environment as env } from '../../environments/environment';

const url = `${env.API_BASE_URL.protocol}${env.API_BASE_URL.uri}:${env.API_BASE_URL.port}/${env.API_BASE_URL.endpoint}`;

@Injectable({
  providedIn: 'root'
})
export class TripsService {

  constructor(private http: HttpClient) { }

  addTrip(trip: TripModel) {

    return this.http.post<TripModel>(`${url}${env.API_BASE_URL.api.trips}`, trip);
  }

  findAll() {
    return this.http.get<TripModel[]>(`${url}${env.API_BASE_URL.api.trips}`);
  }
}
