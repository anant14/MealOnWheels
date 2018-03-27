package com.c2.mealonwheels.model;

import java.util.ArrayList;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class legs {
    public ArrayList<steps> steps;

    public legs(ArrayList<com.c2.mealonwheels.model.steps> steps) {
        this.steps = steps;
    }

    public ArrayList<com.c2.mealonwheels.model.steps> getSteps() {
        return steps;
    }
}
