import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindByHotelIdComponent } from './find-by-hotel-id.component';

describe('FindByHotelIdComponent', () => {
  let component: FindByHotelIdComponent;
  let fixture: ComponentFixture<FindByHotelIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FindByHotelIdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FindByHotelIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
