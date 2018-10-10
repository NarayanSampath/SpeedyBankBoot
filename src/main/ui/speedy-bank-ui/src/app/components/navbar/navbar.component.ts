import { Component, OnInit } from '@angular/core';
import {NavbarService} from '../../services/navbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public menu;
  constructor(private navbarService: NavbarService) {}
  ngOnInit() {
    this.menu = this.navbarService.getMenu();
    // this.navbarService.getMenu().subscribe(data => this.menu = data);
  }
}
