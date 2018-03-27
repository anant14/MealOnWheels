package com.c2.mealonwheels.Model;

import java.util.ArrayList;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class legs {
    public ArrayList<steps> steps;

    public legs(ArrayList<com.c2.mealonwheels.Model.steps> steps) {
        this.steps = steps;
    }

    public ArrayList<com.c2.mealonwheels.Model.steps> getSteps() {
        return steps;
    }
}
