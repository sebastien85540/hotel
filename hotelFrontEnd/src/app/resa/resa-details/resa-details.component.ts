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
  clients : Array<Client> = [];
  hotels : Array<Hotel> = [];
  @ViewChild( 'closebutton' ) closebuttonelement: any;
  success: boolean = false;
  error : boolean = false;

  constructor(private rs : ResaService, private router : Router, private activateRoute : ActivatedRoute, private cs : ClientService, private hs : HotelService) { }

  ngOnInit(): void {
      this.loadResa();

      this.loadClients();
      this.loadHotels();
    }


  loadResa(): void
  {
    let resaId = Number(this.activateRoute.snapshot.paramMap.get('id'))
    if (resaId > 0){
      this.rs.getResa(resaId).subscribe(
        data => {
          this.resa = data;
        }
      )
    }
  }

  loadClients(): void
  {
    this.cs.loadClients().subscribe(
      data => {
        this.clients = data;
      }
    )
  }

  loadHotels(): void
  {
    this.hs.loadHotels().subscribe(
      data => {
        this.hotels = data;
      }
    )
  }
  submitForm() {
    this.rs.editReservation(this.resa).subscribe(
      data => {
        this.closebuttonelement.nativeElement.click();
        this.loadResa();
        this.success = true;
      }
    )
  }

  edit(id?: number) {
    this.rs.getResa(id).subscribe(
      data => {
        console.log(this.resa);
        this.resa = data;
        this.success = true
      }, error => {
        this.error = true;
      }
    )
  }

  delete(id?: number) {
    if (confirm("Êtes-vous sûr de vouloir supprimer cette réservation ?")){
      this.rs.deleteReservation(id).subscribe(
        data => {
          this.router.navigate(['resa']);
          this.success = true;
        }, error => {
          this.error = true;
        }
      )
    }
  }

  checkHotel(h1 : Hotel, h2 : Hotel): boolean
  {
    return h1 != undefined && h2 != undefined && h1.id == h2.id;
  }

  checkClient(c1 : Hotel, c2 : Hotel): boolean
  {
    return c1 != undefined && c2 != undefined && c1.id == c2.id;
  }

}
