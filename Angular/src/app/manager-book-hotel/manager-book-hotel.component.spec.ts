import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerBookHotelComponent } from './manager-book-hotel.component';

describe('ManagerBookHotelComponent', () => {
  let component: ManagerBookHotelComponent;
  let fixture: ComponentFixture<ManagerBookHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ManagerBookHotelComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ManagerBookHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
