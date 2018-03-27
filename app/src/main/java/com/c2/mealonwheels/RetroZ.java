package com.c2.mealonwheels;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class RetroZ{
    public static Retrofit getClient()
    {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/directions/json?")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
