package com.mobileapps.week02day03zoo.DataBase;

import java.util.Locale;

public class ZooDatabaseContract
{
    public static final String DATABASE_NAME = "zoo_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "animal_table";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_AUDIO = "audio";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String DROP_QUERY =String.format("DROP TABLE %S", TABLE_NAME);
    public static final String SELECT_ALL_QUERY = String.format("SELECT * FROM %s", TABLE_NAME);




    public static final String getCreateQuery()
    {

        return String.format(
                Locale.US,
                "CREATE TABLE %S( %S TEXT PRIMARY_KEY, %S TEXT, %S TEXT, %S TEXT, %S TEXT)",
                TABLE_NAME, COLUMN_NAME, COLUMN_CATEGORY, COLUMN_AUDIO, COLUMN_IMG, COLUMN_DESCRIPTION);
    }

    public static  String getByCategory(String category)
    {
        return String.format("%s WHERE %S = \"%s\"",
                SELECT_ALL_QUERY,COLUMN_CATEGORY,category);
    }

    public static  String getByName(String name)
    {
        return String.format("%s WHERE %S = \"%s\"",
                SELECT_ALL_QUERY,COLUMN_NAME,name);
    }


}
