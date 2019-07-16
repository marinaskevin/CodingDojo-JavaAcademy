package com.objectmaster.human;

import com.objectmaster.human.ninja.Ninja;
import com.objectmaster.human.samurai.Samurai;
import com.objectmaster.human.wizard.Wizard;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human human1 = new Human();
		Human human2 = new Human();
		human1.attack(human2);
		Ninja ninja = new Ninja();
		Samurai samurai = new Samurai();
		Samurai hiddenSamurai = new Samurai();
		Wizard wizard = new Wizard();
		ninja.steal(samurai);
		ninja.runAway();
		samurai.deathBlow(wizard);
		samurai.meditate();
		samurai.howMany();
		wizard.heals(ninja);
		wizard.fireball(samurai);
		System.out.println("There are "+samurai.howMany()+" samurai.");
	}

}
