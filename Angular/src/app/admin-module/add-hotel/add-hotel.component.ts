
import { Component } from '@angular/core';
import { Hotel } from '../hotel';
import { AdminServiceService } from '../admin-service.service';
import { NgForm } from '@angular/forms';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-add-hotel',
  templateUrl: './add-hotel.component.html',
  styleUrl: './add-hotel.component.css'
})
export class AddHotelComponent {
  hotel: Hotel = new Hotel;
images: File[] = [];

constructor(private adminService:AdminServiceService) {}

onFileChange(event: any, index: number) {
    this.images[index] = event.target.files[0];
}

// onSubmit(form:NgForm) {
//     if (form.valid) {
//         this.adminService.addHotel(this.hotel, this.images).subscribe(
//           (response) => {
//             console.log('Hotel added successfully', response);
//             alert("Hotel added successfully");
//             form.reset();
//           },
//           (error) => {
//             alert("Error adding hotel");
//             console.error('Error adding hotel', error);
//           }
//         );
//       }
    
// }
onSubmit(form: NgForm) {
  if (form.valid) {
    this.adminService.getManagerByAdminName(this.hotel.hotelAdmin).pipe(
      switchMap((manager: any) => {
        if (manager && manager.id) {
          return this.adminService.addHotel(this.hotel, this.images).pipe(
            switchMap((hotelResponse: any) => {
              return this.adminService.associateHotelWithManager(manager.id, hotelResponse.id);
            })
          );
        } else {
          throw new Error('Manager not found');
        }
      })
    ).subscribe(
      (response) => {
        console.log('Hotel added and associated successfully', response);
        alert('Hotel added and associated successfully');
        form.reset();
      },
      (error) => {
        alert('Error adding hotel or associating with manager');
        console.error('Error adding hotel or associating with manager', error);
      }
    );
  }
}

}


