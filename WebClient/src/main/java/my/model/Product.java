/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jenny
 */
@XmlRootElement
public class Product {
    private int ProductNo;
    private String ProductName;
    private String ProductType;
    private String Manufacturer;
    private double Price;
    private double Weight;

      public Product(int ProductNo, String ProductName, String ProductType, String Manufacturer, double Price, double Weight) {
        this.ProductNo = ProductNo;
        this.ProductName = ProductName;
        this.ProductType = ProductType;
        this.Manufacturer = Manufacturer;
        this.Price = Price;
        this.Weight = Weight;
    }
    /**
     * @return the ProductNo
     */
      @XmlElement
    public int getProductNo() {
        return ProductNo;
    }

    /**
     * @param ProductNo the ProductNo to set
     */
    public void setProductNo(int ProductNo) {
        this.ProductNo = ProductNo;
    }

    /**
     * @return the ProductName
     */
    @XmlElement
    public String getProductName() {
        return ProductName;
    }

    /**
     * @param ProductName the ProductName to set
     */
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    /**
     * @return the ProductType
     */
    @XmlElement
    public String getProductType() {
        return ProductType;
    }

    /**
     * @param ProductType the ProductType to set
     */
    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }

    /**
     * @return the Manufacturer
     */
    @XmlElement
    public String getManufacturer() {
        return Manufacturer;
    }

    /**
     * @param Manufacturer the Manufacturer to set
     */
    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    /**
     * @return the Price
     */
    @XmlElement
    public double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }

    /**
     * @return the Weight
     */
    @XmlElement
    public double getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(double Weight) {
        this.Weight = Weight;
    }
}
