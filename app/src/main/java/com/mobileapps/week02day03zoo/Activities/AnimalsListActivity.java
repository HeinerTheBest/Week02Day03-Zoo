package com.mobileapps.week02day03zoo.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mobileapps.week02day03zoo.Adapters.AnimalAdapter;
import com.mobileapps.week02day03zoo.DataBase.DummyAnimalsDataBaseHelper;
import com.mobileapps.week02day03zoo.DataBase.ZooDataBaseHelper;
import com.mobileapps.week02day03zoo.FileStorage.InternalFileStorage;
import com.mobileapps.week02day03zoo.Models.Animal;
import com.mobileapps.week02day03zoo.R;

import java.util.ArrayList;

public class AnimalsListActivity extends AppCompatActivity {


    ArrayList<Animal> animals;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    private String TAG = AnimalsListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        sharedPreferences = getSharedPreferences("shared_pref",MODE_PRIVATE);

        String category = sharedPreferences.getString("category","");


        ZooDataBaseHelper zooDataBaseHelper = new ZooDataBaseHelper(this);
        animals = zooDataBaseHelper.getAnimalsByCategory(category);

        recyclerView = findViewById(R.id.rvAnimals);
        AnimalAdapter animalAdapter = new AnimalAdapter(animals,this);
        recyclerView.setAdapter(animalAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        printFileToLogCat();
    }

    private void printFileToLogCat()
    {
        try {
            InternalFileStorage internalFileStorage = new InternalFileStorage("fav_animals.txt");
            Log.d(TAG," Print FileTOLogcat: "+
                    internalFileStorage.readFromFile(this));
        } catch (Exception e)
        {
            Log.d(TAG,"Print FileToLogCat:  "+e);
        }
    }

}
