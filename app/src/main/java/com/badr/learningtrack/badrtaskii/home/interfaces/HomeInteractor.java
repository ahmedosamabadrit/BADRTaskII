package com.badr.learningtrack.badrtaskii.home.interfaces;

import com.badr.learningtrack.badrtaskii.home.listeners.OnCallFinishedLisener;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface HomeInteractor {

    public void getAllUsers(Boolean internetStatus, OnCallFinishedLisener cb);
}
