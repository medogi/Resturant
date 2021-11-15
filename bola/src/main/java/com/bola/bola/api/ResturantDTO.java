package com.bola.bola.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResturantDTO {
    @JsonProperty("id")
    private int Id;
    @JsonProperty("name")
    private String Name;
    @JsonProperty("reviewDto")
    private List<ReviewDTO> reviewDTOS;

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

    public List<ReviewDTO> getReviewDTOS() {
        return reviewDTOS;
    }

    public void setReviewDTOS(List<ReviewDTO> reviewDTOS) {
        this.reviewDTOS = reviewDTOS;
    }
}
