package com.c2.mealonwheels.model;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class steps {
    public distance distance;
    public duration duration;
    public start_location start_location;
    public String html_instructions;

    public steps(com.c2.mealonwheels.model.distance distance, com.c2.mealonwheels.model.duration duration, com.c2.mealonwheels.model.start_location start_location, String html_instructions) {
        this.distance = distance;
        this.duration = duration;
        this.start_location = start_location;
        this.html_instructions = html_instructions;
    }

    public com.c2.mealonwheels.model.distance getDistance() {
        return distance;
    }

    public void setDistance(com.c2.mealonwheels.model.distance distance) {
        this.distance = distance;
    }

    public com.c2.mealonwheels.model.duration getDuration() {
        return duration;
    }

    public void setDuration(com.c2.mealonwheels.model.duration duration) {
        this.duration = duration;
    }

    public com.c2.mealonwheels.model.start_location getStart_location() {
        return start_location;
    }

    public void setStart_location(com.c2.mealonwheels.model.start_location start_location) {
        this.start_location = start_location;
    }

    public String getHtml_instructions() {
        return html_instructions;
    }

    public void setHtml_instructions(String html_instructions) {
        this.html_instructions = html_instructions;
    }
}
