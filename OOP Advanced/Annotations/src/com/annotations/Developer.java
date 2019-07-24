package com.annotations;

public class Developer extends Human {
	//What if we could tell our compiler that we want to make sure we are actually overriding a method? Then we can add an @Override annotation:
    @Override
    public String getName(){
        return "Developer!";
    }
}
