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
public class ProductType {
    private String typeID;
    private String typeName;

    /**
     * @return the type
     */
    public String getType() {
        return typeName;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.typeName = type;
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
}
