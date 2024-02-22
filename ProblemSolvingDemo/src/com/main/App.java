package com.main;
import java.util.*; 
public class App { //executed by jvm  

	public static void main(String[] args) {
		GreedyService gs = new GreedyService(); 
		//Step 1: Fetch the data 
		List<Person> list = gs.givePersonData();
		
		System.out.println("Original List");
		for(Person p : list) { //p=
			System.out.println(p.getName() + "--" + p.getAge() + "--" + p.getState());
		}
		
		//Step 2 : Display records that belong to state MS or TN
		System.out.println("Filtered By State List");
		
		List<Person> filteredList1 = gs.filterByState(list); 
		
		for(Person p : filteredList1) { //p=
			System.out.println(p.getName() + "--" + p.getAge()+ "--" + p.getState());
		}
		
		//step 3: Display records that have age > 20
		
	}
}
