package com.lsm.travelPlan.wscResultApi;

import com.sun.jersey.api.core.HttpContext;

import com.sun.jersey.api.core.HttpRequestContext;
import com.sun.jersey.api.json.JSONWithPadding;
/*import com.webex.mct.platform.util.CommonUtil;
import com.webex.mct.platform.util.GetConfig;*/

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

public abstract class BaseWebService {
	
/*	public static final String FORWARD_URL = GetConfig.getAttribute("forward_url");
*/
    @Context
    private HttpContext httpContext;

    protected Response getResponseOK(Object result) {
        if (httpContext != null) {
            return Response.ok().entity(result).type(httpContext.getRequest().getMediaType()).build();
        } else {
            return Response.ok().entity(result).build();
        }
    }
    
    protected Response forward(String url) {
    	return Response.status(302).header("Location", /*FORWARD_URL + url*/"").build();
    }

    protected Response getResponse(int status, Object result) {
        if (httpContext != null) {
            return Response.status(status).entity(result).type(httpContext.getRequest().getMediaType()).build();
        } else {
            return Response.status(status).entity(result).build();
        }
    }

    public HttpRequestContext getRequest() {
        return httpContext == null ? null : httpContext.getRequest();
    }

    public Object wrapResult(Object object, String callback) {
      /*  if (CommonUtil.isEmptyString(callback))
            return object;
        else*/
            return new JSONWithPadding(object, callback);
    }
}
