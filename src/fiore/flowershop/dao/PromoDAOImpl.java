/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;

import fiore.flowershop.model.Product;
import fiore.flowershop.model.Promotion;
import fiore.flowershop.util.BackendConstants;
import fiore.flowershop.util.Queue;
import fiore.flowershop.util.QueueImplementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jasmine
 */
public class PromoDAOImpl implements PromoDAO{
    public String addPromotion(Promotion p){
        String msg = "success";
        Connection conn = DBConnection.getConnection();
        
        if(conn != null){
            
            try {
                String insertQuery =  "INSERT INTO Promotion (productID,monthyear,discount,description) VALUES (?,?,?,?)";
             
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setInt(1, Integer.parseInt(p.getProductID().getProductID()));
                pstmt.setString(2, p.getMonthyear());
                pstmt.setDouble(3, p.getDiscount());
                pstmt.setString(4, p.getPromoName());
                
                pstmt.executeUpdate();
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(PromoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            return BackendConstants.ERROR;
        }
        return msg;
    }
    
    public Queue<Promotion> getAllPromotions(){
        Connection conn = DBConnection.getConnection();
        
        Queue<Promotion> plist = new QueueImplementation<Promotion>(Promotion.class);
        if(conn != null){
            
            try {
                String selectQuery =  "SELECT * from PROMOTION";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                
                ResultSet rs  = pstmt.executeQuery();
                
                while(rs.next()){
                    String promoid = Integer.toString(rs.getInt(1));
                    String productid = Integer.toString(rs.getInt(2));
                    String monthyear = rs.getString(3);
                    double discount = rs.getDouble(4);
                    String desc = rs.getString(5);
                    
                    Promotion p = new Promotion();
                    p.setPromoID(promoid);
                    Product prod = new Product();
                    prod.setProductID(productid);
                    p.setProductID(prod);
                    p.setMonthyear(monthyear);
                    p.setDiscount(discount);
                    p.setPromoName(desc);
                    
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
    
    public Queue<Promotion> getMonthPromotion(){
        Connection conn = DBConnection.getConnection();
        
        Queue<Promotion> plist = new QueueImplementation<Promotion>(Promotion.class);
        if(conn != null){
            
            try {
                String selectQuery =  "select promotion.promoid, promotion.productID, promotion.discount, promotion.description, "
                        + "product.productName, product.price "
                        + "from promotion inner join product on promotion.productID = product.productID "
                        + "where promotion.monthyear = ?";
                
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                LocalDate today = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
                String my = today.format(formatter);
                
                pstmt.setString(1,my);
                ResultSet rs  = pstmt.executeQuery();
                
                while(rs.next()){
                    String promoid = Integer.toString(rs.getInt(1));
                    String productid = Integer.toString(rs.getInt(2));
                    double discount = rs.getDouble(3);
                    String desc = rs.getString(4);
                    String name = rs.getString(5);
                    Double price = rs.getDouble(6);
                    
                    Promotion p = new Promotion();
                    p.setPromoID(promoid);
                    Product prod = new Product();
                    prod.setProductID(productid);
                    prod.setProductName(name);
                    prod.setPrice(price);
                    p.setProductID(prod);
                    p.setDiscount(discount);
                    p.setPromoName(desc);
                    
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
}
