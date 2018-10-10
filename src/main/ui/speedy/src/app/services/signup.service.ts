import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SignUpRequest} from '../models/SignupRequest';



@Injectable({
  providedIn: 'root'
})
export class SignupService {
private _URL = '/signup';
  constructor(private http: HttpClient) {}

  public signup(request: SignUpRequest) {
    console.log(request);
    this.http.post<SignUpRequest>(this._URL, request).subscribe(data => console.log(data));
  }
}
