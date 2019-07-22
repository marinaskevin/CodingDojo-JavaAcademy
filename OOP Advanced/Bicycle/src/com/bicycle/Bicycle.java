package com.bicycle;

public class Bicycle implements OperateBicycle {
	private int speed;
	
	public Bicycle() {
		// TODO Auto-generated constructor stub
		speed = 0;
	}
	
	public static void staticMethod() {
		OperateBicycle.staticMethod();
	}

	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		speed += increment;
	}

	@Override
	public void applyBrakes(int decrement) {
		// TODO Auto-generated method stub
		speed -= decrement;
	}
	
	public int getSpeed() {
		return speed;
	}

}
