package com.badr.learningtrack.badrtaskii.home;

import android.util.Log;

import com.badr.learningtrack.badrtaskii.home.interfaces.HomeInteractor;
import com.badr.learningtrack.badrtaskii.home.listeners.OnCallFinishedLisener;
import com.badr.learningtrack.badrtaskii.model.DAO.api_services.NetWorkManager;
import com.badr.learningtrack.badrtaskii.model.DAO.database.DataBaseManager;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class HomeInteractorIMPL implements HomeInteractor {


    private DataBaseManager dataBaseManager;

    private NetWorkManager networkmanager;

    public HomeInteractorIMPL() {
        networkmanager = NetWorkManager.getInstance();
        dataBaseManager=  new DataBaseManager();
    }

    @Override
    public void getAllUsers(Boolean internetStatus, OnCallFinishedLisener callback) {

        /// if it is true get users from API .
        if(internetStatus)
        {
            Log.i("Hello", "Interactor ask the api service for a data and pass the call back from the presenter to the API manager----- 5 "+internetStatus);

            networkmanager.getDataFromAPI(callback);
        }
        /// if it is false get users from Database .
        else
        {
            Log.i("Hello", "Getting data from the database----- 5"+internetStatus);

            dataBaseManager.select(Result.class,callback);
        }
    }
}
