package com.c2.mealonwheels.Interfaces;

import com.c2.mealonwheels.Model.mDirection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anant bansal on 3/27/2018.
 */

public interface direction {

    @GET("json")
    Call<mDirection> getRoutes(@Query("origin") String origin,
                               @Query("destination") String destination,
                               @Query("key") String key);

}
