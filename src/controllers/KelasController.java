package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class KelasController {

    Properties prop = new Properties();
    FileInputStream in;
    FileOutputStream out;
    String cookie;
    String[][] data;

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
    public String[][] getData (String text) {

        // Variable
        int i;
        String[] ln = text.split(",");
        data = new String[ln.length][2];

        for (i = 0; i < ln.length; i++) {
            data[i][0] = ln[i].split("=")[0];
            data[i][1] = ln[i].split("=")[1];
        }

        return data;

    }

    // METHOD
    public String manipString (String s1, String s2) {

        // Variable
        String beli = getCookie("beli");
        boolean ada = false;
        int i;

        if (checkCookie("beli")) {
            data = getData(beli);
            for (i = 0; i < data.length; i++) {
                if (s1.equals(data[i][0])) {
                    ada = true;
                    data[i][1] = Integer.toString(Integer.parseInt(s2) + Integer.parseInt(data[i][1]));
                }
            }
        }
        if (ada) {
            // Set temp variable
            String[] temp = new String[data.length];
            for (i = 0; i < data.length; i++) {
                temp[i] = String.join("=", data[i]);
            }
            // Set beli
            beli = String.join(",", temp);
        
        } else if (checkCookie("beli")) {
            beli = beli + "," + s1 + "=" + s2;}
        else {
            beli = s1 + "=" + s2;}

        return beli;

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
