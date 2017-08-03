package com.badr.learningtrack.badrtaskii.home.listeners;

import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.List;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface OnCallFinishedLisener {

    public void onSuccess(List<Result> results);
    public void onFailure(String error);
}
