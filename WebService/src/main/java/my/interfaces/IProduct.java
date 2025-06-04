/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.interfaces;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import my.model.Products;

/**
 *
 * @author Jenny
 */
@WebService
public interface IProduct {
    
    @WebMethod
    public List<Products> getAllProducts();
    
    @WebMethod
    public boolean deleteProduct(int pno);
    
    @WebMethod
    public boolean updateProduct(int pno, String pname, String type, String manufacturer, Double price, Double weight);
}
