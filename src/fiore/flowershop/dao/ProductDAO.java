/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;

import fiore.flowershop.model.Product;
import fiore.flowershop.model.ProductType;
import java.util.Vector;
import fiore.flowershop.util.Queue;
/**
 *
 * @author Jasmine
 */
public interface ProductDAO {
    public String addProduct(Product p);
    public Queue<Product> getAllProducts();
    public ProductType getProductTypeByName(String name);
}
