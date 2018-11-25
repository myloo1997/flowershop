/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.controller;

import fiore.flowershop.dao.CustomerDAO;
import fiore.flowershop.dao.CustomerDAOImpl;
import fiore.flowershop.model.Customer;
import fiore.flowershop.util.Queue;

/**
 *
 * @author Jasmine
 */
public class CustomerController {
    CustomerDAO custDAO;

    public CustomerController() {
        custDAO = new CustomerDAOImpl();
    }
    
    public Queue<Customer> getCorporateCustomers(){
        Queue<Customer> customer = custDAO.getCorporateCustomers();
        return customer;
    }
    
    public String addConsumer(String address, String name){
        String custID = custDAO.addConsumer(name, address);
        return custID;
    }
    
    public int checkCreditLimit(String customerID){
        int ok = custDAO.checkCreditLimit(customerID);
        return ok;
    }
}
