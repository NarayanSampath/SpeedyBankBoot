import { Component, OnInit } from '@angular/core';
import {SignupService} from '../../services/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
public email = '' ;
public userName = '' ;
public password = '' ;
  constructor(private signupService: SignupService) { }

  ngOnInit() {
  }
public postSignUp() {
    // console.log(JSON.stringify({'email': this.email, 'userName': this.userName, 'password': this.password}));
    this.signupService.signup(JSON.stringify({'email': this.email, 'userName': this.userName, 'password': this.password}));
}

}
