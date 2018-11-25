/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.controller;

import fiore.flowershop.dao.PromoDAO;
import fiore.flowershop.dao.PromoDAOImpl;
import fiore.flowershop.model.Promotion;
import fiore.flowershop.util.Queue;

/**
 *
 * @author Jasmine
 */
public class PromotionController {
    PromoDAO productDAO;

    public PromotionController() {
        productDAO = new PromoDAOImpl();
    }
    
    public String addPromotion(Promotion p){
        String result = productDAO.addPromotion(p);
        return result;
    }
    
    public Queue<Promotion> getAllPromotions(){
        Queue<Promotion> promos = productDAO.getAllPromotions();
        return promos;
    }
    
    public Queue<Promotion> getMonthPromotion(){
        Queue<Promotion> promos = productDAO.getMonthPromotion();
        return promos;
    }
}
