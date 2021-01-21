import {TravelClass} from "./Flight";

export enum TimeCategory {
  REGULAR, WEEKEND, NIGHT, HOLIDAY
}

export class Discount {

  togethAirRate: number;
  timeCategoryRate = {TimeCategory, Number};
  travelClassRate = {TravelClass, Number};
  // volumeDiscount = {Number, Number};

}
