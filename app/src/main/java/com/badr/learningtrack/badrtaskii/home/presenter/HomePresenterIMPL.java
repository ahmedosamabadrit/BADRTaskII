package com.badr.learningtrack.badrtaskii.home.presenter;

import android.util.Log;

import com.badr.learningtrack.badrtaskii.home.HomeInteractorIMPL;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomeInteractor;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomePresenter;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomeView;
import com.badr.learningtrack.badrtaskii.home.interfaces.OnCallFinishedListener;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class HomePresenterIMPL  implements HomePresenter {

    private HomeView View;

    private HomeInteractor home;
    public HomePresenterIMPL(HomeView view) {
        View = view;
        home =  new HomeInteractorIMPL();
    }

    @Override
    public void readyToGO(Boolean internetStatus) {
        home.getAllUsers(internetStatus, new OnCallFinishedListener() {
            @Override
            public void onSuccess(List<Result> results) {
                Log.d(TAG, "the lis have "+results.size()+"item .");
//                homeView.showUsersData((ArrayList<Result>) results);
                for (int i=0; i<results.size();i++){
                    System.out.println("user email : "+results.get(i).getEmail());
                }
            }

            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: " + error);
            }
        });
    }

}
