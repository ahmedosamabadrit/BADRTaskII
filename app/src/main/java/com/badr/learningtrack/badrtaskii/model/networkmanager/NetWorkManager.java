package com.badr.learningtrack.badrtaskii.model.networkmanager;

import android.util.Log;

import com.badr.learningtrack.badrtaskii.home.interfaces.OnCallFinishedListener;
import com.badr.learningtrack.badrtaskii.model.pojos.UsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class NetWorkManager {

    public static final int NUMBER_OF_USERS = 100;
    private UsersAPI getAPI;

    //create an object of SingleObject
    private static NetWorkManager instance = null;

    //make the constructor private so that this class cannot be
    //instantiated
    private NetWorkManager() {
    }

    //Get the only object available
    public static NetWorkManager getInstance() {
        if (instance == null) instance = new NetWorkManager();
        return instance;
    }


    public void getDataFromAPI(final OnCallFinishedListener callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getAPI = retrofit.create(UsersAPI.class);

        Call<UsersResponse> call = getAPI.getUser(NUMBER_OF_USERS);
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                if (response.code() != 200) {
                    if (response.code() == 404) {
                        Log.i("onResponse", "Hello 404");
                    } else {
                        Log.i("onResponse", "Something is Wrong");
                    }
                } else {
                    Log.i("onResponse", "There is a data");
                    callBack.onSuccess(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                Log.i("onResponse", "There is no data");
                callBack.onFailure(t.getMessage());
            }

        });
    }
}