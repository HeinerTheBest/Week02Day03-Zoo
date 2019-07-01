package com.mobileapps.week02day03zoo.Providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.mobileapps.week02day03zoo.DataBase.ZooDataBaseHelper;

import static com.mobileapps.week02day03zoo.DataBase.ZooDatabaseContract.TABLE_NAME;

public class ZooAnimalCOntentProvider extends ContentProvider
{
    ZooDataBaseHelper zooDataBaseHelper;

    @Override
    public boolean onCreate() {
        zooDataBaseHelper = new ZooDataBaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri,String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert( Uri uri, ContentValues values) {
        SQLiteDatabase database = zooDataBaseHelper.getWritableDatabase();
        Uri returnUri;
        long id= database.insert(TABLE_NAME,null,values);
        if(id >0 )
        {
            returnUri = ZooAnimalProviderContract.ZooAnimalsEntry.buidZooAnimalUri(id);
        }
        else
        {
            throw new UnsupportedOperationException("Row Not Inserted!!!");
        }

        return returnUri;
    }

    @Override
    public int delete(Uri uri,  String whereClause,  String[] whereArgs)
    {
        SQLiteDatabase database = zooDataBaseHelper.getWritableDatabase();
        final int itemDeleted = database.delete(TABLE_NAME, whereClause, whereArgs);
        return itemDeleted;
    }

    @Override
    public int update( Uri uri,  ContentValues values, String selection, String[] selectionArgs)
    {
        SQLiteDatabase database = zooDataBaseHelper.getWritableDatabase();
        final int itemsUpdated = database.update(TABLE_NAME, values,selection,selectionArgs);
        database.close();
        return itemsUpdated;
    }
}
