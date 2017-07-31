package com.badr.learningtrack.badrtaskii.home;

import com.badr.learningtrack.badrtaskii.home.interfaces.HomeInteractor;
import com.badr.learningtrack.badrtaskii.home.interfaces.OnCallFinishedListener;
import com.badr.learningtrack.badrtaskii.model.networkmanager.NetWorkManager;

import javax.inject.Inject;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class HomeInteractorIMPL implements HomeInteractor {

    @Inject
    NetWorkManager networkmanager;

    public HomeInteractorIMPL() {
//        networkmanager = NetWorkManager.getInstance();
    }

    @Override
    public void getAllUsers(Boolean internetStatus, OnCallFinishedListener callback) {

        /// if it is true get users from API .
        if(internetStatus)
        {
            /// in the first time the app should save all the user in the database.
            ////////////////////////DOUBY CHeck the message foo2.
            networkmanager.getDataFromAPI(callback);
        }
        /// if it is false get users from Database .
        else
        {

        }
    }
}
