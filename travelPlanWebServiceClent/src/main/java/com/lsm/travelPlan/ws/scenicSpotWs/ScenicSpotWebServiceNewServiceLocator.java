/**
 * ScenicSpotWebServiceNewServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lsm.travelPlan.ws.scenicSpotWs;

public class ScenicSpotWebServiceNewServiceLocator extends org.apache.axis.client.Service implements com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNewService {

    public ScenicSpotWebServiceNewServiceLocator() {
    }


    public ScenicSpotWebServiceNewServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ScenicSpotWebServiceNewServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ScenicSpotWebServiceNew
    private java.lang.String ScenicSpotWebServiceNew_address = "http://localhost:8080/travelPlanWebService/services/ScenicSpotWebServiceNew";

    public java.lang.String getScenicSpotWebServiceNewAddress() {
        return ScenicSpotWebServiceNew_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ScenicSpotWebServiceNewWSDDServiceName = "ScenicSpotWebServiceNew";

    public java.lang.String getScenicSpotWebServiceNewWSDDServiceName() {
        return ScenicSpotWebServiceNewWSDDServiceName;
    }

    public void setScenicSpotWebServiceNewWSDDServiceName(java.lang.String name) {
        ScenicSpotWebServiceNewWSDDServiceName = name;
    }

    public com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNew getScenicSpotWebServiceNew() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ScenicSpotWebServiceNew_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getScenicSpotWebServiceNew(endpoint);
    }

    public com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNew getScenicSpotWebServiceNew(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNewSoapBindingStub _stub = new com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNewSoapBindingStub(portAddress, this);
            _stub.setPortName(getScenicSpotWebServiceNewWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setScenicSpotWebServiceNewEndpointAddress(java.lang.String address) {
        ScenicSpotWebServiceNew_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNew.class.isAssignableFrom(serviceEndpointInterface)) {
                com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNewSoapBindingStub _stub = new com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNewSoapBindingStub(new java.net.URL(ScenicSpotWebServiceNew_address), this);
                _stub.setPortName(getScenicSpotWebServiceNewWSDDServiceName());
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
        if ("ScenicSpotWebServiceNew".equals(inputPortName)) {
            return getScenicSpotWebServiceNew();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://scenicSpotWs.ws.travelPlan.lsm.com", "ScenicSpotWebServiceNewService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://scenicSpotWs.ws.travelPlan.lsm.com", "ScenicSpotWebServiceNew"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ScenicSpotWebServiceNew".equals(portName)) {
            setScenicSpotWebServiceNewEndpointAddress(address);
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
