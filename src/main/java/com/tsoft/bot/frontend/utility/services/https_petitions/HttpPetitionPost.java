package com.tsoft.bot.frontend.utility.services.https_petitions;

import com.tsoft.bot.frontend.utility.services.DataService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import java.util.Map;

public class HttpPetitionPost implements HttpPetition {
    HttpPost httpPost;

    @Override
    public void configurePetition(DataService dataService) {
        httpPost =  new HttpPost(dataService.getEndPoint());
        for (Map.Entry<String, String> conf: dataService.getHeaderConfigurations().asMap().entrySet()){
            httpPost.setHeader(conf.getKey(), conf.getValue());
        }
        httpPost.setEntity(dataService.getRequestFile());
    }

    @Override
    public HttpResponse execute(HttpClient httpClient) throws Throwable {
        return httpClient.execute(httpPost);
    }


}
