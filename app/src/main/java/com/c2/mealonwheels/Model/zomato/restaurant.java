package com.c2.mealonwheels.Model.zomato;

/**
 * Created by anant bansal on 3/29/2018.
 */

public class restaurant {
    public String name;
    public int average_cost_for_two;
    public String cuisines;
    public user_rating user_rating;
    public location location;
    public String featured_image;

    public restaurant(String featured_image) {
        this.featured_image = featured_image;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public restaurant(String name, int average_cost_for_two, String cuisines, user_rating user_rating, location location) {
        this.name = name;
        this.average_cost_for_two = average_cost_for_two;
        this.cuisines = cuisines;
        user_rating = user_rating;
        location = location;
    }

    public String getName() {
        return name;
    }

    public int getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public String getCuisines() {
        return cuisines;
    }

    public user_rating getUser_rating() {
        return user_rating;
    }

    public location getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAverage_cost_for_two(int average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public void setUser_rating(user_rating user_rating) {
        user_rating = user_rating;
    }

    public void setLocation(location location) {
        location = location;
    }
}
