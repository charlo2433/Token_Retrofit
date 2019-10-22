package com.example.tokenretro.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Marker {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("coords")
    @Expose
    private Coords coords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }


}
