package com.bola.bola.Entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id")
    private int Id;
    @Column(name = "rateing")
    private int Rateing;
    @Column(name = "date")
    private int Date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resturant_id", nullable = false)
    Resturant resturant;

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getRateing() {
        return Rateing;
    }

    public void setRateing(int rateing) {
        Rateing = rateing;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }
}
