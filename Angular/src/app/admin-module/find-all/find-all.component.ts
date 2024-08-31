import { Component } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { FindBooking } from '../find-booking';

@Component({
  selector: 'app-find-all',
  templateUrl: './find-all.component.html',
  styleUrls: ['./find-all.component.css']
})
export class FindAllComponent {
  findBooking: FindBooking[] = [];
  searchText: string = '';

  constructor(private adminService: AdminServiceService) {}

  ngOnInit() {
    this.adminService.findAllBookings().subscribe((res) => {
      this.findBooking = res;
      this.findBooking.forEach((booking, index) => {
        this.adminService.findById(booking.hotelId).subscribe((hotel) => {
          this.findBooking[index].hotelName = hotel.hotelName;
          this.findBooking[index].hotelEmail = hotel.email;
        });
      });
    });
  }

  filteredBookings(): FindBooking[] {
    return this.findBooking.filter(booking =>
      booking.hotelName.toLowerCase().includes(this.searchText.toLowerCase()) ||
      booking.hotelEmail.toLowerCase().includes(this.searchText.toLowerCase()) ||
      booking.guestName.toLowerCase().includes(this.searchText.toLowerCase()) ||
      booking.guestPhone.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }
}
