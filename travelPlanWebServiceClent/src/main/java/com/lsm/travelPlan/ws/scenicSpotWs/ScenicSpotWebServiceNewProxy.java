package com.lsm.travelPlan.ws.scenicSpotWs;

public class ScenicSpotWebServiceNewProxy implements com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNew {
  private String _endpoint = null;
  private com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNew scenicSpotWebServiceNew = null;
  
  public ScenicSpotWebServiceNewProxy() {
    _initScenicSpotWebServiceNewProxy();
  }
  
  public ScenicSpotWebServiceNewProxy(String endpoint) {
    _endpoint = endpoint;
    _initScenicSpotWebServiceNewProxy();
  }
  
  private void _initScenicSpotWebServiceNewProxy() {
    try {
      scenicSpotWebServiceNew = (new com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNewServiceLocator()).getScenicSpotWebServiceNew();
      if (scenicSpotWebServiceNew != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)scenicSpotWebServiceNew)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)scenicSpotWebServiceNew)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (scenicSpotWebServiceNew != null)
      ((javax.xml.rpc.Stub)scenicSpotWebServiceNew)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.lsm.travelPlan.ws.scenicSpotWs.ScenicSpotWebServiceNew getScenicSpotWebServiceNew() {
    if (scenicSpotWebServiceNew == null)
      _initScenicSpotWebServiceNewProxy();
    return scenicSpotWebServiceNew;
  }
  
  public java.lang.String getSearchScenicSpotList(java.lang.String destination) throws java.rmi.RemoteException{
    if (scenicSpotWebServiceNew == null)
      _initScenicSpotWebServiceNewProxy();
    return scenicSpotWebServiceNew.getSearchScenicSpotList(destination);
  }
  
  public java.lang.String getScenicSpotInfoList() throws java.rmi.RemoteException{
    if (scenicSpotWebServiceNew == null)
      _initScenicSpotWebServiceNewProxy();
    return scenicSpotWebServiceNew.getScenicSpotInfoList();
  }
  
  
}