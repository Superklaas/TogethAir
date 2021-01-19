import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OverviewFlightsComponent } from './overview-flights.component';

describe('OverviewFlightsComponent', () => {
  let component: OverviewFlightsComponent;
  let fixture: ComponentFixture<OverviewFlightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OverviewFlightsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OverviewFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
