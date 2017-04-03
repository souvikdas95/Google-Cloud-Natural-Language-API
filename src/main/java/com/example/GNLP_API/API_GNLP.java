package com.example.GNLP_API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class API_GNLP
{
    private static final String ENDPOINT_GNLP = "https://language.googleapis.com";
    private static final String ENDPOINT_GNLP_ANALYZESENTIMENT_POST = "/v1/documents:analyzeSentiment";
    
    private final String szAPIKey;
    
    public API_GNLP(String szAPIKey)
    {
        this.szAPIKey = szAPIKey;        
    }
    
    public ResponseModel GetResponse(RequestModel arg)
    {
        try
        {
            if(szAPIKey == null)
                return null;
            URL url = new URL(ENDPOINT_GNLP + ENDPOINT_GNLP_ANALYZESENTIMENT_POST + "?" +
                            "key=" + this.szAPIKey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(gson.toJsonTree(arg).toString());
            wr.flush();
            wr.close();
            conn.connect();
            if(conn.getResponseCode() != HttpURLConnection.HTTP_OK)
                return null;
            BufferedReader rr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = rr.read(chars)) != -1)
                buffer.append(chars, 0, read);
            String szJSON = buffer.toString();
            System.out.println(szJSON);
            JsonObject jo = new JsonParser().parse(szJSON).getAsJsonObject();
            ResponseModel ret = gson.fromJson(jo, ResponseModel.class);
            return ret;
        }
        catch (JsonSyntaxException | IOException ex)
        {
            Logger.getLogger(API_GNLP.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
