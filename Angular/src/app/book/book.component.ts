import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../booking';
import { ManagerServiceService } from '../manager-service.service';
import { RegisterService } from '../register.service';
import { HotelDetails } from '../hotel-details';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class bookComponent {

  booking:Booking =new Booking;
  hotelName!:any;
  hotelId!: number;
  receipt:any;
  hotel:HotelDetails=new HotelDetails();
  userEmail!:string;
  

  roomTypes: string[] = ['Single', 'Double', 'Suite', 'Deluxe'];

  constructor( private router:ActivatedRoute, private authService:AuthService, private bookingservice:ManagerServiceService, private registerService:RegisterService) {}
  ngOnInit():void{
    this.userEmail=this.authService.getUserEmail();
    let nameParam=this.router.snapshot.paramMap.get('hotelName');
    this.hotelName=nameParam;
    this.bookingservice.findHotel(this.hotelName).subscribe(
      response => {
        this.hotel=response
        this.hotelId=this.hotel.id
        console.log(this.hotelId)
      });
    // this.hotelId = Number(idParam);
    console.log(nameParam);
    console.log(this.hotelId);
  }
    

  bookHotel() {
    this.booking.hotelId = this.hotelId;;
    console.log(this.booking);
    this.bookingservice.bookHotel(this.booking).subscribe(
      response => {
        console.log('Booking successful', response);
        this.receipt = response;
      },
      error => {
        console.error('Error booking hotel', error);
      }
    );
    
  }
}
