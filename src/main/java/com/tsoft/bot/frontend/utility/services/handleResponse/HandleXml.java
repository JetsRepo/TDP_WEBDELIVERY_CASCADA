package com.tsoft.bot.frontend.utility.services.handleResponse;


import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class HandleXml {

    public String getValueTagXML(InputStream inputStream, String getSpecificTag, int position) throws Throwable {
        String data;

        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(inputStream);
        doc.getDocumentElement().normalize();

        Node nNode = doc.getElementsByTagName(getSpecificTag).item(position);
        data = nNode.getTextContent();
        System.out.println(data);
        return data;
    }
}
