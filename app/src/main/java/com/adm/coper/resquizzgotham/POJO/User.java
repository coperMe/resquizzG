package com.adm.coper.resquizzgotham.POJO;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by coper on 19/02/16.
 */
public class User implements Serializable{

    private int numCalls;
    private String name;
    private ArrayList<String> friends;

    public User(){

        this.numCalls = 2;
        this.name = "John Doe";
        this.friends = new ArrayList<String>();

    }

    public User(User right){

        this.numCalls = right.numCalls;
        this.name = right.getName();
        this.friends = right.getFriends();

    }

    public User(int newNumCalls, String newName, ArrayList<String> newFriends){

        this.numCalls = newNumCalls;
        this.name = newName;
        this.friends = newFriends;

    }

    public String getName(){

        return this.name;

    }

    public ArrayList<String> getFriends(){

        return this.friends;

    }

    public void setName(String newName){

        this.name = newName;

    }

    public void setNumCalls(int newNumCalls){

        this.numCalls = newNumCalls;

    }

    public void setFriends(ArrayList<String> newFriends){

        this.friends = newFriends;

    }
}
