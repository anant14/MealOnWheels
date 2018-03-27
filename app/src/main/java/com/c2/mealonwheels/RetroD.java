package com.c2.mealonwheels;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class RetroD {
    public static Retrofit getClient()
    {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/directions/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
//https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=YOUR_API_KEY
//api key=AIzaSyAGu_nRnhMchikhik8YciI7F7Zowhx0Tjs;