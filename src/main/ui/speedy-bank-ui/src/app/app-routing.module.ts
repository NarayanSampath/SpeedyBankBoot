import {RouterModule, Routes} from '@angular/router';
import {SignupComponent} from './components/signup/signup.component';
import { ModuleWithProviders } from '@angular/core';
import {HomeComponent} from './components/home/home.component';
import {SigninComponent} from './components/signin/signin.component';
export const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: SigninComponent},
  ];
export const routingModule: ModuleWithProviders = RouterModule.forRoot(routes);
