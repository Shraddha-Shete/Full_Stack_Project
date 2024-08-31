import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { register } from 'module';
import { UserRegister } from './user-register';
import { Observable, map } from 'rxjs';
import { HotelDetails } from './hotel-details';
import { Facility } from './facility';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  baseURL= "http://localhost:8085"
  constructor(private http:HttpClient) { }

  saveUser(userRegister:UserRegister):Observable<any>{
    console.log("service");
    return this.http.post<any>(`${this.baseURL}/save`,userRegister, {responseType:'json'});
  }

  loginPage(email:string, password:string, role:String):Observable<any>{
    let bodyData = {
      email: email,
      password:password,
    }; 
    console.log(email, password);
    if(role=="Manager"){
      return this.http.post<any>(`${this.baseURL}/loginManager`, bodyData);
    }
    else{
    return this.http.post<any>(`${this.baseURL}/login`, bodyData);
    }
    
    }

    getHotels(): Observable<HotelDetails[]> {
      console.log(HotelDetails);
      return this.http.get<HotelDetails[]>(`${this.baseURL}/findAll`);
    }

    getImage(filename: string): Observable<any> {
      return this.http.get(`${this.baseURL}/image/${filename}`);
    }
    
    getHotelById(id: number): Observable<HotelDetails> {
      return this.http.get<HotelDetails>(`${this.baseURL}/find/${id}`)
    }

    getFacility(hotelId:number):Observable<any>{
      return this.http.get<any>(`${this.baseURL}/hotel/${hotelId}`);
    }

    getUserBooking(userEmail:string):Observable<any>{
      console.log(userEmail);
      return this. http.get<any>(`${this.baseURL}/UserBooking/${userEmail}`);
    }

}
