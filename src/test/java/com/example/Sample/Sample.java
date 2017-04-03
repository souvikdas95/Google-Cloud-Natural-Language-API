package com.example.Sample;

import com.example.GNLP_API.*;

public class Sample
{
    public static void main(String[] args)
    {
        // Google Natural Language Processing
        String szKey = "<API Key>";
        API_GNLP obj = new API_GNLP(szKey);
        String szText = "Hello Fellas! This is Dean Winchester (Though I may sound like Crowley)\n" + 
                        "I am one of the Winchesters who saved this era from darkness;\n" + 
                        "along with my brother ofcourse, Sammy. We had a tough childhood\n" + 
                        ", nevertheless, our dad did a pretty good job in raising us.\n" + 
                        "Now that our mom's back, I guess we can finally hit the roads as a family\n" +
                        "and continue on our family business - Hunting things, Saving People and \n" + 
                        "Eating Burritos! Oh! and not to forget mom's pies. They are the best!";
        RequestModel req = new RequestModel();
        req.document.content = szText;
        req.document.language = "EN";
        req.document.type = DocumentTypeModel.PLAIN_TEXT;
        req.encodingType = EncodingTypeModel.UTF8;
        ResponseModel resp = obj.GetResponse(req);
        if(resp == null)
            return;
        System.out.println("score: " + resp.documentSentiment.score + "\n" +
                           "magnitude: " + resp.documentSentiment.magnitude);
        
    }
}
