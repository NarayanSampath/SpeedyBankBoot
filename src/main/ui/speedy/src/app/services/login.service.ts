import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginRequest} from '../models/LoginRequest';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _URL = '/login';
  constructor(private http: HttpClient) { }

  login(loginRequest: LoginRequest) {
      this.http.post<LoginRequest>(this._URL, loginRequest).subscribe(data => console.log(data));
    }
}
