/**
 * TrainTicketWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lsm.travelPlan.trainTicketWs;

public class TrainTicketWebServiceServiceLocator extends org.apache.axis.client.Service implements com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceService {

    public TrainTicketWebServiceServiceLocator() {
    }


    public TrainTicketWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TrainTicketWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TrainTicketWebService
    private java.lang.String TrainTicketWebService_address = "http://localhost:8080/travelPlanWebService/services/TrainTicketWebService";

    public java.lang.String getTrainTicketWebServiceAddress() {
        return TrainTicketWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TrainTicketWebServiceWSDDServiceName = "TrainTicketWebService";

    public java.lang.String getTrainTicketWebServiceWSDDServiceName() {
        return TrainTicketWebServiceWSDDServiceName;
    }

    public void setTrainTicketWebServiceWSDDServiceName(java.lang.String name) {
        TrainTicketWebServiceWSDDServiceName = name;
    }

    public com.lsm.travelPlan.trainTicketWs.TrainTicketWebService getTrainTicketWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TrainTicketWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrainTicketWebService(endpoint);
    }

    public com.lsm.travelPlan.trainTicketWs.TrainTicketWebService getTrainTicketWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceSoapBindingStub _stub = new com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTrainTicketWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrainTicketWebServiceEndpointAddress(java.lang.String address) {
        TrainTicketWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.lsm.travelPlan.trainTicketWs.TrainTicketWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceSoapBindingStub _stub = new com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceSoapBindingStub(new java.net.URL(TrainTicketWebService_address), this);
                _stub.setPortName(getTrainTicketWebServiceWSDDServiceName());
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
        if ("TrainTicketWebService".equals(inputPortName)) {
            return getTrainTicketWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://trainTicketWs.travelPlan.lsm.com", "TrainTicketWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://trainTicketWs.travelPlan.lsm.com", "TrainTicketWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TrainTicketWebService".equals(portName)) {
            setTrainTicketWebServiceEndpointAddress(address);
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
