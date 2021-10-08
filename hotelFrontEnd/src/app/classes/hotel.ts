export class Hotel {

  id: number | undefined;
  nom: string | undefined;
  etoiles: string | undefined;
  adresse: string | undefined;
  telephone: string | undefined;
  email: string | undefined;
  ville: string | undefined;


  constructor(id?: number, nom?: string, etoiles?: string, adresse?: string, telephone?: string, email?: string, ville?: string) {
    this.id = id;
    this.nom = nom;
    this.etoiles = etoiles;
    this.adresse = adresse;
    this.telephone = telephone;
    this.email = email;
    this.ville = ville;
  }
}
