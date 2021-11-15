package com.bola.bola.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewDTO {
    @JsonProperty("id")
    private int Id;
    @JsonProperty("rateing")
    private int Rateing;
    @JsonProperty("date")
    private int Date;
    @JsonProperty("resturantId")
    private int ResturantId;

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

    public int getResturantId() {
        return ResturantId;
    }

    public void setResturantId(int resturantId) {
        ResturantId = resturantId;
    }
}
