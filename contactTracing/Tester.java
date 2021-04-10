/*-----------------------------------------------------------------------------
 * A program to test the implementation of the Person and AllData classes of
 * the Contact Tracing application
 * @author Ross Adams
 * Course: CSCI 3381-MWF 0900-Fall 2020
 ----------------------------------------------------------------------------*/
package contactTracing;

import java.time.LocalDate;

public class Tester {

	/**
	 * Driver for the test
	 * @param args
	 */
	public static void main(String[] args) {
		//Define constant variable for the name of the file to store data
		final String DATA_FILE = "contactData.txt";
		
		/*------------------------Person Class Tests-------------------------*/
		// Test Constructors
		Person test1 = new Person();
		Person test2 = new Person("00011","Dwayne","Johnson",
				LocalDate.of(1972, 05, 02),"5553139000","infected");
		
		// Test Getters
		System.out.println("Id: " + test2.getId());
		System.out.println("First Name: " + test2.getfName());
		System.out.println("Last Name: " + test2.getlName());
		System.out.println("Birthday: " + test2.getBirthday());
		System.out.println("Phone: " + test2.getPhone());
		System.out.println("Status: " + test2.getStatus());
		System.out.println("Contacts: " + test2.getContacts());
		
		// Test Setters and toString
		test1.setId("00012");
		test1.setfName("Idris");
		test1.setlName("Elba");
		test1.setBirthday(LocalDate.of(1972, 07, 06));
		test1.setPhone("5553436000");
		test1.setStatus("recovered");
		
		System.out.println("\n" + test1);
		
		// Test addContact
		test2.addContact(test1.getId());
		
		System.out.println("\n" + test2);
		
		// Test equals
		System.out.println("\nTest1 equals test2: " + test1.equals(test2) +
				" [Expect False]\n");
		
		/*------------------------AllData Class Tests------------------------*/
		// Test Constructor
		AllData data = new AllData(DATA_FILE);
		
		// Test add
		data.add(test1);
		data.add(test2);
		
		// Test toString
		System.out.println(data);
		
		// Test remove
		System.out.println("\nPerson: " + data.remove("00012").getfName() + 
				" was removed.");
		
		// Test addContact and findPerson
		data.addContact(data.findPerson("00009"), test2);
		
		System.out.println("\n" + data.findPerson("00009"));
		
		// Test size, isEmpty, and contains
		System.out.println("\nSize of the collection: " + data.size());
		System.out.println("The collection is empty: " + data.isEmpty() + 
				" [Expect false]");
		System.out.println("Collection contains 00001: " + 
				data.contains("00001") + " [Expect true]");
		System.out.println("Collection contains 00012: " + 
				data.contains("00012") + " [Expect false]");
		
		// Test writeFile and doWrite
		data.writeFile("testData.txt");

	}

}
