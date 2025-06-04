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
public class deleteProductModel {

   

    private String requestedMethod;
    private int requestData;
    private boolean responseData;
    
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
     * @return the requestData
     */
    @XmlElement
    public int getRequestData() {
        return requestData;
    }

    /**
     * @param requestData the requestData to set
     */
    public void setRequestData(int requestData) {
        this.requestData = requestData;
    }

    /**
     * @return the responseData
     */
    @XmlElement
    public boolean isResponseData() {
        return responseData;
    }

    /**
     * @param responseData the responseData to set
     */
    public void setResponseData(boolean responseData) {
        this.responseData = responseData;
    }
    
}
