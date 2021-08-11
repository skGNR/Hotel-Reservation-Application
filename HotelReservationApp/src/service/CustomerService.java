package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/2 - 15:45
 */
public class CustomerService {
    private static Map<String, Customer> customerInfo = new HashMap<String, Customer>();

    public static void addCustomer(String email, String firstName, String lastName) throws IllegalAccessException {
        Customer newCustomer = new Customer(firstName, lastName, email);
        customerInfo.put(newCustomer.getEmail(), newCustomer);
    }

    public static Customer getCustomer(String email) {
        return customerInfo.get(email);
    }

    public static Collection<Customer> getAllCustomers() {
        return customerInfo.values();
    }
}
