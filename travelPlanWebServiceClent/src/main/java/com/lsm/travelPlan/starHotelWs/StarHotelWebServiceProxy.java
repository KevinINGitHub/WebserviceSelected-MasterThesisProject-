package com.lsm.travelPlan.starHotelWs;

public class StarHotelWebServiceProxy implements com.lsm.travelPlan.starHotelWs.StarHotelWebService {
  private String _endpoint = null;
  private com.lsm.travelPlan.starHotelWs.StarHotelWebService starHotelWebService = null;
  
  public StarHotelWebServiceProxy() {
    _initStarHotelWebServiceProxy();
  }
  
  public StarHotelWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initStarHotelWebServiceProxy();
  }
  
  private void _initStarHotelWebServiceProxy() {
    try {
      starHotelWebService = (new com.lsm.travelPlan.starHotelWs.StarHotelWebServiceServiceLocator()).getStarHotelWebService();
      if (starHotelWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)starHotelWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)starHotelWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (starHotelWebService != null)
      ((javax.xml.rpc.Stub)starHotelWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.lsm.travelPlan.starHotelWs.StarHotelWebService getStarHotelWebService() {
    if (starHotelWebService == null)
      _initStarHotelWebServiceProxy();
    return starHotelWebService;
  }
  
  public java.lang.String getStarHotelInfo() throws java.rmi.RemoteException{
    if (starHotelWebService == null)
      _initStarHotelWebServiceProxy();
    return starHotelWebService.getStarHotelInfo();
  }
  
  
}