package com.example.GNLP_API;

import com.google.gson.annotations.SerializedName;

public class SentenceModel
{
    @SerializedName("text")
    public TextSpanModel text = new TextSpanModel();;
    
    @SerializedName("sentiment")
    public SentimentModel sentiment = new SentimentModel();
    
    public SentenceModel(){}
}
