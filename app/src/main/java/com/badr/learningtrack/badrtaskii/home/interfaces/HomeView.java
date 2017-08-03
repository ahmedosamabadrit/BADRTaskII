package com.badr.learningtrack.badrtaskii.home.interfaces;

import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.List;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface HomeView {

    public void showUsersData(List<Result> usersList);
    public void showProgressDialog();
    public void HideProgressDialog();
    public void showAlert(String Title, String Message);
}
