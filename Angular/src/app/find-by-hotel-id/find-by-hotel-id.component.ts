import { Component } from '@angular/core';
import { FindBooking } from '../admin-module/find-booking';
import { AdminServiceService } from '../admin-module/admin-service.service';
import { ManagerServiceService } from '../manager-service.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-find-by-hotel-id',
  templateUrl: './find-by-hotel-id.component.html',
  styleUrl: './find-by-hotel-id.component.css'
})
export class FindByHotelIdComponent {
  findBooking:FindBooking[]=[];
  HotelId!:number;
  constructor(private adminService:AdminServiceService, private managerService:ManagerServiceService, private authService:AuthService){}

  ngOnInit(){
    this.managerService.findManager(this.authService.getUserEmail()).subscribe((res)=>{
      this.HotelId = res.hotel.id;
      console.log("find list: "+this.HotelId);
      this.adminService.findBookingByHotelId(this.HotelId).subscribe((res)=>{
        this.findBooking=res;
        console.log(this.findBooking);
        
        
        // Fetch hotel details for each booking
      this.findBooking.forEach((booking, index) => {
        this.adminService.findById(booking.hotelId).subscribe((hotel) => {
          console.log(hotel);
          this.findBooking[index].hotelName = hotel.hotelName;
          this.findBooking[index].hotelEmail = hotel.email;
          
          });
        });
      })
    }) 
    
  }
}


