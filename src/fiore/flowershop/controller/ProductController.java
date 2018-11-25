/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.controller;

import fiore.flowershop.dao.ProductDAO;
import fiore.flowershop.dao.ProductDAOImpl;
import fiore.flowershop.model.Product;
import fiore.flowershop.util.Queue;

/**
 *
 * @author Jasmine
 */
public class ProductController {
    ProductDAO productDAO;

    public ProductController() {
        productDAO = new ProductDAOImpl();
    }
    
    
    public String addProduct(Product p){
        String result = productDAO.addProduct(p);
        return result;
    }
    
    public Queue<Product> getAllProducts(){
        Queue<Product> products = productDAO.getAllProducts();
        return products;
    }
}
