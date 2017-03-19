<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleStarHotelWebServiceNewProxyid" scope="session" class="com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNewProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleStarHotelWebServiceNewProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleStarHotelWebServiceNewProxyid.getEndpoint();
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
        sampleStarHotelWebServiceNewProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.lsm.travelPlan.ws.starHotelWs.StarHotelWebServiceNew getStarHotelWebServiceNew10mtemp = sampleStarHotelWebServiceNewProxyid.getStarHotelWebServiceNew();
if(getStarHotelWebServiceNew10mtemp == null){
%>
<%=getStarHotelWebServiceNew10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        java.lang.String getStarHotelListInfo15mtemp = sampleStarHotelWebServiceNewProxyid.getStarHotelListInfo();
if(getStarHotelListInfo15mtemp == null){
%>
<%=getStarHotelListInfo15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getStarHotelListInfo15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String destination_1id=  request.getParameter("destination21");
            java.lang.String destination_1idTemp = null;
        if(!destination_1id.equals("")){
         destination_1idTemp  = destination_1id;
        }
        java.lang.String getSearchStarHotelInfo18mtemp = sampleStarHotelWebServiceNewProxyid.getSearchStarHotelInfo(destination_1idTemp);
if(getSearchStarHotelInfo18mtemp == null){
%>
<%=getSearchStarHotelInfo18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getSearchStarHotelInfo18mtemp));
        %>
        <%= tempResultreturnp19 %>
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