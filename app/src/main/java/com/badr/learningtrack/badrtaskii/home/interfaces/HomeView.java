package com.badr.learningtrack.badrtaskii.home.interfaces;

import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.ArrayList;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface HomeView {

    public void showUsersData(ArrayList<Result> usersList);
    public ArrayList<Result> getListOfUsers();
}
