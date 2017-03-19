<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleScenicSpotWebServiceProxyid" scope="session" class="com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleScenicSpotWebServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleScenicSpotWebServiceProxyid.getEndpoint();
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
        sampleScenicSpotWebServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.lsm.travelPlan.scenicSpotWsSet.ScenicSpotWebService getScenicSpotWebService10mtemp = sampleScenicSpotWebServiceProxyid.getScenicSpotWebService();
if(getScenicSpotWebService10mtemp == null){
%>
<%=getScenicSpotWebService10mtemp %>
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
        java.lang.String getScenicSpotInfoList15mtemp = sampleScenicSpotWebServiceProxyid.getScenicSpotInfoList();
if(getScenicSpotInfoList15mtemp == null){
%>
<%=getScenicSpotInfoList15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getScenicSpotInfoList15mtemp));
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
        java.lang.String getSearchScenicSpotList18mtemp = sampleScenicSpotWebServiceProxyid.getSearchScenicSpotList(destination_1idTemp);
if(getSearchScenicSpotList18mtemp == null){
%>
<%=getSearchScenicSpotList18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getSearchScenicSpotList18mtemp));
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