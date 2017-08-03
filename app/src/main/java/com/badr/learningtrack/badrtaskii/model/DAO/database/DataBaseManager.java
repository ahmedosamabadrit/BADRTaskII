package com.badr.learningtrack.badrtaskii.model.DAO.database;

import android.util.Log;

import com.badr.learningtrack.badrtaskii.home.listeners.OnCallFinishedLisener;
import com.badr.learningtrack.badrtaskii.model.DAO.database.interfaces.CRUDInterface;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by ahmed-osama on 02/08/17.
 */

public class DataBaseManager implements CRUDInterface {

    public Realm realm;
    public DataBaseManager()
    {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public <T extends RealmModel> void insert(final T dataObject) {
        Log.i("Hello","Interactor  ask the DatabaseManger for the data  ---- 5");

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(dataObject);
                Log.i("Hello", "THe dat is going to save---- 5.1");
            }
        },new Realm.Transaction.OnSuccess(){

            @Override
            public void onSuccess() {
                Log.i("Hello", "onSuccess of realm The Data saved successfully ---- 5.2");
            }
        },new Realm.Transaction.OnError(){

            @Override
            public void onError(Throwable error) {
                Log.i("Hello", "onError of realm Error while saving the Data ---- 5.3" + error.getMessage());
            }
        });
    }

    @Override
    public <T extends RealmModel> void select(Class<T> classType,final OnCallFinishedLisener callback) {
        RealmResults realmResults = realm.where(classType).findAllAsync();
        realmResults.addChangeListener(new RealmChangeListener<RealmResults>() {
            @Override
            public void onChange(RealmResults realmResults) {
                callback.onSuccess(realmResults);
            }
        });
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public <T extends RealmObject> void saveData(final List<T> data) {
        realm.executeTransactionAsync(new Realm.Transaction(){

            @Override
            public void execute(Realm realm) {
                Log.i("Hello", "saving all data int he database using realm ----- 8");
                realm.insertOrUpdate(data);
            }
        });
    }
}
