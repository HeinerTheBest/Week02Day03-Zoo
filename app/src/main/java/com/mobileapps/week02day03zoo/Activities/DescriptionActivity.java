package com.mobileapps.week02day03zoo.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileapps.week02day03zoo.FileStorage.InternalFileStorage;
import com.mobileapps.week02day03zoo.Models.Animal;
import com.mobileapps.week02day03zoo.R;

import java.util.Locale;

public class DescriptionActivity extends AppCompatActivity {

    String TAG = DescriptionActivity.class.getSimpleName();
    TextView tvName, tvCategory,tvDescription;
    ImageView imageView;
    MediaPlayer player;
    Animal animal;
    private InternalFileStorage internalFileStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        tvName = findViewById(R.id.tvName);
        tvCategory = findViewById(R.id.tvCategory);
        tvDescription = findViewById(R.id.tvDescription);
        imageView = findViewById(R.id.imgImage);


        animal = bundle.getParcelable("animal");
        tvName.setText(animal.getName());
        tvCategory.setText(animal.getCategory());
        tvDescription.setText(animal.getDescription());
        int idImage = getResources().getIdentifier(animal.getImg(), "drawable",getPackageName());
        imageView.setImageResource(idImage);
        saveAnimalTOInternalFIleStorage(animal);
    }

    public void playSOund(View view)
    {
        int idMusic = getResources().getIdentifier(animal.getAudio(), "raw",getPackageName());
        player = MediaPlayer.create(this,idMusic);
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(player != null)
         player.pause();
    }

    private void saveAnimalTOInternalFIleStorage(Animal passedAnimal)
    {
        try
        {
         internalFileStorage = new InternalFileStorage("fav_animals.txt");
         final String stringToSaveToFile = String.format(Locale.US, "{\"animal\": \"%s\", \"category\" : \"%s\"}",
                 passedAnimal.getName(),passedAnimal.getCategory());
         internalFileStorage.writeToFIle(this,stringToSaveToFile);
         internalFileStorage = null;
        }catch (Exception e)
        {
            Log.d(TAG,"saveAnimalTOIntenalFIleStorage:  "+e);
        }
    }

}
