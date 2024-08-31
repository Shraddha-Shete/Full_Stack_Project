import { Component } from '@angular/core';
import { Booking } from '../booking';
import { ManagerServiceService } from '../manager-service.service';
import { AuthService } from '../auth.service';
import { ActivatedRoute } from '@angular/router';
import { Facility } from '../facility';

@Component({
  selector: 'app-manager-book-hotel',
  templateUrl: './manager-book-hotel.component.html',
  styleUrl: './manager-book-hotel.component.css'
})
export class ManagerBookHotelComponent {
  receipt:any;
  booking:Booking =new Booking;
  facility:Facility=new Facility();
  hotelName!:any;
  hotelId!: number;
  email!:string;
  roomTypes: string[] = ['Single', 'Double', 'Suite', 'Deluxe'];

  constructor(
    private managerService:ManagerServiceService, private authService:AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit():void{
    this.email = this.authService.getUserEmail();
    console.log("BookHotel component email: " + this.email);

    this.managerService.findManager(this.email).subscribe((res)=>{
      this.facility.hotel = { id: res.hotel.id };
      console.log(res);
      // this.facility.hotel ={ hotelName: res.hotel.hotelName}
      console.log(this.hotelId);

    })
  }

  bookHotel(){

  }
}
