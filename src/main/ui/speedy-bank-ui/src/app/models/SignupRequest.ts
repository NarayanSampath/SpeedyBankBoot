export class SignUpRequest {
  private _email: string;
  private _password: string;
  private _userName: string;


  constructor(email: string, password: string, userName: string) {
    this._email = email;    this._password = password;    this._userName = userName;
  }

  get email(): string {return this._email; }
  set email(value: string) {this._email = value; }

  get password(): string {return this._password;  }
  set password(value: string) {this._password = value;  }

  get userName(): string {return this._userName;  }
  set userName(value: string) {    this._userName = value; }
}
