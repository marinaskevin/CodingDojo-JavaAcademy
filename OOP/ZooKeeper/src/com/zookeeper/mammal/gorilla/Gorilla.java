package com.zookeeper.mammal.gorilla;

import com.zookeeper.mammal.Mammal;

public class Gorilla extends Mammal {

	public Gorilla() {
		// TODO Auto-generated constructor stub
		
	}
	public void throwSomething() {
		System.out.println("The gorilla threw something!");
		this.energyLevel -= 5;
	}
	public void eatBananas() {
		System.out.println("The gorilla is refueling with bananas!");
		this.energyLevel += 10;
	}
	public void climb() {
		System.out.println("The gorilla has climbed a tree!");
		this.energyLevel -= 10;
	}
}
