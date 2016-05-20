package com.clubsis.model.club;


import javax.persistence.*;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Club {
    @Id
    @GeneratedValue
    @Column(name="id_club")
    private Integer idClub;
    private String nombreClub;
    //private Image Logo

    protected Club() {
    }

    public Club(String nombreClub) {
        this.nombreClub = nombreClub;
        //this.logo = logo;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    /*public Image getLogo() {
        return logo;
    }*/

    /*public void setLogo(Image logo) {
        this.logo = logo;
    }*/
}
