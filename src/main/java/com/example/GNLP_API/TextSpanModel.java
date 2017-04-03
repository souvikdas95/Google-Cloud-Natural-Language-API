package com.example.GNLP_API;

import com.google.gson.annotations.SerializedName;

public class TextSpanModel
{
    @SerializedName("content")
    public String content;
    
    @SerializedName("beginOffset")
    public int beginOffset;
    
    public TextSpanModel(){}
}
