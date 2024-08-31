import { Component } from '@angular/core';
import { LoginResponse } from '../login-response';
import { RegisterService } from '../register.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  email!:string;
  password!:string;
  user!:String;

  loginRes:LoginResponse=new LoginResponse;
  constructor(private registerService:RegisterService,private authService: AuthService, private router:Router){}
  login(){
    console.log(this.email, this.password);

    this.registerService.loginPage(this.email, this.password, this.user).subscribe((res)=>{
      this.authService.login(res.role);
    
      console.log(res);

      if (res.message == "Email not exits")
        {
          alert("Email not exits");
        }
        else if(res.message == "Login Success")
         {if(res.role===this.user){
          if(this.user=="Customer"){
           //this.authService.login(res.role);
            this.router.navigate(['user', this.email]);
          }
          else if(this.user=="Admin"){
           // this.authService.login(res.role);
            this.router.navigate(['admin']);
          }
          else if(this.user=="Manager"){
            // this.authService.login(res.role);
            this.router.navigate(["manager", this.email]);
          }
        }
          else{
            alert("Invalid User");
          }
          
        }
        else
        {
          alert("Incorrect Password ");
        }

    });
      
    
  }
}
