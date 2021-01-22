import { Component, OnInit } from '@angular/core';
import {Flight} from "../model/Flight";
import {DataService} from "../data.service";

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  flights: Flight[];
  closeResult: string;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.getAllFlights().subscribe(
      (next) => {
        this.flights = next;
        console.log(this.flights);
      }
    )
  }

  enterTicketDetails(): void {
  }

}
