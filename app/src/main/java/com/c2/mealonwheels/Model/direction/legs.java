package com.c2.mealonwheels.Model.direction;

import java.util.ArrayList;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class legs {
    public ArrayList<com.c2.mealonwheels.Model.direction.steps> steps;

    public legs(ArrayList<com.c2.mealonwheels.Model.direction.steps> steps) {
        this.steps = steps;
    }

    public ArrayList<com.c2.mealonwheels.Model.direction.steps> getSteps() {
        return steps;
    }
}
