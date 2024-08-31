import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { ManagerComponent } from './admin-module/manager/manager.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatDividerModule} from '@angular/material/divider';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
//import {FlexLayoutModule} from '@angular/flex-layout';
import {MatMenuModule} from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import { RouterModule } from '@angular/router';
import {MatSidenavModule} from '@angular/material/sidenav';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { AddHotelComponent } from './admin-module/add-hotel/add-hotel.component';
import { AdminModuleModule } from './admin-module/admin-module.module';
import { ShowHotelComponent } from './show-hotel/show-hotel.component';
import { HotelDetailComponent } from './hotel-detail/hotel-detail.component';
import { bookComponent } from './book/book.component';
import { FacilitiesComponent } from './facilities/facilities.component';
import { FindByHotelIdComponent } from './find-by-hotel-id/find-by-hotel-id.component';
import { ManagerBookHotelComponent } from './manager-book-hotel/manager-book-hotel.component';
import { UserBookingsComponent } from './user-bookings/user-bookings.component';






@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    UserComponent,
    AdminComponent,
    ManagerComponent,
    SidenavComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    AddHotelComponent,
    ShowHotelComponent,
    HotelDetailComponent,
    bookComponent,
    FacilitiesComponent,
    FindByHotelIdComponent,
    ManagerBookHotelComponent,
    UserBookingsComponent
   
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatDividerModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
   // FlexLayoutModule,
    MatMenuModule,
    MatListModule,
    RouterModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    AdminModuleModule
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
