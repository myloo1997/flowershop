/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.model;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author Jasmine
 */
public class CustomerOrder {
    private String orderID;
    private Customer customerID;
    private LocalDate orderDate;
    private double totalAmount;
    private int purchaseMode;
    private LocalDate pickupDeliveryDate;
    private LocalTime pickupDeliveryTime;
    private int paid;
    private int received;
    private String deliveryAddress;
    private String paymentMode;

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the customerID
     */
    public Customer getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the orderDate
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the purchaseMode
     */
    public int getPurchaseMode() {
        return purchaseMode;
    }

    /**
     * @param purchaseMode the purchaseMode to set
     */
    public void setPurchaseMode(int purchaseMode) {
        this.purchaseMode = purchaseMode;
    }

    /**
     * @return the pickupDate
     */
    public LocalDate getPickupDate() {
        return pickupDeliveryDate;
    }

    /**
     * @param pickupDate the pickupDate to set
     */
    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDeliveryDate = pickupDate;
    }

    /**
     * @return the pickupTime
     */
    public LocalTime getPickupTime() {
        return pickupDeliveryTime;
    }

    /**
     * @param pickupTime the pickupTime to set
     */
    public void setPickupTime(LocalTime pickupTime) {
        this.pickupDeliveryTime = pickupTime;
    }

    /**
     * @return the paid
     */
    public int isPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(int paid) {
        this.paid = paid;
    }

    /**
     * @return the received
     */
    public int getReceived() {
        return received;
    }

    /**
     * @param received the received to set
     */
    public void setReceived(int received) {
        this.received = received;
    }

    /**
     * @return the deliveryAddress
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * @param deliveryAddress the deliveryAddress to set
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * @return the paymentMode
     */
    public String getPaymentMode() {
        return paymentMode;
    }

    /**
     * @param paymentMode the paymentMode to set
     */
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
    
    
}
