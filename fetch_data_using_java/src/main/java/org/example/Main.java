package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url=null;
        HttpURLConnection connection=null;
        int responseCode=0;
        String httpUrl="https://api.chucknorris.io/jokes/random";

        try{
            url=new URL(httpUrl);
        }
        catch (Exception e){
            System.out.println("Problem With the Url.. ");
        }

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("connection problem");
        }
        if(responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while ((readLine = in.readLine()) != null) {
                apiData.append(readLine);
            }

            //
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println(apiData.toString());
            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());

        }
        else{
            System.out.println("Something wrong has happend ....");
        }

        }
}
