import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Facility } from '../facility';
import { ManagerServiceService } from '../manager-service.service';
import { HttpClient } from '@angular/common/http';
import { UserRegister } from '../user-register';

@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrl: './facilities.component.css'
})
export class FacilitiesComponent {

  facility:Facility=new Facility();
  userRegister:UserRegister=new UserRegister();
  email!: string;
  managerId!:number;
  hotelId!:number;

  constructor(
    private managerService:ManagerServiceService, private authService:AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.email = this.authService.getUserEmail();
    console.log("Add Facility component email: " + this.email);

    this.managerService.findManager(this.email).subscribe((res)=>{
      this.facility.manager = { id: res.id };
      this.facility.hotel = { id: res.hotel.id };
      console.log(this.hotelId+" "+this.managerId);

    })
  }
   
  
  addFacility(): void {
    this.managerService.addFacility(this.facility).subscribe({
      next: (response) => {
        console.log('Facility added:', response);
        alert("Facility Added Successfully");
      },
      error: (err) => console.error('Error adding facility:', err)
    });
  }
}
