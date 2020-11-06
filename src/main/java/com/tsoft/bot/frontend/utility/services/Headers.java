package com.tsoft.bot.frontend.utility.services;

public class Headers {

    public void setHeaders(String header1){

        HeaderConfigurations headerConfigurations = new HeaderConfigurations();
        headerConfigurations.setHeader("Content-Type", "application/json").setHeader("Accept", "*/*");

    }

    public void setHeaders(String header1,String header2){

        HeaderConfigurations headerConfigurations = new HeaderConfigurations();
        headerConfigurations.setHeader("Content-Type", "application/json").setHeader("Accept", "*/*");

    }


}
