import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationGuard} from "../authentication.guard";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router : Router, public guard : AuthenticationGuard) { }

  ngOnInit(): void {
  }

  onLogout(): void
  {
    sessionStorage.removeItem("connectedUser");
    this.router.navigate(['login']);
  }
}
