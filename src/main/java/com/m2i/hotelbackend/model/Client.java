package com.m2i.hotelbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "clientId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_complet", nullable = false)
    private String nomComplet;

    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "adresse", nullable = false)
    private String adresse;


    /**
     * Constructeur par defaut
     */
    public Client() {
    }

    /**
     * Constructeur surchargé sans l'ID
     * @param nomComplet
     * @param telephone
     * @param email
     * @param adresse
     */
    public Client(String nomComplet, String telephone, String email, String adresse) {
        setNomComplet(nomComplet);
        setTelephone(telephone);
        setEmail(email);
        setAdresse(adresse);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getNomComplet(), client.getNomComplet()) && Objects.equals(getTelephone(), client.getTelephone()) && Objects.equals(getEmail(), client.getEmail()) && Objects.equals(getAdresse(), client.getAdresse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomComplet(), getTelephone(), getEmail(), getAdresse());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nomComplet='").append(nomComplet).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", adresse='").append(adresse).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
