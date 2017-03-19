package com.lsm.travelPlan.trainTicketWs;

public class TrainTicketWebServiceProxy implements com.lsm.travelPlan.trainTicketWs.TrainTicketWebService {
  private String _endpoint = null;
  private com.lsm.travelPlan.trainTicketWs.TrainTicketWebService trainTicketWebService = null;
  
  public TrainTicketWebServiceProxy() {
    _initTrainTicketWebServiceProxy();
  }
  
  public TrainTicketWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTrainTicketWebServiceProxy();
  }
  
  private void _initTrainTicketWebServiceProxy() {
    try {
      trainTicketWebService = (new com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceServiceLocator()).getTrainTicketWebService();
      if (trainTicketWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)trainTicketWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)trainTicketWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (trainTicketWebService != null)
      ((javax.xml.rpc.Stub)trainTicketWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.lsm.travelPlan.trainTicketWs.TrainTicketWebService getTrainTicketWebService() {
    if (trainTicketWebService == null)
      _initTrainTicketWebServiceProxy();
    return trainTicketWebService;
  }
  
  public java.lang.String getTrainTicketInfo(java.lang.String from, java.lang.String to, java.lang.String date) throws java.rmi.RemoteException{
    if (trainTicketWebService == null)
      _initTrainTicketWebServiceProxy();
    return trainTicketWebService.getTrainTicketInfo(from, to, date);
  }
  
  
}