import { Injectable } from '@angular/core';
import { Facility } from './facility';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Booking } from './booking';


@Injectable({
  providedIn: 'root'
})
export class ManagerServiceService {
  
  baseURL= "http://localhost:8085"
  constructor(private http:HttpClient) { }

  addFacility(facility: Facility):Observable<any> {
    console.log(facility);
    return this.http.post<any>(`${this.baseURL}/api/facilities`,facility)
  }

  bookHotel(booking: Booking): Observable<Booking> {
    console.log(booking);
    return this.http.post<Booking>(`${this.baseURL}/bookHotel`, booking);
  }

  findManager(email:string):Observable<any>{
    console.log(email);
    return this.http.get<any>(`${this.baseURL}/byEmail/${email}`);
  }
  findHotel(hotelName:any):Observable<any>{
    console.log(hotelName);
    return this.http.get<any>(`${this.baseURL}/findByName/${hotelName}`);
  }
}
