package com.mobileapps.week02day03zoo.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mobileapps.week02day03zoo.DataBase.DummyAnimalsDataBaseHelper;
import com.mobileapps.week02day03zoo.R;

public class CategoriesActivity extends AppCompatActivity
{
    ListView listCategories;
    Context context;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        sharedPreferences = getSharedPreferences("shared_pref",MODE_PRIVATE);


        listCategories = findViewById(R.id.listCategories);
        context = this;

        final String[] values = new DummyAnimalsDataBaseHelper().getAllCategories();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listCategories.setAdapter(adapter);

        listCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,AnimalsListActivity.class);
                setCategoryInSHaredPref(values[position]);
                startActivity(intent);
            }
        });
    }


    private void setCategoryInSHaredPref(String category)
    {
       SharedPreferences.Editor  editor = sharedPreferences.edit();
       editor.putString("category",category);
       editor.apply(); //Thread Safe, recommended
       // editor.commit()
        editor.clear();
    }

}
