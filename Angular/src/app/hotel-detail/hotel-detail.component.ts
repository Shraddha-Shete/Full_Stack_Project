import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { HotelDetails } from '../hotel-details';
import { Facility } from '../facility';

@Component({
  selector: 'app-hotel-detail',
  templateUrl: './hotel-detail.component.html',
  styleUrl: './hotel-detail.component.css'
})
export class HotelDetailComponent {
   hotel:HotelDetails=new HotelDetails;
   loading:boolean=true;
   facility:Facility[]=[];
  constructor(private router:ActivatedRoute, private registerService:RegisterService , private route: Router){}

  ngOnInit():void{
    const idParam=this.router.snapshot.paramMap.get('id');
    if(idParam){
      const id=parseInt(idParam, 10);
      if(!isNaN(id)){
        this.registerService.getHotelById(id).subscribe(res =>{
          this.hotel=res;
          console.log(res);
          this.loading=false;
        })
        this.registerService.getFacility(id).subscribe(res =>{
          this.facility=res;
          console.log(this.facility);
        })
      }
    }
    
  }

  book(hotel:any){
    console.log(hotel);
    this.route.navigate(['book', hotel.hotelName]);
  }

}
