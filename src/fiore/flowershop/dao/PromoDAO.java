/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.dao;
import fiore.flowershop.model.Promotion;
import fiore.flowershop.util.Queue;
/**
 *
 * @author Jasmine
 */
public interface PromoDAO {
    public String addPromotion(Promotion p);
    public Queue<Promotion> getAllPromotions();
    public Queue<Promotion> getMonthPromotion();
}
