<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTrainTicketWebServiceProxyid" scope="session" class="com.lsm.travelPlan.trainTicketWs.TrainTicketWebServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTrainTicketWebServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleTrainTicketWebServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleTrainTicketWebServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.lsm.travelPlan.trainTicketWs.TrainTicketWebService getTrainTicketWebService10mtemp = sampleTrainTicketWebServiceProxyid.getTrainTicketWebService();
if(getTrainTicketWebService10mtemp == null){
%>
<%=getTrainTicketWebService10mtemp %>
<%
}else{
        if(getTrainTicketWebService10mtemp!= null){
        String tempreturnp11 = getTrainTicketWebService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String from_1id=  request.getParameter("from16");
            java.lang.String from_1idTemp = null;
        if(!from_1id.equals("")){
         from_1idTemp  = from_1id;
        }
        String to_2id=  request.getParameter("to18");
            java.lang.String to_2idTemp = null;
        if(!to_2id.equals("")){
         to_2idTemp  = to_2id;
        }
        String date_3id=  request.getParameter("date20");
            java.lang.String date_3idTemp = null;
        if(!date_3id.equals("")){
         date_3idTemp  = date_3id;
        }
        java.lang.String getTrainTicketInfo13mtemp = sampleTrainTicketWebServiceProxyid.getTrainTicketInfo(from_1idTemp,to_2idTemp,date_3idTemp);
if(getTrainTicketInfo13mtemp == null){
%>
<%=getTrainTicketInfo13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getTrainTicketInfo13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>