import { Component, OnInit } from '@angular/core';
import {DataService} from "../data.service";
import {Flight} from "../model/Flight";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private dataService : DataService) { }

  ngOnInit(): void {
    this.dataService.getFlightById(1).subscribe(
      (next) => {
        console.log(next);
        console.log(typeof next);
        let flight = Flight.fromHttp(next);
        console.log(flight);
        console.log(typeof flight);
      }
    )
  }

}
