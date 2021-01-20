import { Component, OnInit } from '@angular/core';
import {Flight} from "../model/Flight";
import {DataService} from "../data.service";

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  flight: Flight;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.getFlightById(1).subscribe(
      (next) => {
        console.log(next);
        this.flight = Flight.fromHttp(next);
        console.log(this.flight);
      }
    )
  }

}
