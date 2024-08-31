import { Component, ElementRef, Renderer2 } from '@angular/core';
import { HotelDetails } from '../hotel-details';
import { RegisterService } from '../register.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-show-hotel',
  templateUrl: './show-hotel.component.html',
  styleUrl: './show-hotel.component.css'
})
export class ShowHotelComponent {

  searchText:string='';
 hotel: HotelDetails[]=[];
 hotels:HotelDetails=new HotelDetails();

 constructor(private register:RegisterService,private router :ActivatedRoute, private route:Router, private el: ElementRef){}

 ngOnInit():void{
  this.register.getHotels().subscribe((res)=>{
    this.hotel = res
    console.log(this.hotel);
    console.log(this.searchText);
  })
 }
 nextSlide(hotelId: number) {
  // Find the carousel element by its ID
  const carousel = this.el.nativeElement.querySelector('#carousel-' + hotelId);
  console.log(hotelId);
  // Trigger the next slide
  if (carousel) {
    const nextButton = carousel.querySelector('.carousel-control-next');
      if (nextButton) {
        nextButton.dispatchEvent(new Event('click'));
      }
    }
}

filteredHotels(): HotelDetails[] {
  return this.hotel.filter(hotel =>
    hotel.location.toLowerCase().includes(this.searchText.toLowerCase()) ||hotel.hotelName.toLowerCase().includes(this.searchText.toLowerCase()) 
  );
}

viewDetails(hotels:any) {
  console.log(hotels.id);
  if(hotels && hotels.id){
    console.log("Navigating to hotel"+hotels.id);
    this.route.navigate(["hotelDetail", hotels.id]);
  }
  
  }

 
}

