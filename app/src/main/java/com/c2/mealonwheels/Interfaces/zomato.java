package com.c2.mealonwheels.Interfaces;

import com.c2.mealonwheels.Model.sear.Main;
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

    @Headers({
            "Accept: application/json",
            "user-key: 79cdcbb8c3eee125c3585f229a790abd"
    })
    @GET("search")
    Call<Main> getrest(@Query("q") String q,
                        @Query("count") String count,
                       @Query("lat") String latitude,
                       @Query("lon") String longitude,
                       @Query("radius") String radius,
                       @Query("cuisines") String cuisines,
                       @Query("sort") String sort,
                       @Query("order") String order);

}
//q=indirapuram&count=8&lat=28.6438232&lon=77.3726377&radius=3000&cuisines=3&sort=cost&order=asc