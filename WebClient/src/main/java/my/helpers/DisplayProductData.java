/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.helpers;

import java.util.List;
import my.interfaces.Products;
import my.services.IProduct;
import my.services.ProductImplService;

/**
 *
 * @author Jenny
 */
public class DisplayProductData {
    
    public static String getData(){
        ProductImplService serv = new ProductImplService();
            IProduct port = serv.getProductImplPort();
            List<Products> p1 = port.getAllProducts();
        String dataString = "<h1>Product Details</h1>";
        dataString+= "<table class=\"w3-table w3-bordered w3-striped w3-border test w3-hoverable\"><tr class=\"w3-green\"><th>ProductNo</th><th>Name</th>"
                + "<th>Type</th><th>Manufacturer</th><th>Price</th><th>Weight</th></tr>";
        for(Products p2: p1){
            dataString+="<tr>"
                    + "<td>"+p2.getProductNo()+"</td>"
                    + "<td>"+p2.getProductName()+"</td>"
                    + "<td>"+p2.getProductType()+"</td>"
                    + "<td>"+p2.getManufacturer()+"</td>"
                    + "<td>"+p2.getPrice()+"</td>"
                    + "<td>"+p2.getWeight()+"</td></tr>";
        }
        dataString+="</table>";
        String path = System.getProperty("user.dir");
        //System.out.println("Relative path is "+path);
        return dataString;
        
    }
}
