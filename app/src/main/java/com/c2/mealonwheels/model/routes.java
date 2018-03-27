package com.c2.mealonwheels.model;

import java.util.ArrayList;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class routes {
    public ArrayList<legs> legs;

    public routes(ArrayList<com.c2.mealonwheels.model.legs> legs) {
        this.legs = legs;
    }

    public ArrayList<com.c2.mealonwheels.model.legs> getLegs() {
        return legs;
    }
}
