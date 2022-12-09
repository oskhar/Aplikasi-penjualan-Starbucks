package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class KelasController {

    Properties prop = new Properties();
    FileInputStream in;
    FileOutputStream out;
    String cookie;

    // METHOD
    public void deleteCookie (String key) {
        try {
            
            out = new FileOutputStream(cookie);
            prop.setProperty(key, "");
            prop.store(out, null);
            out.close();

        } catch (Exception ex) {System.out.println(ex);}
    }

    // METHOD
    public void setCookie (String key, String value) {
        try {
            
            in = new FileInputStream(cookie);
            prop.load(in);
            out = new FileOutputStream(cookie);
            prop.setProperty(key, value);
            prop.store(out, null);
            out.close();

        } catch (Exception ex) {System.out.println(ex);}
    }

    // METHOD
    public boolean checkCookie (String key) {

        // Variable
        boolean hasil = false;

        try {
            in = new FileInputStream(cookie);
            prop.load(in);
            String u = prop.getProperty(key);

            if (!(u.equals("")))
                hasil = true;

        } catch (Exception ex) {System.out.println(ex);}
        return hasil;

    }

    // METHOD
    public String getCookie (String key) {

        // Variable
        String hasil = "";

        try {
            in = new FileInputStream(cookie);
            prop.load(in);
            hasil = prop.getProperty(key);

        } catch (Exception ex) {System.out.println(ex);}

        return hasil;

    }
    
}
