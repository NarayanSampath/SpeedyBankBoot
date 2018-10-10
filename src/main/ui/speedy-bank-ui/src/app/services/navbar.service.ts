import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Imenu} from '../models/menu';



@Injectable({ providedIn: 'root', })
export class NavbarService {
  private menuUrl = '/menu';
  constructor(private http: HttpClient) { }

  getMenu() {
      // return this.http.get<Imenu[]>(this.menuUrl);
    return [
      new Imenu({'menuName': 'Home', 'menuUrl':  '/'}),
      new Imenu({'menuName': 'Sign Up',  'menuUrl': '/signup'}),
      new Imenu({'menuName': 'Sign In',  'menuUrl':  '/login'}),
      new Imenu({'menuName': 'About',   'menuUrl':  '/about'})
    ];
  }
}
