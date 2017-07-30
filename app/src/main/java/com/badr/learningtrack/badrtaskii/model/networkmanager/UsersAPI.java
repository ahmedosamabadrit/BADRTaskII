package com.badr.learningtrack.badrtaskii.model.networkmanager;

import com.badr.learningtrack.badrtaskii.model.pojos.UsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface UsersAPI {

    @GET("api/")
    Call<UsersResponse> getUser(@Query("results") int results);
}
