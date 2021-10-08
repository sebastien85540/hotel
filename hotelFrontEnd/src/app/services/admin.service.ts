import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {httpOptions} from "../variables";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http : HttpClient) { }

  authenticate(a : any)
  {
    return this.http.post<any>(environment.apiUrl + "login", a, httpOptions)
  }
}
