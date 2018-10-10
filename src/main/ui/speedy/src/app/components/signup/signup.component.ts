import {Component, OnInit} from '@angular/core';
import {SignupService} from '../../services/signup.service';
import {SignUpRequest} from '../../models/SignupRequest';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public email = '';
  public userName = '';
  public password = '';

  constructor(private service: SignupService) {
  }

  ngOnInit() {
  }

  public postSignUp() {
    const req: SignUpRequest = new SignUpRequest();
    req._userName = this.userName;
    req._email = this.email;
    req._password = this.password;
    this.service.signup(req);
  }
}
