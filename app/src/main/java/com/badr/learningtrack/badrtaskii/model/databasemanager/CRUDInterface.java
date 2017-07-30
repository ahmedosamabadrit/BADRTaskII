package com.badr.learningtrack.badrtaskii.model.databasemanager;

import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.List;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public interface CRUDInterface {

    public void addContact(Result contact);
    public List<Result> getAllContacts();
    public int updateContact();
    public void deleteContact();
}
