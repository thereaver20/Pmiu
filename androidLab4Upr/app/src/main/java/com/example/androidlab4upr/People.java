package com.example.androidlab4upr;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable {
    private String name;
    private int age;
    private String address;
    private String city;

    public People(String name) {
        this.name = name;
    }

    protected People(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
        city = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
        dest.writeString(city);
    }
}
