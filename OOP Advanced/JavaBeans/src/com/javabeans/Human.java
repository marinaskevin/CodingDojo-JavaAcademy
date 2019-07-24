package com.javabeans;

import java.io.Serializable;

public class Human implements Serializable {
	/* JavaBeans are POJOs that conform to a series of rules:

    Member variables must be private, but accessible using get and set
    Must have a zero argument constructor
    Must implement the serializable interface */
	private String name;
    public Human(){
    }
    public Human(String name){
        this.name = name;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
}
