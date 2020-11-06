package com.tsoft.bot.frontend.utility;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;

public class Email {

    private static final String EXCEL = "excel/PlazaVea.xlsx";
    private static final String HOJA = "Ingreso";



    public boolean match(Message message) {
        try {
            if (message.getSubject().contains("Ordretest")) {
                System.out.println("match found");
                return true;
            }
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    };

    public static void GetCode() throws Throwable {

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        props.put("mail.imap-mail.outlook.com.ssl.enable", "true");
        props.put("mail.pop3.host", "outlook.com");
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.starttls.enable", "true");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("outlook.office365.com", "abraham.rivera@tsoftglobal.com", "Tsoft2018");
            session.setDebug(true);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);


            SearchTerm sender = new FromTerm(new InternetAddress("tsoft-carlos.ayala@spsa.pe"));

            Message[] messages = inbox.search(sender);
            System.out.println(messages);


            for (int i = 0 ; i < messages.length ; i++) {
                System.out.println(messages[i].getSubject());
                String OK = messages[i].getSubject();
                String OK_1 = OK.substring(24, OK.length() -0);
                ExcelReader.writeCellValue(EXCEL, HOJA, 1, 3, OK_1);
                System.out.println(OK.substring(24, OK.length() -0));
                if (messages[i].getSubject().equals(null)) {
                    System.out.println("null in subject");
                    break;
                }
                else if (messages[i].getSubject().contains("Ordretest")){
                    System.out.println("1 match found");
                }
                else {
                    System.out.println("no match");
                }
            }
            System.out.println("no more messages");
            store.close();

        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

}
