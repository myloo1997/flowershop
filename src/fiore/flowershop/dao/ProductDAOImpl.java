/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;

import fiore.flowershop.model.Product;
import fiore.flowershop.model.ProductType;
import fiore.flowershop.util.BackendConstants;
import fiore.flowershop.util.SystemConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fiore.flowershop.util.Queue;
import fiore.flowershop.util.QueueImplementation;
/**
 *
 * @author Jasmine
 */
public class ProductDAOImpl implements ProductDAO{
    @Override
    public String addProduct(Product p){
        String msg = "success";
     
        Connection conn = DBConnection.getConnection();
        
        if(conn != null){
            
            try {
                String insertQuery =  "INSERT INTO Product (productName,typeID,price,stocked) VALUES (?,?,?,?)";
             
                ProductType productType = getProductTypeByName(p.getTypeName());
                       
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1,p.getProductName());
                pstmt.setInt(2,Integer.parseInt(productType.getTypeID()));
                pstmt.setDouble(3,p.getPrice());
                pstmt.setInt(4,p.getStocked());
                
                pstmt.executeUpdate();
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            return BackendConstants.ERROR;
        }
        
        return msg;
    }

    @Override
    public ProductType getProductTypeByName(String name) {
   
        Connection conn = DBConnection.getConnection();
        
        if(conn != null){
            
            try {
                String selectQuery =  "select * from product_type where typeName = ?";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                pstmt.setString(1,name);
                
                ResultSet rs  = pstmt.executeQuery();
                ProductType p = new ProductType();
                if(rs.next()){
                    String typeid = Integer.toString(rs.getInt(1));
                    p.setTypeID(typeid);
                }
                conn.close();
                return p;
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public Queue<Product> getAllProducts(){
        
        Connection conn = DBConnection.getConnection();
        Queue<Product> plist = new QueueImplementation<Product>(Product.class);
        if(conn != null){
            
            try {
                String selectQuery =  "select * from product";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                
                ResultSet rs  = pstmt.executeQuery();
                
                while(rs.next()){
                    String productid = Integer.toString(rs.getInt(1));
                    String productname = rs.getString(2);
                    int typeid = rs.getInt(3);
                    double price = rs.getDouble(4);
                    int stocked = rs.getInt(5);
                    
                    Product p = new Product();
                    p.setProductID(productid);
                    p.setProductName(productname);
                    ProductType t = getProductNamebyType(typeid);
                    p.setTypeName(t.getType());
                    p.setPrice(price);
                    p.setStocked(stocked);
                    
                    plist.enqueue(p);
                }
                
                conn.close();
                return plist;
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ProductType getProductNamebyType(int type) {
   
        Connection conn = DBConnection.getConnection();
        
        if(conn != null){
            
            try {
                String selectQuery =  "select * from product_type where typeID = ?";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                pstmt.setInt(1,type);
                
                ResultSet rs  = pstmt.executeQuery();
                ProductType p = new ProductType();
                if(rs.next()){
                    String typename = rs.getString(2);
                    p.setType(typename);
                }
                conn.close();
                return p;
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
