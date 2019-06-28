package com.mobileapps.week02day03zoo.DataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mobileapps.week02day03zoo.Models.Animal;

import java.util.ArrayList;

import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.COLUMN_AUDIO;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.COLUMN_CATEGORY;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.COLUMN_DESCRIPTION;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.COLUMN_IMG;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.COLUMN_NAME;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.DATABASE_NAME;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.DATABASE_VERSION;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.DROP_QUERY;
import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.TABLE_NAME;

//1 Extend SQLiteOpenHelper
public class ZooDataBaseHelper extends SQLiteOpenHelper {

    public ZooDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ZooDatabaseContract.getCreateQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL(DROP_QUERY);
            onCreate(db);
        }
    }

    public void insertZooAnimal(Animal animal) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, animal.getName());
        contentValues.put(COLUMN_CATEGORY, animal.getCategory());
        contentValues.put(COLUMN_AUDIO, animal.getAudio());
        contentValues.put(COLUMN_IMG, animal.getImg());
        contentValues.put(COLUMN_DESCRIPTION, animal.getDescription());

        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public ArrayList<Animal> getAllAnimals() {
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<Animal> returnList = new ArrayList<>();

        Cursor cursor = database.rawQuery(ZooDatabaseContract.SELECT_ALL_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                String category = cursor.getString(1);
                String audio = cursor.getString(2);
                String img = cursor.getString(3);
                String description = cursor.getString(4);
                returnList.add(new Animal(name, category, audio, img, description));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return returnList;
    }

    public ArrayList<Animal> getAnimalsByCategory(String requestCategory) {
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<Animal> returnList = new ArrayList<>();

        Cursor cursor = database.rawQuery(ZooDatabaseContract.getByCategory(requestCategory), null);
        if (cursor.moveToFirst()) {
            do {
                /*String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String category = cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY));
                String audio = cursor.getString(cursor.getColumnIndex(COLUMN_AUDIO));
                String img = cursor.getString(cursor.getColumnIndex(COLUMN_IMG));
                String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));*/
                String name = cursor.getString(0);
                String category = cursor.getString(1);
                String audio = cursor.getString(2);
                String img = cursor.getString(3);
                String description = cursor.getString(4);
                returnList.add(new Animal(name, category, audio, img, description));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return returnList;
    }


    public Animal getAnimal(String name) {
        SQLiteDatabase database = this.getReadableDatabase();
        Animal animal = new Animal();

        Cursor cursor = database.rawQuery(ZooDatabaseContract.getByName(name), null);
        if (cursor.moveToFirst()) {
            animal.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
            animal.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));
            animal.setAudio(cursor.getString(cursor.getColumnIndex(COLUMN_AUDIO)));
            animal.setImg(cursor.getString(cursor.getColumnIndex(COLUMN_IMG)));
            animal.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
        }
        cursor.close();
        database.close();
        return animal;
    }



}
