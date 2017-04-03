package com.example.GNLP_API;

import com.google.gson.annotations.SerializedName;

public class RequestModel
{
    @SerializedName("document")
    public DocumentModel document = new DocumentModel();
    
    @SerializedName("encodingType")
    public EncodingTypeModel encodingType;
    
    public RequestModel(){}
}
