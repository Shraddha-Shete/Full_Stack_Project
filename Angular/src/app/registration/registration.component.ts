import { Component } from '@angular/core';
import { UserRegister } from '../user-register';
import { NgForm } from '@angular/forms';
import { RegisterService } from '../register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {
  userRegister:UserRegister=new UserRegister();
  registrationForm!: NgForm;
  constructor(private registerService:RegisterService, private route:Router){} 
  get confirmPasswordControl() {
    return this.registrationForm.form.get('confirmPassword');
  }

  addUser() {
    if (!this.userRegister.passwordMatch()) {
      console.log('Passwords do not match');
      return;
    }

    this.registerService.saveUser(this.userRegister).subscribe((res) => {
      console.log(res);
      alert("registration Succesfull");
      this.route.navigate(["login"]);
    },
     
    (error)=>{
      console.log(error);
      alert('Registration Failed');
    }
    );

   
   
  }
}
