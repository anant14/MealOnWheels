package com.c2.mealonwheels.model;

import java.util.ArrayList;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class mDirection {
    public ArrayList<routes> routes;

    public mDirection(ArrayList<com.c2.mealonwheels.model.routes> routes) {
        this.routes = routes;
    }

    public ArrayList<com.c2.mealonwheels.model.routes> getRoutes() {
        return routes;
    }
}
