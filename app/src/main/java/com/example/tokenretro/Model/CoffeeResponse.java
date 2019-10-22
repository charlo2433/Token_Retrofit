package com.example.tokenretro.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoffeeResponse  {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("googlephoto")
    @Expose
    private String googlephoto;
    @SerializedName("usertoken")
    @Expose
    private String usertoken;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("marker")
    @Expose
    private Marker marker;
    @SerializedName("shop")
    @Expose
    private String shop;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("favourite")
    @Expose
    private Boolean favourite;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("price")
    @Expose
    private Double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGooglephoto() {
        return googlephoto;
    }

    public void setGooglephoto(String googlephoto) {
        this.googlephoto = googlephoto;
    }

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}

