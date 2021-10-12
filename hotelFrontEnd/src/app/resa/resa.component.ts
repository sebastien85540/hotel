import {Component, forwardRef, OnInit, ViewChild} from '@angular/core';
import {Calendar, CalendarOptions, DateSelectArg, EventClickArg, FullCalendarComponent} from "@fullcalendar/angular";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin from "@fullcalendar/interaction";
import {HttpClient} from "@angular/common/http";
import {Resa} from "../classes/resa";
import {ResaService} from "../services/resa.service";
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";
import {ClientService} from "../services/client.service";
import {HotelService} from "../services/hotel.service";
import {Client} from "../classes/client";
import {Hotel} from "../classes/hotel";

@Component({
  selector: 'app-resa',
  templateUrl: './resa.component.html',
  styleUrls: ['./resa.component.css']
})
export class ResaComponent implements OnInit {
  r : Resa = new Resa();
  reservations : Array<Resa> = [];
  clients : Array<Client> = [];
  hotels : Array<Hotel> = [];
  success : boolean = false;
  error : boolean = false;
  search : string = "";
  title = "Réservations";
  @ViewChild( 'closebutton' ) closebuttonelement: any;

  calendarOptions : CalendarOptions = {
    themeSystem: 'bootstrap',
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
    },
    initialView : "dayGridMonth",
    navLinks: true,
    eventClick: this.handleEventClick.bind(this)
  }
  constructor(private httpClient: HttpClient, private rs : ResaService, private router : Router, private cs : ClientService, private hs : HotelService) { }

  ngOnInit(): void {
    this.loadReservations();
    this.loadClients();
    this.loadHotels();
  }
  loadReservations(): void
  {
    let tableau :  { title: string | undefined; start: Date | undefined, end: Date | undefined, url: string | undefined}[] = []
    this.rs.loadReservations(this.search).subscribe(
      data => {
        for (let r of data){
          let reservation = {
            title: r.client?.nomComplet,
            start : r.dateDebut,
            end: r.dateFin,
            url: 'http://localhost:4200/resa/' +r.id
          }
          tableau.push(reservation);
        }
        this.calendarOptions.events = tableau;
      }
    )
  }
  handleEventClick(clickInfo: EventClickArg) {

    this.router.navigate(['resa/{id}'])
  }
  resetForm(){
    this.error = false;
    this.success = false;
    this.r = new Resa();
  }
  loadResa() {
    this.rs.loadReservations(this.search).subscribe(
      data => {
        this.reservations = data;
      }
    )
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
    this.rs.addReservation(this.r).subscribe(
      data => {
        this.closebuttonelement.nativeElement.click();
        this.loadReservations();
        this.success = true;
      }, error => {
        this.error = true;
      }
    )
  }
}
