/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;

import fiore.flowershop.model.Customer;
import fiore.flowershop.util.Queue;

/**
 *
 * @author Jasmine
 */
public interface CustomerDAO {
    public Queue<Customer> getCorporateCustomers();
    public String addConsumer(String name, String address);
    public int checkCreditLimit(String customerID);
}
