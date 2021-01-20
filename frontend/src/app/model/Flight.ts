export class Flight {

  id: number;
  departureTime: Date;
  arrivalTime: Date;
  basePrice: number;

  static fromHttp(flight: Flight) {
    const newFlight = new Flight();
    newFlight.id = flight.id;
    newFlight.departureTime = flight.departureTime;
    newFlight.arrivalTime = flight.arrivalTime;
    newFlight.basePrice = flight.basePrice;
    return newFlight;
  }

}
