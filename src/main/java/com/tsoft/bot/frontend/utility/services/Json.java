package com.tsoft.bot.frontend.utility.services;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Map;

public class Json {


    public static String detailsResponseString(HttpResponse response) throws Throwable{
        System.out.println("Resultado: " + response.getStatusLine().getStatusCode());
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";

        StringBuffer sb = new StringBuffer();
        String jsonString="";
        while ((line = br.readLine()) != null)
        {
            sb.append(line);

            jsonString =sb.toString();

        }
        return jsonString;


    }


    public static String getStringFromJson(String json, String key){


        JSONObject jsonObject = new JSONObject(json);
        String jsonString=jsonObject.getString(key);

        return jsonString;
    }

    public static String getFromJson(String json, String key){

        JSONObject jsonObject = new JSONObject(json);

        String jsonString="";

        jsonString=jsonObject.getString(key);

        return jsonString;
    }

    public static String getFromJson(String tipe,String json, String key,String objectName){
        JSONObject jsonObject = new JSONObject(json);

        String jsonString="";
        switch (tipe){

            case "string":
                jsonString=jsonObject.getString(key);
                break;
            case "object":
                JSONObject newJsonObject = jsonObject.getJSONObject(objectName);
                jsonString=newJsonObject.getString(key);
                break;
            default:
                System.out.println("not found" +tipe);
        }

        return jsonString;
    }

    public static String getFromJson(String tipe,String json, String key,String objectName, String objectName2){
        JSONObject jsonObject = new JSONObject(json);

        String jsonString="";
        JSONObject newJsonObject2 = null;
        switch (tipe){

            case "string":
                jsonString=jsonObject.getString(key);
                break;
            case "object":
                JSONObject newJsonObject = jsonObject.getJSONObject(objectName);


                newJsonObject2 = newJsonObject.getJSONObject(objectName2);

                jsonString=newJsonObject2.getString(key);
                break;
            default:
                System.out.println("not found" +tipe);

        }

        return jsonString;
    }


    public static String getFromJson(String tipe,String json, String key,String objectName, String objectName2, String objectName3){
        JSONObject jsonObject = new JSONObject(json);

        String jsonString="";
        JSONObject newJsonObject2 = null;
        JSONObject newJsonObject3 = null;
        switch (tipe){

            case "string":
                jsonString=jsonObject.getString(key);
                break;
            case "object":
                JSONObject newJsonObject = jsonObject.getJSONObject(objectName);
                newJsonObject2 = newJsonObject.getJSONObject(objectName2);
                newJsonObject3 = newJsonObject2.getJSONObject(objectName3);

                jsonString=newJsonObject3.getString(key);

                break;
            default:
                System.out.println("not found" +tipe);
        }

        return jsonString;
    }



    public static boolean validarID(String id,String url, HeaderConfigurations headerConfigurations) throws Throwable{


        String urlFinal = url+id;
        Service service = new Service("GET", new DataService(urlFinal, headerConfigurations));
        HttpResponse response = service.create().build();

       String resultado=detailsResponseString(response);

        System.out.println(resultado);

        if(response.getStatusLine().getStatusCode()==200){
            return true;

        }else {
            return false;

        }

    }

    public static String getTokenFromExcel(String url, Map<String, String> dataInput , String file, HeaderConfigurations headerConfigurations) throws Throwable {

        String casoDePrueba = "1";

        File requestFile = new File(file);

        Service service = new Service("POST", new DataService(url, headerConfigurations, requestFile, dataInput));
        HttpResponse response = service.create().build();
        String resultado=detailsResponseString(response);

        return Json.getFromJson("string",resultado,"token","");
    }


}
