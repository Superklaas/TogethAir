import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { HomepageComponent } from './homepage/homepage.component';
import { SearchFlightsComponent } from './search-flights/search-flights.component';
import {HttpClientModule} from "@angular/common/http";
import { FlightComponent } from './flight/flight.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AddFlightComponent,
    HomepageComponent,
    SearchFlightsComponent,
    FlightComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
