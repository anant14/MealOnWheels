package com.c2.mealonwheels.Model;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class start_location {
    public double lat;
    public double lng;

    public start_location(int lat, int lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
