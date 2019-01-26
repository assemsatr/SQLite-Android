package com.example.assemalturifi.databaseapp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

//step10
public class PersonDataBase extends SQLiteOpenHelper {

    //step11
    public PersonDataBase(@Nullable Context context) {
        super(context, PersonContract.NAME, null, PersonContract.VERSION);
    }

    //step12
    //to Create the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PersonContract.CREATE_TABLE);

    }

    //step13
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //drop table and upgrade to new version of database schema
        //migration scripts for saving database
    }

    //step14
    public long savePerson(Person person){
        //get instance of the database
        SQLiteDatabase database=getWritableDatabase();

        //create content values to save teh date as a row
        ContentValues contentValuse=new ContentValues();
        contentValuse.put(PersonContract.FeedEntry.COL_NAME,person.getName());
        contentValuse.put(PersonContract.FeedEntry.COL_AGE,person.getAge());
        contentValuse.put(PersonContract.FeedEntry.COL_GENDER,person.getGender());

        long rowId=database.insert(PersonContract.FeedEntry.TABLE_NAME,null,contentValuse);

        return rowId;

    }
    //step15
    public List<Person> getPeople() {
        SQLiteDatabase database = getWritableDatabase();


        List<Person>personList=new ArrayList<>();

        Cursor cursor=database.rawQuery(PersonContract.GET_ALL,null);

        if(cursor.moveToFirst()){
            do{
                Person person=new Person(cursor.getString(cursor.getColumnIndex(PersonContract.FeedEntry.COL_NAME)),
                        cursor.getString(cursor.getColumnIndex(PersonContract.FeedEntry.COL_AGE)),
                        cursor.getString(cursor.getColumnIndex(PersonContract.FeedEntry.COL_GENDER)));
                personList.add(person);
            }
            while(cursor.moveToNext());
        }


        cursor.close();
        database.close();
        return personList;

    }
}
