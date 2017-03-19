package com.lsm.travelPlan.scenicSpotWs;

public class ScenicSpotWebServiceProxy implements com.lsm.travelPlan.scenicSpotWs.ScenicSpotWebService {
  private String _endpoint = null;
  private com.lsm.travelPlan.scenicSpotWs.ScenicSpotWebService scenicSpotWebService = null;
  
  public ScenicSpotWebServiceProxy() {
    _initScenicSpotWebServiceProxy();
  }
  
  public ScenicSpotWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initScenicSpotWebServiceProxy();
  }
  
  private void _initScenicSpotWebServiceProxy() {
    try {
      scenicSpotWebService = (new com.lsm.travelPlan.scenicSpotWs.ScenicSpotWebServiceServiceLocator()).getScenicSpotWebService();
      if (scenicSpotWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)scenicSpotWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)scenicSpotWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (scenicSpotWebService != null)
      ((javax.xml.rpc.Stub)scenicSpotWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.lsm.travelPlan.scenicSpotWs.ScenicSpotWebService getScenicSpotWebService() {
    if (scenicSpotWebService == null)
      _initScenicSpotWebServiceProxy();
    return scenicSpotWebService;
  }
  
  public java.lang.String getScenicSpotInfo() throws java.rmi.RemoteException{
    if (scenicSpotWebService == null)
      _initScenicSpotWebServiceProxy();
    return scenicSpotWebService.getScenicSpotInfo();
  }
  
  
}