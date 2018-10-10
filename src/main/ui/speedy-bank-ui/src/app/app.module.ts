import { AppComponent } from './app.component';

import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './components/signup/signup.component';
import { SigninComponent } from './components/signin/signin.component';
import { HomeComponent } from './components/home/home.component';

import {NavbarService} from './services/navbar.service';

import {
  MatCheckboxModule,
  MatButtonModule,
  MatSlideToggleModule,
  MatToolbarModule,
  MatFormFieldModule,
  MatInputModule
} from '@angular/material';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {routingModule} from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent, NavbarComponent, SignupComponent, HomeComponent, SigninComponent
  ],
  imports: [
    MatCheckboxModule, MatSlideToggleModule, MatToolbarModule, MatButtonModule, MatFormFieldModule, MatInputModule,
    BrowserModule, routingModule , HttpClientModule, BrowserAnimationsModule,
  ],
  providers: [NavbarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
