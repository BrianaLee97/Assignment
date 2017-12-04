package ie.lyit.serialize;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


import ie.lyit.hotel.Customer;


public class CustomerSerializer {
	
	//ArrayList of Customers
	public ArrayList<Customer> customers;
	
	private final String FILENAME = "customers.ser";
	
	//Default Constructor
	public CustomerSerializer() {
			//Construct customerList ArrayList
			customers = new ArrayList<Customer>();
	}
	
	public void add() {
		//Create a Customer object
		Customer customer = new Customer();
		//Read its details
		customer.toString();
		//And add it to the customers ArrayLisy
		customers.add(customer);
	
		
	}
	
	public void list() {
			//for every Customer object in customers
		for(Customer tmpCustomer:customers)
				//display it
				System.out.println(tmpCustomer);
	}
	
	public Customer view() {
		Scanner keyboard = new Scanner(System.in);
		
		//REad the number of the Customer to be viewed from the user
		System.out.println("ENTER NAME OF CUSTOMER: ");
		int customerToView=keyboard.nextInt();
		
		//for every Customer object in customers
		for(Customer tmpCustomer: customers) {
			//if its number equals the number of the customerToView
			if(tmpCustomer.getNumber() == customerToView) {
				//display it
					System.out.println(tmpCustomer);
					return tmpCustomer;
					
			}
		}
		//if we reach this code the customer was not found so return null
		return null;
		
	}
	
	public void edit() {
		//Call view() to find, display, and return the Customer to edit
		Customer tempCustomer = view();
		//If the Customer != null
		if(tempCustomer != null) {
			//get its index
			int index=customers.indexOf(tempCustomer);
			//read in a new customer
			tempCustomer.toString();
			//reset the object in customers
			customers.set(index, tempCustomer);
		}
	}
	
	public void delete() {
		//Call view() to find, display, and return the customer to delete
		Customer tempCustomer = view();
		//If the customer != null
		if(tempCustomer != null)
			//remove it from customers
			customers.remove(tempCustomer);
	}
	
	public void writeRecordsToFile(){
		try{
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
	
			os.writeObject(customers);
	
			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customers.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void readRecordsFromFile(){
		try{
			
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream is = new ObjectInputStream(fis);

			
			customers = (ArrayList<Customer>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find books file.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}				
	}	

}