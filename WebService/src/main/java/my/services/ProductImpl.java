/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import my.model.Products;
import my.model.deleteProductModel;
import my.model.getAllProductModel;
import my.model.updateProductModel;

/**
 *
 * @author Jenny
 */
@WebService(endpointInterface = "my.interfaces.IProduct")
public class ProductImpl {

    public List<Products> getAllProducts() {
        List<Products> product = new ArrayList<>();
        try {
            ResultSet rs = null;
            String query = "SELECT * FROM as1_enterprise_app.product";

            Connection con = setDBConnection();
            Statement stmt;

            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                product.add(new Products(rs.getInt("ProductNo"), rs.getString("ProductName"), rs.getString("ProductType"), rs.getString("Manufacturer"), rs.getDouble("Price"), rs.getDouble("Weight")));
                
            }

            rs.close();
            con.close();

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            Date date = new Date();
            String fileName = formatter.format(date) + ".xml";
            getAllProductModel g1 = new getAllProductModel();
            g1.setRequestedMethod("getAllProducts");
            g1.setResponseData(product);
            JAXBContext context = JAXBContext.newInstance(getAllProductModel.class);
            Marshaller m1 = context.createMarshaller();
            m1.marshal(g1, new FileOutputStream(fileName));

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public boolean updateProduct(int pno, String pname, String type, String manufacturer, Double price, Double weight) {
        int check = 0;
        boolean b=false;
        try {

            String query = "UPDATE `as1_enterprise_app`.`product` SET `ProductName` = '" + pname + "',`ProductType` = '" + type + "',`Manufacturer` = '" + manufacturer + "',`Price` = " + price + ",`Weight` = " + weight
                    + "WHERE `ProductNo` = " + pno;

            Connection con = setDBConnection();
            Statement stmt;

            stmt = con.createStatement();
            check = stmt.executeUpdate(query);
            con.close();

            if (check >= 1) {
                b=true;
            } else {
                b=false;
            }

            Products p1 = new Products(pno, pname, type, manufacturer, price, weight);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            Date date = new Date();
            String fileName = formatter.format(date) + ".xml";
            updateProductModel u1 = new updateProductModel();
            u1.setRequestedMethod("updateProduct");
            u1.setRequestData(p1);
            u1.setResponseData(b);
            JAXBContext context = JAXBContext.newInstance(updateProductModel.class);
            Marshaller m1 = context.createMarshaller();
            m1.marshal(u1, new FileOutputStream(fileName));

        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public boolean deleteProduct(int pno) {
        int check = 0;
        boolean b=false;
        try {

            String query = "DELETE FROM `as1_enterprise_app`.`product`\n"
                    + "WHERE  `ProductNo` = " + pno;

            Connection con = setDBConnection();
            Statement stmt;

            stmt = con.createStatement();
            check = stmt.executeUpdate(query);
            con.close();
            
            if (check >= 1) {
                b=true;
            } else {
                b=false;
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            Date date = new Date();
            String fileName = formatter.format(date) + ".xml";
            deleteProductModel d1 = new deleteProductModel();
            d1.setRequestedMethod("deleteProduct");
            d1.setRequestData(pno);
            d1.setResponseData(b);
            JAXBContext context = JAXBContext.newInstance(deleteProductModel.class);
            Marshaller m1 = context.createMarshaller();
            m1.marshal(d1, new FileOutputStream(fileName));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    private Connection setDBConnection() {
        Connection con = null;
        try {
            String db_URL, db_Username, db_Password;
            Class.forName("com.mysql.cj.jdbc.Driver");
            db_URL = "jdbc:mysql://localhost:3306/as1_enterprise_app";
            db_Username = "your_db_username";
            db_Password = "your_db_password";

            con = DriverManager.getConnection(db_URL, db_Username, db_Password);
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
