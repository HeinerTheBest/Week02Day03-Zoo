package com.mobileapps.week02day03zoo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mobileapps.week02day03zoo.DataBase.DummyAnimalsDataBaseHelper;
import com.mobileapps.week02day03zoo.DataBase.ZooDataBaseHelper;
import com.mobileapps.week02day03zoo.Models.Animal;
import com.mobileapps.week02day03zoo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ZooDataBaseHelper zooDataBaseHelper = new ZooDataBaseHelper(this);

        if(zooDataBaseHelper.getAllAnimals().size() == 0) {
            for (Animal animal : new DummyAnimalsDataBaseHelper().getAllAnimal()) {
                zooDataBaseHelper.insertZooAnimal(animal);
            }
        }
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this,CategoriesActivity.class);
        startActivity(intent);
    }
}
