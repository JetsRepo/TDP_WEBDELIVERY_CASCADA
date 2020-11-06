package com.tsoft.bot.frontend.utility.services.https_petitions;

import com.tsoft.bot.frontend.utility.services.DataService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;

import java.util.Map;

public class HttpPetitionPut implements HttpPetition {
    HttpPut httpPut;

    @Override
    public void configurePetition(DataService dataService) {
        httpPut =  new HttpPut(dataService.getEndPoint());
        for (Map.Entry<String, String> conf: dataService.getHeaderConfigurations().asMap().entrySet()){
            httpPut.setHeader(conf.getKey(), conf.getValue());
        }
        httpPut.setEntity(dataService.getRequestFile());
    }

    @Override
    public HttpResponse execute(HttpClient httpClient) throws Throwable {
        return httpClient.execute(httpPut);
    }
}
