package com.mobileapps.week02day03zoo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileapps.week02day03zoo.Activities.DescriptionActivity;
import com.mobileapps.week02day03zoo.Models.Animal;
import com.mobileapps.week02day03zoo.R;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder>
{
    private ArrayList<Animal> animals;
    private Context context;

    public AnimalAdapter(ArrayList<Animal> animals,Context  context) {
        this.animals = animals;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_animal,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        final Animal animal = animals.get(i);

        viewHolder.tvName.setText(animal.getName());
        viewHolder.tvCategory.setText(animal.getCategory());

        int id = context.getResources().getIdentifier(animal.getImg(), "drawable", context.getPackageName());
        viewHolder.imgImage.setImageResource(id);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("animal",animal);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imgImage;
        TextView tvName;
        TextView tvCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgImage   = itemView.findViewById(R.id.imgImage);
            tvName     = itemView.findViewById(R.id.tvName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
        }
    }
}
