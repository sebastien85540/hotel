export class Client {

  id: number | undefined;
  nomComplet: string | undefined;
  telephone: string | undefined;
  email: string | undefined;
  adresse: string | undefined;


  constructor(id?: number, nomComplet?: string, telephone?: string, email?: string, adresse?: string) {
    this.id = id;
    this.nomComplet = nomComplet;
    this.telephone = telephone;
    this.email = email;
    this.adresse = adresse;
  }
}
