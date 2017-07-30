package com.badr.learningtrack.badrtaskii.home.interfaces;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface HomeInteractor {

    public void getAllUsers(Boolean internetStatus, OnCallFinishedListener cb);
}
