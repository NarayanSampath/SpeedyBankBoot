import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SignupComponent} from './components/signup/signup.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';

import {HttpClientModule} from '@angular/common/http';
import {routingModule} from './app-routing.module';
import {NavbarService} from './services/navbar.service';
import {SignupService} from './services/signup.service';
import {LoginService} from './services/login.service';
import {FormsModule} from '@angular/forms';
import {ToastaModule} from 'ngx-toasta';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AdmindashComponent } from './components/admindash/admindash.component';

@NgModule({
  declarations: [
    AppComponent, SignupComponent, HomeComponent, LoginComponent, DashboardComponent, ProfileComponent, AdmindashComponent
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule, routingModule , HttpClientModule, FormsModule, ToastaModule.forRoot()
  ],
  providers: [NavbarService, SignupService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
