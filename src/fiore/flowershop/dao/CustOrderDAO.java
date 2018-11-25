/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;

import fiore.flowershop.model.CustomerOrder;
import fiore.flowershop.util.Queue;

/**
 *
 * @author Jasmine
 */
public interface CustOrderDAO {
    public Queue<CustomerOrder> getPickUpList();
    public Queue<CustomerOrder> getDeliveryList();
}
