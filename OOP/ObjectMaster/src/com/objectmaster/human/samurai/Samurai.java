package com.objectmaster.human.samurai;

import com.objectmaster.human.Human;

public class Samurai extends Human {
	private static int numberOfSamurai = 0;
	public Samurai() {
		health = 200;
		numberOfSamurai++;
	}
	public void deathBlow(Human human) {
		human.setHealth(0);
		System.out.println("The samurai had "+health+" health.");
		health /= 2;
		System.out.println("The samurai delivered a death blow but now has "+health+" health.");
	}
	public void meditate() {
		System.out.println("The health of the samurai is now "+health+".");
		health *= 1.5;
		System.out.println("The samurai has meditated and now has a health of "+health);
	}
	public int howMany() {
		return numberOfSamurai;
	}
}