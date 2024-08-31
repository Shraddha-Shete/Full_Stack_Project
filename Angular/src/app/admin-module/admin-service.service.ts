import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegister } from '../user-register';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  baseURL= "http://localhost:8085"
  constructor(private http:HttpClient) { }

    addLocation(Places:any):Observable<any>{
      console.log(Places.place);
      return this.http.post<any>(`${this.baseURL}/addLoc`,Places)
    }
    getManagerByAdminName(adminName: string): Observable<any> {
      return this.http.get(`${this.baseURL}/byAdminName/${adminName}`);
    }

    addHotel(hotel: any, images: File[]):Observable<any>{
      const formData: FormData = new FormData();
    formData.append('addHotel', JSON.stringify(hotel));
    formData.append('image1', images[0]);
    formData.append('image2', images[1]);
    formData.append('image3', images[2]);

    return this.http.post(`${this.baseURL}/addHotel`, formData);
  }

  registerManager( userRegister:any): Observable<any> {
    console.log(userRegister);
    return this.http.post(`${this.baseURL}/saveManager`, userRegister);
  }

  associateHotelWithManager(managerId: number, hotelId: number): Observable<any> {
    return this.http.post(`${this.baseURL}/${managerId}/associateHotel/${hotelId}`, {});
  }

  findAllBookings():Observable<any>{
    return this.http.get(`${this.baseURL}/listOfBooking`);
  }

  findById(id:any):Observable<any>{
    console.log(id);
    return this.http.get(`${this.baseURL}/find/${id}`);
  }

  findBookingByHotelId(id:any):Observable<any>{
    console.log(id);
    return this.http.get(`${this.baseURL}/booking/${id}`);
  }
}
