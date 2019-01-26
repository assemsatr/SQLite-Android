package com.example.assemalturifi.databaseapp4;

import android.provider.BaseColumns;

//step5
public class PersonContract  {

    //step7
    public static final String NAME="Person.db";
    public static final int VERSION=1;

    //step8
    public static final String CREATE_TABLE="CREATE TABLE "+
            FeedEntry.TABLE_NAME+" ("+
            FeedEntry.COL_NAME+" Text,"+
            FeedEntry.COL_AGE+" Text,"+
            FeedEntry.COL_GENDER+" Text)";

    //step9
    public static final String GET_ALL="SELECT * FROM "+ FeedEntry.TABLE_NAME;




    //step6
    public static class FeedEntry  implements BaseColumns {

        public static final String TABLE_NAME="person";
        public static final String COL_NAME="name";
        public static final String COL_AGE="age";
        public static final String COL_GENDER="gender";
    }
}
