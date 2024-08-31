import { Component } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { UserRegister } from '../../user-register';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ManagerServiceService } from '../../manager-service.service';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrl: './manager.component.css'
})
export class ManagerComponent {

  userRegister:UserRegister=new UserRegister();
  email!:string;
  hotelName!:string;
  registrationForm!: NgForm;
  constructor(private managerService: AdminServiceService, private authService:AuthService, private manager:ManagerServiceService, private activatedRoute:ActivatedRoute) { }

  ngOnInit(){
    this.email =this.activatedRoute.snapshot.params['email'];
    console.log("in login"+this.email);
    this.authService.setUserEmail(this.email);  // Store the email
    console.log("User component email: " + this.email);
    
    this.manager.findManager(this.email).subscribe((res)=>{
      console.log(res);
      this.hotelName=res.hotel.hotelName;
      console.log(this.hotelName);

    })
  }

  get confirmPasswordControl() {
    return this.registrationForm.form.get('confirmPassword');
  }

  registerManager() {
    if (!this.userRegister.passwordMatch()) {
      console.log('Passwords do not match');
      return;
    }
    this.managerService.registerManager(this.userRegister).subscribe(
      response => {
        console.log('Manager registered successfully', response);
        alert("Manager registered successfully");
      },
      error => {
        console.error('Error registering manager', error);
        alert("Error registering manager");
      }
    );
  }

}
