package com.example.seatrend.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by seatrend on 2018/6/26.
 */

public class User implements Parcelable {

    private String name;
    private String sex;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    protected User(Parcel in) {
        name=in.readString();
        sex=in.readString();
        age=in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(sex);
        dest.writeInt(age);
    }

    public void readFromParcel(Parcel reply) {
        name=reply.readString();
        sex=reply.readString();
        age=reply.readInt();
    }
}
