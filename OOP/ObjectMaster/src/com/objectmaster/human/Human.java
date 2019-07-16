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
	public int getStrength() {
		return strength;
	}
	public int getStealth() {
		return stealth;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public int getHealth() {
		return health;
	}
	public void setStrength(int value) {
		strength = value;
	}
	public void setStealth(int value) {
		stealth = value;
	}
	public void setIntelligence(int value) {
		intelligence = value;
	}
	public void setHealth(int value) {
		health = value;
	}
}