package fi.jupekett.task3;

import java.util.List;


/**
 * A class to mediate customer information between the API and "database"
 */
public class CustomerService {
	private DatabaseMock database = DatabaseMock.getInstance();
	private List<Customer> CUSTOMERS = database.getAllCustomers();
	
	public CustomerService() {
		// default
	}
	
	
	/**
	 * @return all customers.
	 */
	public List<Customer> getAllCustomers() {
		return CUSTOMERS;
	}
	
	
	/**
	 * Returns a customer based on its ID.
	 * @param id
	 * @return
	 */
	public Customer getCustomer(int id) {
		for (Customer customer : CUSTOMERS) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		throw new DataNotFoundException("Customer with ID "+id+" not found.");
	}
	
	
	
	/**
	 * Adds a customer.
	 * @param customer
	 * @return Customer that was added to the database.
	 */
	public Customer addCustomer(Customer customer) {
		Customer addedCustomer = database.addCustomer(customer);
		return addedCustomer;
	}
	
	
	/**
	 * Adds a customer based on a name.
	 * @param name
	 * @param email
	 * @return Customer that was added to the database.
	 */
	public Customer addCustomer(String name, String email) {
		Customer newCustomer = new Customer(name, email);
		Customer addedCustomer = database.addCustomer(newCustomer);
		return addedCustomer;
	}
	
	
	/**
	 * Update a customer given an ID
	 * @param id Customer ID from path parameter.
	 * @param customer
	 * @return null if modified. Customer if added.
	 */
	public Customer updateCustomer(int id, Customer customer) {
		Customer addedCustomer = database.updateCustomer(id, customer);
		return addedCustomer;
	}
	
	

}
