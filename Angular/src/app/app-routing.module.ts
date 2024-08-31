import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ManagerComponent } from './admin-module/manager/manager.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AddHotelComponent } from './admin-module/add-hotel/add-hotel.component';
import { AddLocationsComponent } from './admin-module/add-locations/add-locations.component';
import { ShowHotelComponent } from './show-hotel/show-hotel.component';
import { HotelDetailComponent } from './hotel-detail/hotel-detail.component';
import { bookComponent } from './book/book.component';
import { FacilitiesComponent } from './facilities/facilities.component';
import { FindAllComponent } from './admin-module/find-all/find-all.component';
import { FindByHotelIdComponent } from './find-by-hotel-id/find-by-hotel-id.component';
import { UserBookingsComponent } from './user-bookings/user-bookings.component';
import { ManagerBookHotelComponent } from './manager-book-hotel/manager-book-hotel.component';




const routes: Routes = [
  {path:'',redirectTo:'home', pathMatch:'full' },
  {path:"login", component:LoginComponent},
  {path:"Register", component:RegistrationComponent},
  {path:"admin", component:AdminComponent},
  {path:"user/:email", component:UserComponent},
  {path:"manager/:email", component:ManagerComponent},
  {path:"sidenav", component:SidenavComponent},
  {path:"header", component:HeaderComponent},
  {path:"home",component:HomeComponent},
  {path:"addHotel", component:AddHotelComponent},
  {path:"addLocation", component:AddLocationsComponent},
  {path:"hotelList", component:ShowHotelComponent},
  {path:"hotelDetail/:id", component:HotelDetailComponent},
  {path:"book/:hotelName", component:bookComponent},
  {path:"facility", component:FacilitiesComponent},
  {path: "managerRegi", component:ManagerComponent},
  {path:"findAll", component:FindAllComponent},
  {path:"findByHotelId", component:FindByHotelIdComponent},
  {path: "userBookings", component:UserBookingsComponent},
  {path: "bookHotel", component:ManagerBookHotelComponent}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
