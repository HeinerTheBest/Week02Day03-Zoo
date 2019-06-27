package com.mobileapps.week02day03zoo.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mobileapps.week02day03zoo.R;

public class CategoriesActivity extends AppCompatActivity
{
    ListView listCategories;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        listCategories = findViewById(R.id.listCategories);
        context = this;

        final String[] values = new String[]
                {
                "Mammals",
                "Birds",
                "Fish",
                "Reptiles",
                "Amphibians"
                };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listCategories.setAdapter(adapter);

        listCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,AnimalsListActivity.class);
                intent.putExtra("category",values[position]);
                startActivity(intent);
            }
        });
    }
}
