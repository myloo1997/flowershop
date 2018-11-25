/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;

import fiore.flowershop.model.Customer;
import fiore.flowershop.model.CustomerOrder;
import fiore.flowershop.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import fiore.flowershop.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import fiore.flowershop.util.QueueImplementation;

/**
 *
 * @author Jasmine
 */
public class CustOrderDAOImpl implements CustOrderDAO{

    public CustOrderDAOImpl() {
    }
    
    public Queue<CustomerOrder> getPickUpList(){ //this needs fixing
        Connection conn = DBConnection.getConnection();
        Queue<CustomerOrder> olist = new QueueImplementation<CustomerOrder>(CustomerOrder.class);
        if(conn != null){
            
            try {
                String selectQuery =  "select customer.name, customer.type, customer.phoneNo, customer_order.orderID, customer_order.totalAmount, customer_order.paid " +
                    "from customer_order " +
                    "inner join customer on customer.customerID = customer_order.customerID "
                        + "where customer_order.pickupdeliverydate = ? and customer_order.mode = 1 and customer_order.received = 0";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                LocalDate today = LocalDate.now();
                pstmt.setString(1, today.toString());
                ResultSet rs  = pstmt.executeQuery();
                
                while(rs.next()){
                    String customerName = rs.getString(1);
                    int customerType = rs.getInt(2);
                    String phoneNo = rs.getString(3);
                    Customer customer = new Customer();
                    customer.setName(customerName);
                    customer.setPhoneNo(phoneNo);
                    customer.setCustType(customerType);
                    
                    String orderID = Integer.toString(rs.getInt(4));
                    double totalAmount = rs.getDouble(5);
                    int paid = rs.getInt(6); //not needed for now
                    CustomerOrder order = new CustomerOrder();
                    order.setOrderID(orderID);
                    order.setTotalAmount(totalAmount);
                    order.setCustomerID(customer);
                    
                    if(customerType == 1){
                        order.setPaymentMode("Cash On Delivery");
                    }else{
                        order.setPaymentMode("Credit");
                    }
                    
                    olist.enqueue(order);
                }
                
                conn.close();
                return olist;
            } catch (SQLException ex) {
                Logger.getLogger(CustOrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public Queue<CustomerOrder> getDeliveryList(){
        Connection conn = DBConnection.getConnection();
        Queue<CustomerOrder> olist = new QueueImplementation<CustomerOrder>(CustomerOrder.class);
        if(conn != null){
            
            try {
                String selectQuery =  "select customer.name, customer.phoneNo, customer_order.deliveryAddress, customer.type, customer_order.orderID, customer_order.totalAmount, customer_order.paid " +
                    "from customer_order " +
                    "inner join customer on customer.customerID = customer_order.customerID "
                        + "where customer_order.pickupdeliverydate = ? and customer_order.mode = 2";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                LocalDate today = LocalDate.now();
                pstmt.setString(1, today.toString());
                ResultSet rs  = pstmt.executeQuery();
                
                while(rs.next()){
                    String customerName = rs.getString(1);
                    String phoneNo = rs.getString(2);
                    int customerType = rs.getInt(4);
                    Customer customer = new Customer();
                    customer.setName(customerName);
                    customer.setPhoneNo(phoneNo);
                    customer.setCustType(customerType);
                    
                    String address = rs.getString(3);
                    String orderID = Integer.toString(rs.getInt(5));
                    double totalAmount = rs.getDouble(6);
                    int paid = rs.getInt(7); //not needed for now
                    CustomerOrder order = new CustomerOrder();
                    order.setOrderID(orderID);
                    order.setDeliveryAddress(address);
                    order.setTotalAmount(totalAmount);
                    order.setCustomerID(customer);
                    
                    if(customerType == 1){
                        order.setPaymentMode("Cash On Delivery");
                    }else{
                        order.setPaymentMode("Credit");
                    }
                    
                    olist.enqueue(order);
                }
                
                conn.close();
                return olist;
            } catch (SQLException ex) {
                Logger.getLogger(CustOrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
