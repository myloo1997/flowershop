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
public class Consumer extends Customer{
    private String icNo;

    /**
     * @return the icNo
     */
    public String getIcNo() {
        return icNo;
    }

    /**
     * @param icNo the icNo to set
     */
    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }
}
