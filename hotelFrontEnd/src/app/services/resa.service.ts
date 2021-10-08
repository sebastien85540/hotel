import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Resa} from "../classes/resa";
import {environment} from "../../environments/environment";
import {httpOptions} from "../variables";

@Injectable({
  providedIn: 'root'
})
export class ResaService {

  constructor(private http : HttpClient) { }

  loadReservations(idResa? : number): Observable<Resa[]> {
    let searchCondition = ""

    if (idResa && idResa > 0) {
      searchCondition = "?resa=" + idResa
    }
    return this.http.get<Resa[]>(environment.apiUrl + "resa" + searchCondition , httpOptions);
  }

  addReservation(resa : Resa): Observable<Resa>
  {
    return this.http.post<Resa>(environment.apiUrl + "resa", resa, httpOptions)
  }

  editReservation(resa : Resa): Observable<Resa>
  {
    return this.http.put<Resa>(environment.apiUrl + "resa/" + resa.id, resa, httpOptions)
  }

  deleteReservation(id? : number): Observable<Resa>
  {
    return this.http.delete<Resa>(environment.apiUrl + "resa/" + id, httpOptions)
  }

  getResa(resaId?: number) {
    return this.http.get<Resa>(environment.apiUrl + "resa/" + resaId, httpOptions)

  }
}
