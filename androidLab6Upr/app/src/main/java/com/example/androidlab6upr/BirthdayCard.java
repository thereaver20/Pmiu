package com.example.androidlab6upr;

import java.io.Serializable;

public class BirthdayCard implements Serializable {
    private String name;
    private String age;
    private String message;

    public BirthdayCard(String name, String age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMessage() {
        return message;
    }
}
