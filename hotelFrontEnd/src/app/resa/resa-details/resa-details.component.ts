import {Component, OnInit, ViewChild} from '@angular/core';
import {Resa} from "../../classes/resa";
import {ResaService} from "../../services/resa.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../../services/client.service";
import {HotelService} from "../../services/hotel.service";
import {Client} from "../../classes/client";
import {Hotel} from "../../classes/hotel";

@Component({
  selector: 'app-resa-details',
  templateUrl: './resa-details.component.html',
  styleUrls: ['./resa-details.component.css']
})
export class ResaDetailsComponent implements OnInit {

  resa : Resa = new Resa();
  reservations: Array<Resa> = [];
  clients : Array<Client> = [];
  hotels : Array<Hotel> = [];
  @ViewChild( 'closebutton' ) closebuttonelement: any;
  success: boolean = false;
  error : boolean = false;

  constructor(private rs : ResaService, private router : Router, private activateRoute : ActivatedRoute, private cs : ClientService, private hs : HotelService) { }

  ngOnInit(): void {
    // tableau de clients
    this.cs.loadClients().subscribe(
      data => {
        this.clients = data;
      }
    )
    // tableau d'hotels
    this.hs.loadHotels().subscribe(
      data => {
        this.hotels = data;
      }
    )
    // récupération de la réservation
    let resaId = Number(this.activateRoute.snapshot.paramMap.get('id'));
    if (resaId > 0){
      this.rs.getResa(resaId).subscribe(
        data => {this.resa = data}
      )
    }
    this.rs.loadReservations().subscribe(
      data => {
        this.reservations = data;
      }
    )
  }

  resetForm() {
    this.success = false;
    this.error = false;
    this.resa = new Resa();
  }

  submitForm() {

  }

  edit(id?: number) {

  }

  delete(id?: number) {

  }
}
