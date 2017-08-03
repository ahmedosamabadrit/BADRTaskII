package com.badr.learningtrack.badrtaskii.home;

import android.util.Log;

import com.badr.learningtrack.badrtaskii.home.interfaces.HomeInteractor;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomePresenter;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomeView;
import com.badr.learningtrack.badrtaskii.home.listeners.OnCallFinishedLisener;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.List;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class HomePresenterIMPL implements HomePresenter {

    private HomeView view;

    @Inject
    HomeInteractor interactor;

    public HomePresenterIMPL(HomeView view,HomeInteractor interactor) {
        this.interactor  = interactor;
        this.view = view;
    }

    @Override
    public void readyToGO(Boolean internetStatus) {
        /// Showing the progress Dialog.
        Log.i("Hello", "presenter ask view to show progress bar ----- 2");

//        view.showProgressDialog();
        Log.i("Hello", "Presenter ask Interactor for the data nad send a Listener wth him  ----- 4");

        interactor.getAllUsers(internetStatus, new OnCallFinishedLisener() {
            @Override
            public void onSuccess(List<Result> results) {
                view.showUsersData(results);
                view.HideProgressDialog();
            }
            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: " + error);

                view.HideProgressDialog();
                view.showAlert("Server is Down","Please try again latter");
            }

        });
    }
}
