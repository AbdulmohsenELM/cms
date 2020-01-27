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

    public Customer addCustomer (Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerID) {
        return customerDAO.findById(customerID).get();
    }

    public Customer updateCustomer(Customer customer, int customerID) {
        customer.setID(customerID);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerID) {
        customerDAO.deleteById(customerID);
    }
}
