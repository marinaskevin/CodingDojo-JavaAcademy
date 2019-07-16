package com.zookeeper.mammal.bat;

import com.zookeeper.mammal.Mammal;

public class Bat extends Mammal {

	public Bat() {
		energyLevel = 300;
	}
	public void fly() {
		System.out.println("..the sound a bat taking off..");
		energyLevel -= 50;
	}
	public void eatHumans() {
		System.out.println("..so- well, never mind..");
		energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("..the sound of a town on fire..");
		energyLevel -= 100;
	}
}
