/*
Author: Siyamthanda Phakathi
Studenr number: PHKSIY006
Date: 02 August 2024
Program: A Java class containing the attributes of a possible
seller to model shops.
*/

public class Seller {

    private String id;
    private String name;
    private String location;
    private String product;
    private Money unitPrice;
    private int numberOfUnits;

    // Define contructors
    public Seller(){
        this.id = null;
        this.name = null;
        this.location = null;
        this.product = null;
        this.unitPrice = null;
        this.id = null;
        this.id = null;
    }
    public Seller(String id, String name, String location, String product, Money unitPrice, int numberOfUnits) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.product = product;
        this.unitPrice = unitPrice;
        this.numberOfUnits = numberOfUnits;
    }

    // Getters to retrieve the values of the object
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getProduct() {
        return product;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    // Defining setters to modify objects values
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setUnitPrice(Money unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }


}
