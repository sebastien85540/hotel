import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../classes/client";
import {environment} from "../../environments/environment";
import {httpOptions} from "../variables";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http : HttpClient) { }

  loadClients(search?: string): Observable<Client[]>
  {
    let searchCondition = "";
    if (search != undefined && search.length > 0){
      searchCondition = "?search=" + search;
    }
    return this.http.get<Client[]>(environment.apiUrl + "client" + searchCondition, httpOptions);
  }

  getClient(id? : number): Observable<Client>
  {
    return this.http.get<Client>(environment.apiUrl + "client/" + id, httpOptions);
  }

  addClient(client : Client): Observable<Client>
  {
    return this.http.post<Client>(environment.apiUrl + "client", client, httpOptions);
  }

  editClient(client : Client): Observable<Client>
  {
    return this.http.put<Client>(environment.apiUrl + "client/" + client.id, client, httpOptions);
  }

  deleteClient(id? : number): Observable<any>
  {
    return this.http.delete(environment.apiUrl + "client/" + id, httpOptions);
  }
}
