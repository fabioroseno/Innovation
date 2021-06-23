package com.rs.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rs.test.model.Customer;

public class Applications {

	public static void main(String[] args) {

		System.out.println(" --- JAVA 8");
		lombokTesting();
		streamFilterMoreThan100Points();
		streamFilterLessThan100Points();
		streamFilterMoreThan100PointsCharles();
		immutableList();
		varOfMethod();
		System.out.println(" --- JAVA 14");
		newCase();
		System.out.println(" --- JAVA 15");
		textBlock();
	}
	
	static void lombokTesting() {
		System.out.println(" --- START - lombokTesting");
		Customer c = new Customer("Boi Dengoso", 150);
		System.out.println(c);
		System.out.println(" --- END - lombokTesting");
		System.out.println(" -----------------------");
	}
	
	private static List<Customer> populateCustomers() {
		Customer john = new Customer("John P.", 15);
		Customer sarah = new Customer("Sarah M.", 200);
		Customer charles = new Customer("Charles B.", 150);
		Customer mary = new Customer("Mary T.", 1);

		return Arrays.asList(john, sarah, charles, mary);
	}
	
	static void streamFilterMoreThan100Points() {
		System.out.println(" --- START - streamFilterMoreThan100Points");
		List<Customer> customers = populateCustomers();
		List<Customer> customersWithMoreThan100Points = customers
				  .stream()
				  .filter(c -> c.getPoints() > 100)
				  .collect(Collectors.toList());

		System.out.println(" --- streamFilterMoreThan100Points");
		customersWithMoreThan100Points.forEach(System.out::println);
		System.out.println(" --- END - streamFilterMoreThan100Points");
		System.out.println(" -------------------------------------- ");
	}
	
	static void streamFilterLessThan100Points() {
		System.out.println(" --- START - streamFilterLessThan100Points");
		List<Customer> customers = populateCustomers();
		List<Customer> customersWithLessThan100Points = customers
				  .stream()
				  .filter(Customer::hasLessHundredPoints)
				  .collect(Collectors.toList());

		customersWithLessThan100Points.forEach(System.out::println);
		System.out.println(" --- END - streamFilterLessThan100Points");
		System.out.println(" ---------------------------------------");
	}
	
	static void streamFilterMoreThan100PointsCharles() {
		System.out.println(" --- START - streamFilterMoreThan100PointsCharles");
		List<Customer> customers = populateCustomers();
		List<Customer> customersFilter = customers
				  .stream()
				  .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
				  .collect(Collectors.toList());
		
		customersFilter.forEach(System.out::println);
		System.out.println(" --- END - streamFilterMoreThan100PointsCharles");
		System.out.println(" ----------------------------------------------");
	}
	
	static void immutableList() {
		System.out.println(" --- START - immutableList");
		List<String> imutableNames = List.of("nameOne", "nameTwo", "nameThree");

		//imutableNames.add("nameFour"); DON'T ALLOWED
		
		imutableNames.stream().
		forEach(System.out::println);
		System.out.println(" --- END - immutableList");
		System.out.println(" -----------------------");
	}

	static void varOfMethod() {
		System.out.println(" --- START - varOfMethod");
		var variable = new HashMap<String, Object>();
		
		variable.put("key1", 5);
		variable.put("key2", 7);
		
		for(Map.Entry<String, Object> entry : variable.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println(" --- END - varOfMethod");
		System.out.println(" ---------------------");
	}
	
	static void newCase() {
		System.out.println(" --- START - newCase");
		var name = "Freddie";
		switch (name) {
			case "Taty" -> System.out.println("She's the mother!");
			case "Freddie" -> System.out.println("He's the son!");
			default -> System.out.println("Not found!");
		}
		System.out.println(" --- END - newCase");
		System.out.println(" -----------------");
	}

	static void textBlock() {
		System.out.println(" --- START - textBlock");
		String text = """
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eget rhoncus velit, 
				non cursus est. Vestibulum eros velit, laoreet id libero venenatis, dapibus malesuada 
				neque. Proin quam orci, fringilla vel orci nec, pretium gravida felis. Nunc luctus 
				ullamcorper nisi et tincidunt. Aliquam cursus sodales eleifend. Aenean imperdiet 
				dui eu elit pharetra, ut maximus velit vehicula. Suspendisse quis posuere sapien.
				""";
		System.out.println("LOREM ISUM: " + text);
		System.out.println(" --- END - textBlock");
		System.out.println(" -------------------");
		
	}
	
}
