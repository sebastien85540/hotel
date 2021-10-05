package com.m2i.hotelbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reservations")
public class Resa {
    @Id
    @Column(name = "resaId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "client_resa", nullable = false)
    @ManyToOne
    private Client client;

    @JoinColumn(name = "hotel_resa", nullable = false)
    @ManyToOne
    private Hotel hotel;

    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    @Column(name = "num_chambre", nullable = false)
    private int numChambre;

    /**
     * Constructeur par defaut
     */
    public Resa() {
    }

    /**
     * Constructeur surchargé sans ID
     * @param client
     * @param hotel
     * @param dateDebut
     * @param dateFin
     * @param numChambre
     */
    public Resa(Client client, Hotel hotel, Date dateDebut, Date dateFin, int numChambre) {
        this.client = client;
        this.hotel = hotel;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.numChambre = numChambre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }
}
