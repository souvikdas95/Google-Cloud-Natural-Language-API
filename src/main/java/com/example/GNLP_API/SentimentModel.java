/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.GNLP_API;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Souvik Das
 */
public class SentimentModel
{
    @SerializedName("magnitude")
    public float magnitude;
    
    @SerializedName("score")
    public float score;
    
    public SentimentModel(){}
}
