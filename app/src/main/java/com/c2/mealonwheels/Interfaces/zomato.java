package com.c2.mealonwheels.Interfaces;

import com.c2.mealonwheels.Model.zomato.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by anant bansal on 3/29/2018.
 */

public interface zomato {
    @Headers({
            "Accept: application/json",
            "user-key: 79cdcbb8c3eee125c3585f229a790abd"
    })
    @GET("geocode")
    Call<main> getRoutes(@Query("lat") String latitude,
                         @Query("lon") String longitude);

}
