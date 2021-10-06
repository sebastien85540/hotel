package com.m2i.hotelbackend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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
        setClient(client);
        setHotel(hotel);
        setDateDebut(dateDebut);
        setDateFin(dateFin);
        setNumChambre(numChambre);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resa)) return false;
        Resa resa = (Resa) o;
        return getNumChambre() == resa.getNumChambre() && Objects.equals(getId(), resa.getId()) && Objects.equals(getClient(), resa.getClient()) && Objects.equals(getHotel(), resa.getHotel()) && Objects.equals(getDateDebut(), resa.getDateDebut()) && Objects.equals(getDateFin(), resa.getDateFin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getHotel(), getDateDebut(), getDateFin(), getNumChambre());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Resa{");
        sb.append("id=").append(id);
        sb.append(", client=").append(client);
        sb.append(", hotel=").append(hotel);
        sb.append(", dateDebut=").append(dateDebut);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", numChambre=").append(numChambre);
        sb.append('}');
        return sb.toString();
    }
}
