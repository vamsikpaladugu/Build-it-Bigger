package com.example;

import java.util.Random;

public class TellJoke {

    String[] jokes = new String[3];
    private Random random = new Random();

    public String getJoke(){

        jokes[0] = "Can a kangaroo jump higher than a house?\nOf course, a house doesn't jump at all.";
        jokes[1] = "Why do Java developers wear glasses? Because they can't C#";
        jokes[2] = "This is a funny joke!";

        return jokes[random.nextInt(jokes.length)];
    }

}
