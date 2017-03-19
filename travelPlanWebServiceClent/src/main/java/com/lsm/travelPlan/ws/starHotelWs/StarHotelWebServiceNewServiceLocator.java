/**
 * StarHotelWebServiceNewServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lsm.travelPlan.ws.starHotelWs;

public class StarHotelWebServiceNewServiceLocator extends org.apache.axis.client.Service implements com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewService {

    public StarHotelWebServiceNewServiceLocator() {
    }


    public StarHotelWebServiceNewServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StarHotelWebServiceNewServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StarHotelWebServiceNew
    private java.lang.String StarHotelWebServiceNew_address = "http://localhost:8080/travelPlanWebService/services/StarHotelWebServiceNew";

    public java.lang.String getStarHotelWebServiceNewAddress() {
        return StarHotelWebServiceNew_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StarHotelWebServiceNewWSDDServiceName = "StarHotelWebServiceNew";

    public java.lang.String getStarHotelWebServiceNewWSDDServiceName() {
        return StarHotelWebServiceNewWSDDServiceName;
    }

    public void setStarHotelWebServiceNewWSDDServiceName(java.lang.String name) {
        StarHotelWebServiceNewWSDDServiceName = name;
    }

    public com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNew getStarHotelWebServiceNew() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StarHotelWebServiceNew_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStarHotelWebServiceNew(endpoint);
    }

    public com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNew getStarHotelWebServiceNew(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewSoapBindingStub _stub = new com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewSoapBindingStub(portAddress, this);
            _stub.setPortName(getStarHotelWebServiceNewWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStarHotelWebServiceNewEndpointAddress(java.lang.String address) {
        StarHotelWebServiceNew_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNew.class.isAssignableFrom(serviceEndpointInterface)) {
                com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewSoapBindingStub _stub = new com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewSoapBindingStub(new java.net.URL(StarHotelWebServiceNew_address), this);
                _stub.setPortName(getStarHotelWebServiceNewWSDDServiceName());
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
        if ("StarHotelWebServiceNew".equals(inputPortName)) {
            return getStarHotelWebServiceNew();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://starHotelWs.ws.travelPlan.lsm.com", "StarHotelWebServiceNewService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://starHotelWs.ws.travelPlan.lsm.com", "StarHotelWebServiceNew"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StarHotelWebServiceNew".equals(portName)) {
            setStarHotelWebServiceNewEndpointAddress(address);
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
