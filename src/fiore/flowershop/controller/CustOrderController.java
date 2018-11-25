/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.controller;
import fiore.flowershop.dao.CustOrderDAOImpl;
import fiore.flowershop.dao.CustOrderDAO;
import fiore.flowershop.model.CustomerOrder;
import fiore.flowershop.util.Queue;
/**
 *
 * @author Jasmine
 */
public class CustOrderController {
    CustOrderDAO orderDAO;
    
    public CustOrderController(){
        orderDAO = new CustOrderDAOImpl();
    }
    
    public Queue<CustomerOrder> getPickUpList(){
        Queue<CustomerOrder> orders = orderDAO.getPickUpList();
        return orders;
    }
    
    public Queue<CustomerOrder> getDeliveryList(){
        Queue<CustomerOrder> orders = orderDAO.getDeliveryList();
        return orders;
    }
}
