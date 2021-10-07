import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationGuard} from "./authentication.guard";

const routes: Routes = [
  {path: 'client', canActivate: [AuthenticationGuard]},
  {path: 'hotel', canActivate: [AuthenticationGuard]},
  {path: 'resa', canActivate: [AuthenticationGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
