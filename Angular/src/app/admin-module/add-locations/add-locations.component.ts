import { Component } from '@angular/core';
import { Places } from '../places';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-add-locations',
  templateUrl: './add-locations.component.html',
  styleUrl: './add-locations.component.css'
})
export class AddLocationsComponent {

  places:Places=new Places();
  constructor(private adminService:AdminServiceService){}

  add(){
    console.log(this.places.place);
    this.adminService.addLocation(this.places).subscribe((res)=>{
      console.log(res);
      alert("Location added successfully");
    });
    
  }

}
