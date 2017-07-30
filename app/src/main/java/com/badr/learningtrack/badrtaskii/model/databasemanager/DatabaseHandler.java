package com.badr.learningtrack.badrtaskii.model.databasemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.badr.learningtrack.badrtaskii.model.databasemanager.UsersContract.UserEntry;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.List;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper implements CRUDInterface{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "stepsManager";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_USERS_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + "("
                + UserEntry._ID + " INTEGER PRIMARY KEY," + UserEntry.COLUMN_DOB + " TEXT,"
                + UserEntry.COLUMN_EMAIL + " TEXT," + UserEntry.COLUMN_GENDER + " TEXT" + UserEntry.COLUMN_TITLE + " TEXT,"
                + UserEntry.COLUMN_FIRST_NAME + " TEXT," + UserEntry.COLUMN_LAST_NAME + " TEXT" + UserEntry.COLUMN_CITY + " TEXT,"+ UserEntry.COLUMN_STREET + " TEXT"
                + UserEntry.COLUMN_STATE + " TEXT," + UserEntry.COLUMN_STREET + " TEXT" + UserEntry.COLUMN_CELL + " TEXT" + UserEntry.COLUMN_PHONE + " TEXT" +")";
        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void addContact(Result contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( UserEntry.COLUMN_TITLE, contact.getName().getTitle()); // Contact Title.
        values.put( UserEntry.COLUMN_FIRST_NAME, contact.getName().getFirst()); // Contact First Name.
        values.put( UserEntry.COLUMN_LAST_NAME, contact.getName().getLast()); // Contact Last Name.
        values.put( UserEntry.COLUMN_DOB, contact.getDob()); // Contact Age.
        values.put( UserEntry.COLUMN_EMAIL, contact.getEmail()); // Contact Email.
        values.put( UserEntry.COLUMN_Image, contact.getPicture().getThumbnail()); // Contact Picture.
        values.put( UserEntry.COLUMN_PHONE, contact.getPhone()); // Contact Phone.
        values.put( UserEntry.COLUMN_CELL, contact.getCell()); // Contact cell.
        values.put( UserEntry.COLUMN_NAt, contact.getNat()); // Contact net.
        values.put( UserEntry.COLUMN_CITY, contact.getLocation().getCity()); // Contact city.
        values.put( UserEntry.COLUMN_STREET, contact.getLocation().getStreet()); // Contact street.
        values.put( UserEntry.COLUMN_STATE, contact.getLocation().getState()); // Contact state.
        values.put( UserEntry.COLUMN_GENDER, contact.getGender()); // Contact Gender.

        // Inserting Row
        db.insert(UserEntry.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    @Override
    public List<Result> getAllContacts() {
        return null;
    }

    @Override
    public int updateContact() {
        return 0;
    }

    @Override
    public void deleteContact() {

    }
}
