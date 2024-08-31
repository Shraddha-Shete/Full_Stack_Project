import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { AddLocationsComponent } from './add-locations/add-locations.component';
import { FindAllComponent } from './find-all/find-all.component';



@NgModule({
  declarations: [
    AddLocationsComponent,
    FindAllComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    
  ]
})
export class AdminModuleModule { }
