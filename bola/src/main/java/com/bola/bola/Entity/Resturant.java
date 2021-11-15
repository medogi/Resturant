package com.bola.bola.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import  javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resturant")
public class Resturant {
    @Id
    @Column(name = "id")
    private int Id;
    @Column(name = "name")
    private String Name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resturant", orphanRemoval = true)
    private List<Review> reviews;

    public Resturant(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;

    }

    public Resturant() {

    }





    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
