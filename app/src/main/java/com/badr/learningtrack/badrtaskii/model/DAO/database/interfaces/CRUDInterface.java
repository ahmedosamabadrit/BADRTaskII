package com.badr.learningtrack.badrtaskii.model.DAO.database.interfaces;

import com.badr.learningtrack.badrtaskii.home.listeners.OnCallFinishedLisener;

import java.util.List;

import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface CRUDInterface {

    // CRUD methods for list or Record.
    public <T extends RealmModel> void insert(T dataObject);
    public <T extends RealmObject> void saveData(final List<T> data) ;
    public <T extends RealmModel> void select(Class<T> classType , OnCallFinishedLisener callback);
    public void update();
    public void delete();
}
