package com.adm.coper.resquizzgotham.POJO;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by coper on 19/02/16.
 */
public class User implements Serializable{

    private int numCalls;
    private String name;
    private List<String> friends;

    public User(){

        this.name = "John Doe";
        this.numCalls = 2;
        this.friends = new ArrayList<String>();

    }

    public User(User right){

        this.name = right.getName();
        this.numCalls = right.numCalls;
        this.friends = right.getFriends();

    }

    public User(int newNumCalls, String newName, List<String> newFriends){

        this.name = newName;
        this.numCalls = newNumCalls;
        this.friends = newFriends;

    }

    public String getName(){

        return this.name;

    }

    public int getNumCalls(){

        return this.numCalls;

    }

    public List<String> getFriends(){

        return this.friends;

    }

    public void setName(String newName){

        this.name = newName;

    }

    public void setNumCalls(int newNumCalls){

        this.numCalls = newNumCalls;

    }

    public void setFriends(List<String> newFriends){

        this.friends = newFriends;

    }
}
