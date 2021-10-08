import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationGuard} from "./authentication.guard";
import {LoginComponent} from "./login/login.component";
import {ResaComponent} from "./resa/resa.component";
import {ResaDetailsComponent} from "./resa/resa-details/resa-details.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'resa', component: ResaComponent, canActivate: [AuthenticationGuard], children:[
      {path: ':id', component: ResaDetailsComponent}
    ]},
/*  {path: 'client', canActivate: [AuthenticationGuard]},
  {path: 'hotel', canActivate: [AuthenticationGuard]},*/
  {path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
