package com.m2i.hotelbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name = "hotelId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "etoiles", nullable = false, length = 1)
    private String etoiles;

    @Column(name = "adresse", nullable = false) // length a une valeur par defaut à 255
    private String adresse;

    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ville", nullable = false)
    private String ville;

    /**
     * Constructeur par defaut
     */
    public Hotel() {
    }

    /**
     * Constructeur surchargé sans l'id
     * @param nom
     * @param etoiles
     * @param adresse
     * @param telephone
     * @param email
     * @param ville
     */
    public Hotel(String nom, String etoiles, String adresse, String telephone, String email, String ville) {
        setNom(nom);
        setEtoiles(etoiles);
        setAdresse(adresse);
        setTelephone(telephone);
        setEmail(email);
        setVille(ville);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(String etoiles) {
        this.etoiles = etoiles;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(getId(), hotel.getId()) && Objects.equals(getNom(), hotel.getNom()) && Objects.equals(getEtoiles(), hotel.getEtoiles()) && Objects.equals(getAdresse(), hotel.getAdresse()) && Objects.equals(getTelephone(), hotel.getTelephone()) && Objects.equals(getEmail(), hotel.getEmail()) && Objects.equals(getVille(), hotel.getVille());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getEtoiles(), getAdresse(), getTelephone(), getEmail(), getVille());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", etoiles='").append(etoiles).append('\'');
        sb.append(", adresse='").append(adresse).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
