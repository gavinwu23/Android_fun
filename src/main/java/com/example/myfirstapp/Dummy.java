package com.example.myfirstapp;

public class Dummy {

    private String luckyPhrase;

    public Dummy(String luckyNumber) {
        System.out.println("dummy object was created! ");
        this.luckyPhrase = luckyNumber;
    }

    // getter for that lucky number
    public String getLuckyPhrase ( ){
        return this.luckyPhrase;
    }
}
