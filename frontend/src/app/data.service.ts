import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";
import {Flight} from "./model/Flight";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private flightUrl = 'http://localhost:8082/flights';

  constructor(private http: HttpClient) {
  }

  getFlightById(id: number) : Observable<Flight> {
    return this.http.get<Flight>(this.flightUrl + '/getFlightById/' + id);
  }

  getAllFlights() : Observable<Flight[]> {
    return this.http.get<Flight[]>(this.flightUrl + '/getAllFlights');
  }

}
