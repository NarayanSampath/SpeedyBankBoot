import {RouterModule, Routes} from '@angular/router';
import {SignupComponent} from './components/signup/signup.component';
import {ModuleWithProviders} from '@angular/core';
import {LoginComponent} from './components/login/login.component';
import {ProfileComponent} from './components/profile/profile.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {AdmindashComponent} from './components/admindash/admindash.component';
export const routes: Routes = [
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'admindash', component: AdmindashComponent},
];
export const routingModule: ModuleWithProviders = RouterModule.forRoot(routes);
