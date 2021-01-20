export class Flight {

  id: number;
  basePrice: number;

  constructor(id: number, basePrice: number) {
    this.id = id;
    this.basePrice = basePrice;
  }

  static fromHttp(flight: Flight) {
    return new Flight(flight.id,flight.basePrice);
  }

}
