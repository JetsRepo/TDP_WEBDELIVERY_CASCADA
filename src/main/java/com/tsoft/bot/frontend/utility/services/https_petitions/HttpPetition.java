package com.tsoft.bot.frontend.utility.services.https_petitions;

import com.tsoft.bot.frontend.utility.services.DataService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

public interface HttpPetition {

    void configurePetition(DataService dataService);

    HttpResponse execute(HttpClient httpClient) throws Throwable;

}
