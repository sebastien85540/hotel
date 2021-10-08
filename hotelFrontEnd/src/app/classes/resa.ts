import {Client} from "./client";
import {Hotel} from "./hotel";

export class Resa {

  id: number | undefined;
  client: Client | undefined;
  hotel: Hotel | undefined;
  dateDebut: Date | undefined;
  dateFin: Date | undefined;
  numChambre: number | undefined;


  constructor(id?: number, client?: Client, hotel?: Hotel, dateDebut?: Date, dateFin?: Date, numChambre?: number) {
    this.id = id;
    this.client = client;
    this.hotel = hotel;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.numChambre = numChambre;
  }
}
