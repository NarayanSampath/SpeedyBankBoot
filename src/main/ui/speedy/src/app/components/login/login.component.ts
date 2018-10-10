import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginService} from '../../services/login.service';
import {LoginRequest} from '../../models/LoginRequest';

@Component({
  selector: 'app-signin',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  password: string;
  constructor(private service: LoginService) { }

  ngOnInit() {
  }

  loginReq() {

    this.service.login(new LoginRequest(this.email, this.password));
  }
}
