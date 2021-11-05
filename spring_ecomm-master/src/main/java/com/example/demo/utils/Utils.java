package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	
	public static String getBaseURL(HttpServletRequest request) {
	    String scheme = request.getScheme();
	    String serverName = request.getServerName();
	    int serverPort = request.getServerPort();
	    String contextPath = request.getContextPath();
	    StringBuffer url =  new StringBuffer();
	    url.append(scheme).append("://").append(serverName);
	    if ((serverPort != 80) && (serverPort != 443)) {
	        url.append(":").append(serverPort);
	    }
	    url.append(contextPath);
	    if(url.toString().endsWith("/")){
	    	url.append("/");
	    }
	    return url.toString();
	}
	
	public static final String END_POINT_URL = "https://s3.us-east-2.amazonaws.com";
	public static final String ACCESS_KEY = "AKIA3XBVVNJQC7X5WLPZ";
	public static final String SECRET_KEY = "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";
	public static final String BUCKET_NAME = "congnguyen-bucket";
}
