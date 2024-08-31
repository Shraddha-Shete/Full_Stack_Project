import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, catchError, map, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentManager: any = null;
  private userEmail!: string;
 
  constructor(private route:Router, private http: HttpClient) { }
  setUserEmail(email: string) {
    console.log("Email :"+email);
    this.userEmail = email;
  }

  getUserEmail(): string {
    console.log("userEmail : "+this.userEmail);
    return this.userEmail;
  }

  private loggedIn = new BehaviorSubject<boolean>(false);
  private loggedInManag = new BehaviorSubject<boolean>(false);
  private loggedInAdm = new BehaviorSubject<boolean>(false);

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }
  get isloggedInManag(){
    return this.loggedInManag.asObservable();
  }
  get isLoggedInAdm() {
    return this.loggedInAdm.asObservable();
  }

  login(user:String) {
    if (typeof window !== 'undefined' && window.localStorage) {
    if(user=='Customer'){
    this.loggedIn.next(true);
    
    }
    else if(user=='Manager'){
      this.loggedInManag.next(true);
      
    }
    else if (user === 'Admin') {
      this.loggedInAdm.next(true);
     
    }
  }
  }

  logout() {
    if (typeof window !== 'undefined' && window.localStorage) {
    this.loggedIn.next(false);
    this.loggedInManag.next(false);
    this.loggedInAdm.next(false);
    this.route.navigate(['home']);
    }

  }

  fetchLoggedInManager(): Observable<any> {
    return this.http.get<any>('http://localhost:8085/current-manager', { withCredentials: true }) // Replace with your backend endpoint
      .pipe(
        map(manager => {
          this.currentManager = manager;
          return manager;
        }),
        catchError(err => {
          console.error('Error fetching manager details', err);
          return of(null);
        })
      );
  }

  getLoggedInManagerId(): number | null {
    return this.currentManager ? this.currentManager.id : null;
  }
  
}
