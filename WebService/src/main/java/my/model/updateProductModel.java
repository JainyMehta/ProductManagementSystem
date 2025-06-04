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
public class updateProductModel {

    private String requestedMethod;
    private Products requestData;
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
    public Products getRequestData() {
        return requestData;
    }

    /**
     * @param requestData the requestData to set
     */
    public void setRequestData(Products requestData) {
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
