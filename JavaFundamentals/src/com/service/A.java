package com.service;

public class A {

	int totalMarks;  //instance variable -- 0
	int marksScored; //instance variable -- 0
	
	public int doSum(int i, int j) {
		return i+j;
	}

	int doSub(int i, int j) { //default method 
		return i-j;
	}

	public void setTotalMarks(int totalMarks) { //local variable
		this.totalMarks = totalMarks;  //instance = local
	}

	public void setMarksScored(int marksScored) { //local variable
		this.marksScored = marksScored; 
		
	}

	public double computePercent() {
		double percent = (this.marksScored * 100) / this.totalMarks;
		return percent;
	}

}
