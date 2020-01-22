package com.M7esn.cms.api;

import com.M7esn.cms.model.Customer;
import com.M7esn.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return "Customer Added Successfully";
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerID}")
    public Customer getCustomer(@PathVariable("customerID") int customerID) {
        return customerService.getCustomer(customerID);
    }

    @PutMapping(value = "/{customerID}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("customerID") int customerID) {
        return customerService.updateCustomer(customer, customerID);
    }

    @DeleteMapping(value = "/{customerID}")
    public void deleteCustomer(@PathVariable("customerID") int customerID) {
        customerService.deleteCustomer(customerID);
    }
}
