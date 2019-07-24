package com.calculator;

import java.io.Serializable;

public class Calculator implements Serializable {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	public Calculator() {
		operandOne = 0;
		operandTwo = 0;
		operation = "";
		result = 0;
	}
	public void setOperandOne(double operand) {
		operandOne = operand;
	}
	public void setOperandTwo(double operand) {
		operandTwo = operand;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getOperandOne() {
		return operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public String getOperation() {
		return operation;
	}
	public void performOperation( ) {
		if(operation == "+") {
			result = operandOne + operandTwo;
		}
		if(operation == "-") {
			result = operandOne - operandTwo;
		}
	}
	public void getResults() {
		System.out.println(operandOne+" "+operation+" "+operandTwo+" = "+result);
	}
}
