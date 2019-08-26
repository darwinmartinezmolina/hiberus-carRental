import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DriverModel } from '../models/driver.model';

// Environment as env
import { environment as env } from '../../environments/environment';

const url = `${env.API_BASE_URL.protocol}${env.API_BASE_URL.uri}:${env.API_BASE_URL.port}/${env.API_BASE_URL.endpoint}`;

@Injectable({
  providedIn: 'root'
})
export class DriversService {

  constructor(private http: HttpClient) { }

  addDriver(driver: DriverModel) {

    return this.http.post<DriverModel>(`${url}${env.API_BASE_URL.api.drivers}`, driver);
  }

  findAll() {
    return this.http.get<DriverModel[]>(`${url}${env.API_BASE_URL.api.drivers}`);
  }

  getDriver(idDriver: any) {
    return this.http.get<DriverModel>(`${url}${env.API_BASE_URL.api.drivers}${idDriver}`);
  }

  updateDriver( driver: DriverModel) {
    return this.http.put<DriverModel>(`${url}${env.API_BASE_URL.api.drivers}`, driver);
  }

  deleteDriver(idDriver: any) {
    return this.http.delete<DriverModel>(`${url}${env.API_BASE_URL.api.drivers}${idDriver}`);
  }

  findDriversAvailables(date: Date, license: string) {
    return this.http.get<DriverModel[]>(`${url}${env.API_BASE_URL.api.utils}${env.API_BASE_URL.api.drivers}${date}/${license}`);
  }




}
