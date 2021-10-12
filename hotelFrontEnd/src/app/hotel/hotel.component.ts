import {Component, OnInit, ViewChild} from '@angular/core';
import {HotelService} from "../services/hotel.service";
import {Hotel} from "../classes/hotel";

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {
  h : Hotel = new Hotel();
  hotels: Array<Hotel> = [];
  @ViewChild( 'closebutton' ) closebuttonelement: any;
  success : boolean = false;
  error : boolean = false;
  search : string = "";

  constructor(public hs : HotelService) { }

  ngOnInit(): void {
    this.loadHotel();
  }

  loadHotel() {
    this.hs.loadHotels(this.search).subscribe(
      data => {
        this.hotels = data;
      }
    );
  }

  delete(id? : number): void
  {
    if (confirm("Êtest-vous sûr de vouloir supprimer cet hotel ?")){
      this.hs.deleteHotel(id).subscribe(
        data => {
          this.loadHotel();
          this.success = true;
        }
      );
    }
  }

  resetForm(){
    this.error = false;
    this.success = false;
    this.h = new Hotel();
  }

  edit(id? : number): void
  {
    this.hs.getHotel(id).subscribe(
      data => {
        this.h = data;
        this.success = true;
      }
    );
  }

  submitForm(): void
  {
    if (this.h.id == undefined){
      this.hs.addHotel(this.h).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadHotel();
          this.success = true;
        }, error => {
          this.error = true;
        }
      )
    }else {
      this.hs.editHotel(this.h).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadHotel();
          this.success = true;
        }, error => {
          this.error = true;
        }
      );
    }
  }
}
