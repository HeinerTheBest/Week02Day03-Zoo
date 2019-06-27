package com.mobileapps.week02day03zoo.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Animal implements Parcelable
{
    private String name;
    private String category;
    private String audio;
    private String img;
    private String description;

    public Animal(String name, String category, String audio, String img, String description) {
        this.name = name;
        this.category = category;
        this.audio = audio;
        this.img = img;
        this.description = description;
    }

    public Animal() {
    }

    protected Animal(Parcel in) {
        name = in.readString();
        category = in.readString();
        audio = in.readString();
        img = in.readString();
        description = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(category);
        dest.writeString(audio);
        dest.writeString(img);
        dest.writeString(description);
    }
}
