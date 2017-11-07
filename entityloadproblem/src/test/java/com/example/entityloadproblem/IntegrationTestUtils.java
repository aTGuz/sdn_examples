package com.example.entityloadproblem;

public class IntegrationTestUtils {
    public static String buildEndPointUrl(int port,String endpoint,Object... params){
        String par = "";
        for (Object param : params)
            par+="/"+param;
        return buildEndPointUrl(port,endpoint)+par;
    }

    public static String buildEndPointUrl(int port,String endpoint){
        return "http://localhost:" + port+"/" + endpoint;
    }
}
