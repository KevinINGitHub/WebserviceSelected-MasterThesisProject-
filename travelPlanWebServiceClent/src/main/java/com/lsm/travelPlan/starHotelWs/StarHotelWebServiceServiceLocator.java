/**
 * StarHotelWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lsm.travelPlan.starHotelWs;

public class StarHotelWebServiceServiceLocator extends org.apache.axis.client.Service implements com.lsm.travelPlan.starHotelWs.StarHotelWebServiceService {

    public StarHotelWebServiceServiceLocator() {
    }


    public StarHotelWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StarHotelWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StarHotelWebService
    private java.lang.String StarHotelWebService_address = "http://localhost:8080/travelPlanWebService/services/StarHotelWebService";

    public java.lang.String getStarHotelWebServiceAddress() {
        return StarHotelWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StarHotelWebServiceWSDDServiceName = "StarHotelWebService";

    public java.lang.String getStarHotelWebServiceWSDDServiceName() {
        return StarHotelWebServiceWSDDServiceName;
    }

    public void setStarHotelWebServiceWSDDServiceName(java.lang.String name) {
        StarHotelWebServiceWSDDServiceName = name;
    }

    public com.lsm.travelPlan.starHotelWs.StarHotelWebService getStarHotelWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StarHotelWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStarHotelWebService(endpoint);
    }

    public com.lsm.travelPlan.starHotelWs.StarHotelWebService getStarHotelWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.lsm.travelPlan.starHotelWs.StarHotelWebServiceSoapBindingStub _stub = new com.lsm.travelPlan.starHotelWs.StarHotelWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getStarHotelWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStarHotelWebServiceEndpointAddress(java.lang.String address) {
        StarHotelWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.lsm.travelPlan.starHotelWs.StarHotelWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.lsm.travelPlan.starHotelWs.StarHotelWebServiceSoapBindingStub _stub = new com.lsm.travelPlan.starHotelWs.StarHotelWebServiceSoapBindingStub(new java.net.URL(StarHotelWebService_address), this);
                _stub.setPortName(getStarHotelWebServiceWSDDServiceName());
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
        if ("StarHotelWebService".equals(inputPortName)) {
            return getStarHotelWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://starHotelWs.travelPlan.lsm.com", "StarHotelWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://starHotelWs.travelPlan.lsm.com", "StarHotelWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StarHotelWebService".equals(portName)) {
            setStarHotelWebServiceEndpointAddress(address);
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
