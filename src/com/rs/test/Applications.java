package com.rs.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rs.test.model.Customer;

public class Applications {

	public static void main(String[] args) {
		lombokTesting();
		streamFilterMoreThan100Points();
		streamFilterLessThan100Points();
		streamFilterMoreThan100PointsCharles();
		myImutableList();
		myVarOfMethod();
	}
	
	static void lombokTesting() {
		System.out.println(" --- lombokTesting");
		Customer c = new Customer("Boi Dengoso", 150);
		System.out.println(c);
	}
	
	private static List<Customer> populateCustomers() {
		Customer john = new Customer("John P.", 15);
		Customer sarah = new Customer("Sarah M.", 200);
		Customer charles = new Customer("Charles B.", 150);
		Customer mary = new Customer("Mary T.", 1);

		return Arrays.asList(john, sarah, charles, mary);
	}
	
	static void streamFilterMoreThan100Points() {
		List<Customer> customers = populateCustomers();
		List<Customer> customersWithMoreThan100Points = customers
				  .stream()
				  .filter(c -> c.getPoints() > 100)
				  .collect(Collectors.toList());

		System.out.println(" --- streamFilterMoreThan100Points");
		customersWithMoreThan100Points.forEach(System.out::println);
	}
	
	static void streamFilterLessThan100Points() {
		List<Customer> customers = populateCustomers();
		List<Customer> customersWithLessThan100Points = customers
				  .stream()
				  .filter(Customer::hasLessHundredPoints)
				  .collect(Collectors.toList());

		System.out.println(" --- streamFilterLessThan100Points");
		customersWithLessThan100Points.forEach(System.out::println);
	}
	
	static void streamFilterMoreThan100PointsCharles() {
		List<Customer> customers = populateCustomers();
		List<Customer> customersFilter = customers
				  .stream()
				  .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
				  .collect(Collectors.toList());
		
		System.out.println(" --- streamFilterMoreThan100PointsCharles");
		customersFilter.forEach(System.out::println);
	}
	
	static void myImutableList() {
		List<String> imutableNames = List.of("nameOne", "nameTwo", "nameThree");

		//imutableNames.add("nameFour"); DON'T ALLOWED
		
		imutableNames.stream().
		forEach(System.out::println);
	}

	static void myVarOfMethod() {
		var variable = new HashMap<String, Object>();
		
		variable.put("key1", 5);
		variable.put("key2", 7);
		
		for(Map.Entry<String, Object> entry : variable.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
