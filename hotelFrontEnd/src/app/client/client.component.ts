import {Component, OnInit, ViewChild} from '@angular/core';
import {ClientService} from "../services/client.service";
import {Client} from "../classes/client";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  c : Client = new Client();
  clients : Array<Client> = [];

  success : boolean = false;
  error : boolean = false;
  search : string = "";
  @ViewChild( 'closebutton' ) closebuttonelement: any;

  constructor(public cs : ClientService) { }

  ngOnInit(): void
  {
    this.loadClient();
  }

  loadClient(): void
  {
    this.cs.loadClients(this.search).subscribe(
      data => {
        this.clients = data;
      }
    );
  }

  delete(id? : number): void
  {
    if (confirm("Êtes vous sûr de vouloir supprimer ce client ?")){
      this.cs.deleteClient(id).subscribe(
        data => {
          this.loadClient();
          this.success = true;
        }
      );
    }
  }

  resetForm(){
    this.error = false;
    this.success = false;
    this.c = new Client();
  }

  edit(id? : number): void
  {
    console.log(id);
    this.cs.getClient(id).subscribe(
      data => {
        this.c = data;
      }, error => {
        this.error = true;
      }
    )
  }

  submitForm(): void
  {
    if (this.c.id == undefined){
      this.cs.addClient(this.c).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadClient();
          this.success = true;
        }
      )
    } else {
      this.cs.editClient(this.c).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadClient();
          this.success = true;
        }, error => {
          this.error = true;
        }
      )
    }
  }

}
