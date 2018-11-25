/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;

import fiore.flowershop.model.Corporate;
import fiore.flowershop.model.Customer;
import fiore.flowershop.util.BackendConstants;
import fiore.flowershop.util.Queue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import fiore.flowershop.util.QueueImplementation;
/**
 *
 * @author Jasmine
 */
public class CustomerDAOImpl implements CustomerDAO {
    
    public Queue<Customer> getCorporateCustomers(){
        Connection conn = DBConnection.getConnection();
        Queue<Customer> clist = new QueueImplementation<Customer>(Customer.class);
        
        if(conn != null){
            
            try {
                String selectQuery =  "select customerID, name from customer where type = 2";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                ResultSet rs  = pstmt.executeQuery();
                while(rs.next()){
                    Customer cust = new Customer();
                    cust.setCustomerID(Integer.toString(rs.getInt(1)));
                    cust.setName(rs.getString(2));
                    
                    clist.enqueue(cust);
                }
                
                conn.close();
                return clist;
            } catch (SQLException ex) {
                Logger.getLogger(CustOrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }
    
    public String addConsumer(String name, String address){
        Connection conn = DBConnection.getConnection();
        if(conn != null){
            
            try {
                String insertQuery =  "INSERT INTO Customer (name,type) VALUES (?,?)";
             
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1,name);
                pstmt.setInt(2,1);
                // insert ic at customer table
                pstmt.executeUpdate();
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            return BackendConstants.ERROR;
        }
        return null;
    }
    
    
    
    public int checkCreditLimit(String customerID){
        Connection conn = DBConnection.getConnection();
        int ok = 0;
        if(conn != null){
            
            try {
                String selectQuery =  "select creditLimit, expense from corporate where customerID = ?";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                ResultSet rs  = pstmt.executeQuery();
                double limit = 0;
                double expense = 0;
                if(rs.next()){
                    limit = rs.getDouble(1);
                    expense = rs.getDouble(2);
                }
                
                if(limit < expense){
                    ok = 1;
                }else{
                    ok = 0;
                }
                
                conn.close();
                return ok;
            } catch (SQLException ex) {
                Logger.getLogger(CustOrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ok;
    }
}
