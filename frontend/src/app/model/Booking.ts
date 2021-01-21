import {Customer} from "./Customer";

export enum PaymentMethod {
  CREDITCARD, ENDORSEMENT
}

export class Booking {

  dateBooking: Date;
  priceBooking: number;
  paymentMethod: PaymentMethod;
  isPayed: boolean;
  customer: Customer;

}
