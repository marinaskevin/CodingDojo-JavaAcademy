package com.objectmaster.human.ninja;

import com.objectmaster.human.Human;

public class Ninja extends Human {
	public Ninja() {
		stealth = 10;
	}
	public void steal(Human human) {
		human.setHealth(human.getHealth()-stealth);
		health += stealth;
		System.out.println("The ninja took "+stealth+" health from an opponent.");
	}
	public void runAway() {
		health -= 10;
		System.out.println("The ninja ran away and lost 10 health. Now the Ninja only has "+health+" health.");
	}
}
