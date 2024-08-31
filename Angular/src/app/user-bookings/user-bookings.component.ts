import { Component } from '@angular/core';
import { Booking } from '../booking';
import { FindBooking } from '../admin-module/find-booking';
import { AuthService } from '../auth.service';
import { RegisterService } from '../register.service';
import { find } from 'rxjs';
import { AdminServiceService } from '../admin-module/admin-service.service';

@Component({
  selector: 'app-user-bookings',
  templateUrl: './user-bookings.component.html',
  styleUrl: './user-bookings.component.css'
})
export class UserBookingsComponent {
  findBooking:FindBooking[]=[];
  userEmail!:string;

  constructor(private authService:AuthService, private userService:RegisterService, private adminService:AdminServiceService ){}

  ngOnInit(){
    this.userEmail=this.authService.getUserEmail();
    console.log(this.userEmail);
    this.userService.getUserBooking(this.userEmail).subscribe((res)=>{
      this.findBooking=res;
      console.log(this.findBooking);

      this.findBooking.forEach((booking, index) => {
        this.adminService.findById(booking.hotelId).subscribe((hotel) => {
          console.log(hotel);
          this.findBooking[index].hotelName = hotel.hotelName;
          this.findBooking[index].hotelEmail = hotel.email;
          
          });
        })    
    })

  }


}
