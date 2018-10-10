import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SignUpRequest} from '../models/SignupRequest';



@Injectable({
  providedIn: 'root'
})
export class SignupService {
private _URL = '/api/signup';
  constructor(private http: HttpClient, private req: SignUpRequest) { }

  public signup(req) {
    this.http.post(this._URL, this.req).subscribe(data => console.log(data));
  }
}
