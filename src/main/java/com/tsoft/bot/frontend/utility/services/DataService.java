package com.tsoft.bot.frontend.utility.services;

import org.apache.http.entity.InputStreamEntity;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

public class DataService {

    private InputStreamEntity inputRequestFile;
    private String endPoint;
    private HeaderConfigurations headerConfigurations;
    private Map<String, String> inputData;

    public DataService(String endPoint, HeaderConfigurations headerConfigurations, File requestFile, Map<String, String> inputData) throws Throwable {
        this.endPoint = endPoint;
        this.headerConfigurations = headerConfigurations;
        this.inputData = inputData;
        this.inputRequestFile = new InputStreamEntity(replaceVariables(requestFile));
    }

    public DataService(String endPoint, HeaderConfigurations headerConfigurations) {
        this.endPoint = endPoint;
        this.headerConfigurations = headerConfigurations;
    }

    private InputStream replaceVariables(File file) throws Throwable {
        String body = new BufferedReader(new FileReader(file)).lines().map(Object::toString).collect(Collectors.joining(""));
        for (Map.Entry<String, String> data : inputData.entrySet()) {
            body = body.replaceAll("\\{\\{" + data.getKey() + "}}", data.getValue());
        }
        return new ByteArrayInputStream(body.getBytes());
    }

    public InputStreamEntity getRequestFile() {
        return inputRequestFile;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public HeaderConfigurations getHeaderConfigurations() {
        return headerConfigurations;
    }

}
