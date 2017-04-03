package com.example.GNLP_API;

import com.google.gson.annotations.SerializedName;

public class DocumentModel
{
    @SerializedName("type")
    public DocumentTypeModel type;
    
    @SerializedName("language")
    public String language;
    
    @SerializedName("content")
    public String content;
    
    @SerializedName("gcsContentUri")
    public String gcsContentUri;
    
    public DocumentModel(){}
}
