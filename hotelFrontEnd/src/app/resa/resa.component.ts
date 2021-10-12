import {Component, forwardRef, OnInit, ViewChild} from '@angular/core';
import {Calendar, CalendarOptions, DateSelectArg, EventClickArg, FullCalendarComponent} from "@fullcalendar/angular";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin from "@fullcalendar/interaction";
import {HttpClient} from "@angular/common/http";
import {Resa} from "../classes/resa";
import {ResaService} from "../services/resa.service";
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";

@Component({
  selector: 'app-resa',
  templateUrl: './resa.component.html',
  styleUrls: ['./resa.component.css']
})
export class ResaComponent implements OnInit {
  r : Resa = new Resa();
  success : boolean = false;
  error : boolean = false;
  search : string = "";
  title = "Réservations";
  @ViewChild( 'closebutton' ) closebuttonelement: any;
/*  success : boolean = false;
  error : boolean = false;*/
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
  constructor(private httpClient: HttpClient, private rs : ResaService, private router : Router) { }

  onDateClick(res : any) {
    alert('You clicked on : ' + res.dateStr)
  }

  ngOnInit(): void {
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
  }
  loadResa() {

  }

  submitForm() {

  }
}
