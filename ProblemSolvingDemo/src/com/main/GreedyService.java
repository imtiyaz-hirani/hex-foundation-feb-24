package com.main;

import java.util.*;
import java.util.stream.Collectors;

public class GreedyService {//logic

	public List<Person> givePersonData() {
		 Person p1 = new Person("harry potter", "AEMPH4458J",19, "mumbai","MS");
		 Person p2 = new Person("roald weasley", "AEMYU4458J",25, "chennai","TN");
		 Person p3 = new Person("hermione granger", "AEIO8458J",21, "vizag","AP");
		 Person p4 = new Person("neville longbottom", "FGMPH4458J",16, "mumbai","MS");
		 Person p5 = new Person("draco malfoy", "TYGPH4458J",30, "chennai","TN");
		 
		 List<Person> list = new ArrayList<>();
		 list.add(p1);
		 list.add(p2);
		 list.add(p3);
		 list.add(p4);
		 list.add(p5);
		return list;
	}

	public List<Person> filterByState(List<Person> list) {
		 
		return list.stream()
				.filter(p-> p.getState().equals("MS") || p.getState().equals("TN"))
				.collect(Collectors.toList());
	} 

	
	
}

//5 persons