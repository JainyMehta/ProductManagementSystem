/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jenny
 */
@XmlRootElement
public class getAllProductModel {

    

    private String requestedMethod;
    private List<Products> responseData;

    /**
     * @return the requestedMethod
     */
    @XmlElement
    public String getRequestedMethod() {
        return requestedMethod;
    }

    /**
     * @param requestedMethod the requestedMethod to set
     */
    public void setRequestedMethod(String requestedMethod) {
        this.requestedMethod = requestedMethod;
    }

    /**
     * @return the responseData
     */
    @XmlElement
    public List<Products> getResponseData() {
        return responseData;
    }

    /**
     * @param responseData the responseData to set
     */
    public void setResponseData(List<Products> responseData) {
        this.responseData = responseData;
    }

}
