package com.c2.mealonwheels.model;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class start_location {
    public int lat;
    public int lng;

    public start_location(int lat, int lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }
}
