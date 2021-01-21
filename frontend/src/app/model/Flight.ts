import {Airport} from "./Airport";
import {Airplane} from "./Airplane";
import {Airline} from "./Airline";
import {Discount} from "./Discount";
import {Ticket} from "./Ticket";

export enum TravelClass {
  FIRSTCLASS, BUSINESS, ECONOMY
}

export class Flight {

  id: number;
  departureTime: Date;
  arrivalTime: Date;
  basePrice: number;
  departure: Airport;
  destination: Airport;
  availableSeats = {TravelClass, Number}
  airplane: Airplane;
  airline: Airline;
  discount: Discount;
  tickets: Ticket[];

}
