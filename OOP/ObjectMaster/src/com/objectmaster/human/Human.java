package com.objectmaster.human;

public class Human {
	protected int strength, stealth, intelligence, health;
	public Human() {
		strength = stealth = intelligence = 3;
		health = 100;
	}
	public void attack(Human human) {
		health -= human.strength;
		System.out.println("Attacked! Health is now "+health+".");
	}
}