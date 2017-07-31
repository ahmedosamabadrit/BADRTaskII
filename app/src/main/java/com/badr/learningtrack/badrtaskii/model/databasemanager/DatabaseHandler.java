package com.badr.learningtrack.badrtaskii.model.databasemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.badr.learningtrack.badrtaskii.model.databasemanager.UsersContract.UserEntry;
import com.badr.learningtrack.badrtaskii.model.pojos.Location;
import com.badr.learningtrack.badrtaskii.model.pojos.Name;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.ArrayList;
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

        String CREATE_USERS_TABLE = "CREATE TABLE "
                + UserEntry.TABLE_NAME + "("
                + UserEntry._ID + " INTEGER PRIMARY KEY,"
                + UserEntry.COLUMN_TITLE + " TEXT,"
                + UserEntry.COLUMN_FIRST_NAME + " TEXT,"
                + UserEntry.COLUMN_LAST_NAME + " TEXT"
                + UserEntry.COLUMN_DOB + " TEXT,"
                + UserEntry.COLUMN_EMAIL + " TEXT,"
                + UserEntry.COLUMN_PHONE + " TEXT"
                + UserEntry.COLUMN_CELL + " TEXT"
                + UserEntry.COLUMN_NAt + " TEXT"
                + UserEntry.COLUMN_CITY + " TEXT,"
                + UserEntry.COLUMN_STREET + " TEXT"
                + UserEntry.COLUMN_STATE + " TEXT,"
                + UserEntry.COLUMN_GENDER + " TEXT"

                +")";
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
        values.put( UserEntry.COLUMN_TITLE, contact.getName().getTitle()); // Contact Title.1
        values.put( UserEntry.COLUMN_FIRST_NAME, contact.getName().getFirst()); // Contact First Name.2
        values.put( UserEntry.COLUMN_LAST_NAME, contact.getName().getLast()); // Contact Last Name.3
        values.put( UserEntry.COLUMN_DOB, contact.getDob()); // Contact Age.4
        values.put( UserEntry.COLUMN_EMAIL, contact.getEmail()); // Contact Email.5
//        values.put( UserEntry.COLUMN_Image, contact.getPicture().getThumbnail()); // Contact Picture.6
        values.put( UserEntry.COLUMN_PHONE, contact.getPhone()); // Contact Phone.7
        values.put( UserEntry.COLUMN_CELL, contact.getCell()); // Contact cell.8
        values.put( UserEntry.COLUMN_NAt, contact.getNat()); // Contact net.9
        values.put( UserEntry.COLUMN_CITY, contact.getLocation().getCity()); // Contact city.10
        values.put( UserEntry.COLUMN_STREET, contact.getLocation().getStreet()); // Contact street.11
        values.put( UserEntry.COLUMN_STATE, contact.getLocation().getState()); // Contact state.12
        values.put( UserEntry.COLUMN_GENDER, contact.getGender()); // Contact Gender.13

        // Inserting Row
        db.insert(UserEntry.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    @Override
    public List<Result> getAllContacts() {
        Name name;
        Location location;
        Result contact;
        List<Result> contactList = new ArrayList<Result>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + UserEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                // Create objects
                name = new Name();
                location = new Location();
                contact = new Result();

                // Setting the Name
                name.setTitle(cursor.getString(0));
                name.setFirst(cursor.getString(1));
                name.setLast(cursor.getString(2));

                /// Setting the name object .
                contact.setName(name);

                location.setCity(cursor.getString(10));
                location.setStreet(cursor.getString(11));
                location.setState(cursor.getString(12));

                // Setting the name object .
                contact.setLocation(location);

                // Setting the DOB
                contact.setDob(cursor.getString(4));
                // Setting the Email.
                contact.setEmail(cursor.getString(5));
                // Setting the Gender.
                contact.setGender(cursor.getString(13));
                // Setting the Phone.
                contact.setPhone(cursor.getString(7));
                // Setting the Nat.
                contact.setNat(cursor.getString(9));
                // Setting the Cell.
                contact.setCell(cursor.getString(8));

                // Setting the Cell.
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    @Override
    public int updateContact() {
        return 0;
    }

    @Override
    public void deleteContact() {

    }
}
