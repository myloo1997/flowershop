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
public class Product {
    private String productID;
    private String productName;
    private String typeID;
    private String typeName;
    private double price;
    private int stocked;

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the typeID
     */
    public String getTypeID() {
        return typeID;
    }

    /**
     * @param typeID the typeID to set
     */
    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    @Override
    public String toString() {
        String i = this.productID + ":" + this.productName;
        return i;
    }

    /**
     * @return the stocked
     */
    public int getStocked() {
        return stocked;
    }

    /**
     * @param stocked the stocked to set
     */
    public void setStocked(int stocked) {
        this.stocked = stocked;
    }
    
}
