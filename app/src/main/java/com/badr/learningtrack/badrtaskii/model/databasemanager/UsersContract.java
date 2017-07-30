package com.badr.learningtrack.badrtaskii.model.databasemanager;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class UsersContract {
    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.
    public static final String CONTENT_AUTHORITY = "com.badr.learningtrack.steps";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    // For instance, content://com.example.android.sunshine.app/weather/ is a valid path for
    // looking at weather data. content://com.example.android.sunshine.app/givemeroot/ will fail,
    // as the ContentProvider hasn't been given any information on what to do with "givemeroot".
    // At least, let's hope not.  Don't be that dev, reader.  Don't be that dev.
    public static final String PATH_USER = "user";


    /* Inner class that defines the table contents of the location table*/
    public static final class UserEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_USER).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;

        // Table name
        public static final String TABLE_NAME = "users";

        // Columns
        ///Column ID
        public static final String _ID = "_users_id";
        ///Column gender
        public static final String COLUMN_GENDER = "gender";
        ///Column email
        public static final String COLUMN_EMAIL = "email";
        ///Column dob
        public static final String COLUMN_DOB = "dob";
        ///Column ID
        public static final String COLUMN_TITLE = "title";
        ///Column ID
        public static final String COLUMN_FIRST_NAME = "first";
        ///Column ID
        public static final String COLUMN_LAST_NAME = "last";
        // Columns .
        public static final String COLUMN_STREET = "street";
        ///Column ID
        public static final String COLUMN_CITY = "city";
        ///Column state,
        public static final String COLUMN_STATE = "state";
        ///Column phone.
        public static final String COLUMN_PHONE = "phone";
        ///Column cell.
        public static final String COLUMN_CELL = "cell";
        ///Column nat.
        public static final String COLUMN_NAt = "nat";
        ///Column picture.
        public static final String COLUMN_Image = "picture";


        public static Uri buildLocationUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

}
