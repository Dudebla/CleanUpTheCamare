package com.example.front_end_of_clean_up_the_camera_app.Tools;

import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

public class ServerConnection  {


    public HttpURLConnection connection = null;

//    private static String IP = "http://54.37.47.153:8080/";

    private static String IP = "http://192.168.43.86:8080/";

    private String server;

    private String requestMethod;

    public ServerConnection(String server, String requestMethod){
        this.server = server;
        this.requestMethod = requestMethod;
        URL url;
        try {
            url = new URL(IP + server);
            this.connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestMethod(requestMethod);
        }catch (Exception e){
            Log.e("exception: ", e.getMessage());
            e.printStackTrace();
        }
    }

    public HttpURLConnection getConnection(){

        return this.connection;
    }

}
