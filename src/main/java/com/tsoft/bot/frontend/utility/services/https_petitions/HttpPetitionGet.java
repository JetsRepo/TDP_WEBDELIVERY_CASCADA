package com.tsoft.bot.frontend.utility.services.https_petitions;

import com.tsoft.bot.frontend.utility.services.DataService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.util.Map;

public class HttpPetitionGet implements HttpPetition {
    HttpGet httpGet;

    @Override
    public void configurePetition(DataService dataService) {
        httpGet =  new HttpGet(dataService.getEndPoint());
        for (Map.Entry<String, String> conf: dataService.getHeaderConfigurations().asMap().entrySet()){
            httpGet.setHeader(conf.getKey(), conf.getValue());
        }
    }

    @Override
    public HttpResponse execute(HttpClient httpClient) throws Throwable {
        return httpClient.execute(httpGet);
    }
}