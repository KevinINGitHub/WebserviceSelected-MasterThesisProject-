/**
 * ScenicSpotWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lsm.travelPlan.scenicSpotWsSet;

public class ScenicSpotWebServiceServiceLocator extends org.apache.axis.client.Service implements com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebServiceService {

    public ScenicSpotWebServiceServiceLocator() {
    }


    public ScenicSpotWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ScenicSpotWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ScenicSpotWebService
    private java.lang.String ScenicSpotWebService_address = "http://localhost:8080/travelPlanWebServiceCenter/services/ScenicSpotWebService";

    public java.lang.String getScenicSpotWebServiceAddress() {
        return ScenicSpotWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ScenicSpotWebServiceWSDDServiceName = "ScenicSpotWebService";

    public java.lang.String getScenicSpotWebServiceWSDDServiceName() {
        return ScenicSpotWebServiceWSDDServiceName;
    }

    public void setScenicSpotWebServiceWSDDServiceName(java.lang.String name) {
        ScenicSpotWebServiceWSDDServiceName = name;
    }

    public com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebService getScenicSpotWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ScenicSpotWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getScenicSpotWebService(endpoint);
    }

    public com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebService getScenicSpotWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebServiceSoapBindingStub _stub = new com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getScenicSpotWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setScenicSpotWebServiceEndpointAddress(java.lang.String address) {
        ScenicSpotWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebServiceSoapBindingStub _stub = new com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebServiceSoapBindingStub(new java.net.URL(ScenicSpotWebService_address), this);
                _stub.setPortName(getScenicSpotWebServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ScenicSpotWebService".equals(inputPortName)) {
            return getScenicSpotWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://scenicSpotWsSet.travelPlan.lsm.com", "ScenicSpotWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://scenicSpotWsSet.travelPlan.lsm.com", "ScenicSpotWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ScenicSpotWebService".equals(portName)) {
            setScenicSpotWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
