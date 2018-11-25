/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.model;

/**
 *
 * @author Jasmine
 */
public class Promotion {
    private String promoID;
    private String promoName;
    private Product productID;
    private String monthyear;
    private double discount;

    /**
     * @return the promoID
     */
    public String getPromoID() {
        return promoID;
    }

    /**
     * @param promoID the promoID to set
     */
    public void setPromoID(String promoID) {
        this.promoID = promoID;
    }

    /**
     * @return the promoName
     */
    public String getPromoName() {
        return promoName;
    }

    /**
     * @param promoName the promoName to set
     */
    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    /**
     * @return the productID
     */
    public Product getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(Product productID) {
        this.productID = productID;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the monthyear
     */
    public String getMonthyear() {
        return monthyear;
    }

    /**
     * @param monthyear the monthyear to set
     */
    public void setMonthyear(String monthyear) {
        this.monthyear = monthyear;
    }
    
    
    
}
