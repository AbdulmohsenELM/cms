package com.M7esn.cms.service;

import com.M7esn.cms.dao.CustomerDAO;
import com.M7esn.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    /*private List<Customer> customerList = new CopyOnWriteArrayList<>();
    private int customerCount = 1;*/

    public Customer addCustomer (Customer customer) {
        /*customer.setID(customerCount);
        customerList.add(customer);
        customerCount++;
        return customer;*/
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {
        //return customerList;
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerID) {
        //return customerList.stream().filter(customer -> customer.getID() == customerID).findFirst().get();
        return customerDAO.findById(customerID).get();
    }

    public Customer updateCustomer(Customer customer, int customerID) {
        /*customerList.stream().forEach(c -> {
            if(c.getID() == customerID) {
                c.setName(customer.getName());
                c.setEmail(customer.getEmail());
            }
        });
        return customerList.stream().filter(c -> c.getID() == customerID).findFirst().get();*/
        customer.setID(customerID);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerID) {
        /*customerList.stream().forEach(c -> {
            if(c.getID() == customerID) {
                customerList.remove(c);
            }
        });*/
        customerDAO.deleteById(customerID);
    }
}
//Commented is old code with the List<> way not Database