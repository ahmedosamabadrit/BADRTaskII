package com.badr.learningtrack.badrtaskii.home.interfaces;

import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.List;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface OnCallFinishedListener {
    public void onSuccess(List<Result> users);
    public void onFailure(String Error);
}
