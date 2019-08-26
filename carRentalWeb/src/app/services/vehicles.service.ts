import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { VehicleModel } from '../models/vehicle.model';

// Environment as env
import { environment as env } from '../../environments/environment';

const url = `${env.API_BASE_URL.protocol}${env.API_BASE_URL.uri}:${env.API_BASE_URL.port}/${env.API_BASE_URL.endpoint}`;

@Injectable({
  providedIn: 'root'
})
export class VehiclesService {

  constructor(private http: HttpClient) { }

  addVehicle(vehicle: VehicleModel) {

    return this.http.post<VehicleModel>(`${url}${env.API_BASE_URL.api.vehicles}`, vehicle);
  }

  findAll() {
    return this.http.get<VehicleModel[]>(`${url}${env.API_BASE_URL.api.vehicles}`);
  }

  getVehicle(idVehicle: any) {
    return this.http.get<VehicleModel>(`${url}${env.API_BASE_URL.api.vehicles}${idVehicle}`);
  }

  updateVehicle( vehicle: VehicleModel) {
    return this.http.put<VehicleModel>(`${url}${env.API_BASE_URL.api.vehicles}`, vehicle);
  }

  deleteVehicle(idVehicle: any) {
    return this.http.delete<VehicleModel>(`${url}${env.API_BASE_URL.api.vehicles}${idVehicle}`);
  }

  findVehiclesAvailables(date: Date) {
    return this.http.get<VehicleModel[]>(`${url}${env.API_BASE_URL.api.utils}${env.API_BASE_URL.api.vehicles}${date}`);
  }
}
