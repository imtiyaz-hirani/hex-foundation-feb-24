package com.controller;

import com.service.LoanProcessing;
import com.service.LoanProcessingProtean;

public class InheritanceApp {
	public static void main(String[] args) {
		LoanProcessing loanProcessing = new LoanProcessingProtean();
		loanProcessing.getCreditScore();
		loanProcessing.processLoan();
		//loanProcessing.processInterest(); -- CF not present in super class 
	}
}
