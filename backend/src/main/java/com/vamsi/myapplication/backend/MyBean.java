package com.vamsi.myapplication.backend;

import com.example.TellJoke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private TellJoke tellJoke;

    public MyBean() {
        tellJoke = new TellJoke();
    }

    public String getData() {
        return tellJoke.getJoke();
    }

   /* public void setData(String data) {
        myData = data;
    }
*/}