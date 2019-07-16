package com.objectmaster.human.wizard;

import com.objectmaster.human.Human;

public class Wizard extends Human {
	public Wizard() {
		health = 50;
		intelligence = 8;
	}
	public void heals(Human human) {
		human.setHealth(human.getHealth()+intelligence);
		System.out.println("The wizard increased another's health by "+intelligence+".");
	}
	public void fireball(Human human) {
		human.setHealth(human.getHealth()-3*intelligence);
		System.out.println("The wizard shot a fireball at someone, and that someone lost "+3*intelligence+" health as a result.");
	}
}