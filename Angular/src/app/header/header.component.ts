import { ChangeDetectorRef, Component, EventEmitter, Output } from '@angular/core';
import { AuthService } from '../auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminServiceService } from '../admin-module/admin-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

@Output() toggleSidebarForMe:EventEmitter<any>=new EventEmitter

  isLoggedIn: boolean = false;
  isloggedInManag: boolean= false;
  isLoggedInAdm: boolean = false;
  loggedout: boolean =false;
  
 
  

  constructor(private authService: AuthService,private cdr: ChangeDetectorRef, private adminService:AdminServiceService, private activatedRoute:ActivatedRoute) {}

  ngOnInit() {
    this.authService.isLoggedIn.subscribe(
      (loggedIn: boolean) => {
        this.isLoggedIn = loggedIn;
        this.cdr.detectChanges();
      }
    );

    this.authService.isloggedInManag.subscribe(
      (loggedInManag: boolean) =>{
        this.isloggedInManag = loggedInManag;
        this.cdr.detectChanges();
      });

      this.authService.isLoggedInAdm.subscribe(
        (loggedInAdm: boolean) => {
          this.isLoggedInAdm = loggedInAdm;
          this.cdr.detectChanges();
        }
      );

      }
      
  

  logout() {
    this.authService.logout();
  }
  toggleSidebar(){
    this.toggleSidebarForMe.emit;
  }

  BookHotel() {
    
    }

  

}
