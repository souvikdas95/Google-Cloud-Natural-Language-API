package com.example.GNLP_API;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ResponseModel
{
    @SerializedName("documentSentiment")
    public SentimentModel documentSentiment = new SentimentModel();
    
    @SerializedName("language")
    public String language;
    
    @SerializedName("sentences")
    public List<SentenceModel> sentences = new ArrayList<SentenceModel>();
    
    public ResponseModel(){}
}
