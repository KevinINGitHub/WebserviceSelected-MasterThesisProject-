package com.lsm.travelPlan.ws.starHotelWs;

public class StarHotelWebServiceNewProxy implements com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNew {
  private String _endpoint = null;
  private com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNew starHotelWebServiceNew = null;
  
  public StarHotelWebServiceNewProxy() {
    _initStarHotelWebServiceNewProxy();
  }
  
  public StarHotelWebServiceNewProxy(String endpoint) {
    _endpoint = endpoint;
    _initStarHotelWebServiceNewProxy();
  }
  
  private void _initStarHotelWebServiceNewProxy() {
    try {
      starHotelWebServiceNew = (new com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewServiceLocator()).getStarHotelWebServiceNew();
      if (starHotelWebServiceNew != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)starHotelWebServiceNew)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)starHotelWebServiceNew)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (starHotelWebServiceNew != null)
      ((javax.xml.rpc.Stub)starHotelWebServiceNew)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNew getStarHotelWebServiceNew() {
    if (starHotelWebServiceNew == null)
      _initStarHotelWebServiceNewProxy();
    return starHotelWebServiceNew;
  }
  
  public java.lang.String getStarHotelListInfo() throws java.rmi.RemoteException{
    if (starHotelWebServiceNew == null)
      _initStarHotelWebServiceNewProxy();
    return starHotelWebServiceNew.getStarHotelListInfo();
  }
  
  public java.lang.String getSearchStarHotelInfo(java.lang.String destination) throws java.rmi.RemoteException{
    if (starHotelWebServiceNew == null)
      _initStarHotelWebServiceNewProxy();
    return starHotelWebServiceNew.getSearchStarHotelInfo(destination);
  }
  
  
}