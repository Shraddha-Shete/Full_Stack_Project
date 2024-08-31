import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  email!:string;
  constructor(private activatedRoute:ActivatedRoute, private authService:AuthService ){}
  ngOnInit(){
    this.email =this.activatedRoute.snapshot.params['email'];
    this.authService.setUserEmail(this.email);
    console.log("in login"+this.email);
  }

}
