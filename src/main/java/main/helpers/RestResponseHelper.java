package main.helpers;

import com.google.gson.Gson;

public class RestResponseHelper {
    private static final Gson gson = new Gson();

    public static String getErrorResponseString() {
        Response response = new Response();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getSuccesResponse() {
        Response response = new Response();
        response.setSuccess(true);
        return gson.toJson(response);
    }
}
