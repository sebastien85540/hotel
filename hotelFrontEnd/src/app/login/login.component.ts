import { Component, OnInit } from '@angular/core';
import {AdminService} from "../services/admin.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error : boolean = false;

  a = {
    userName: "",
    password: ""
  };

  constructor(private as : AdminService, private router : Router) { }

  ngOnInit(): void {
  }
  authenticate() {
    this.as.authenticate(this.a).subscribe(
      data => {
        console.log(data)
        if (data.id > 0) {
          sessionStorage.setItem("connectedUser" , data );
          console.log("redirection");
          this.router.navigate(['resa'])
        }else{
          this.error = true;
        }
      } ,
      error => {
        this.error = true;
      }
    );
  }
}
