package controllers;

import models.BeliModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class BeliController {
    
    // ATRIBUTE
    public BeliModel model = new BeliModel();
    public String data[][];
    Properties prop = new Properties();
    FileInputStream in;
    FileOutputStream out;
    String cookie = model.cookie;
    String beli;

    // CONSTRUCTOR
    public BeliController () {

        if (config())
            getCookie();

    }

    // METHOD
    public boolean config () {

        boolean hasil = false;
        try {
            in = new FileInputStream(cookie);
            prop.load(in);
            beli = prop.getProperty("beli");
            if (!(beli.equals(""))) 
                hasil = true;
        } catch (Exception ex) {System.out.println(ex);}
        return hasil;
    }

    // METHOD
    public void getCookie () {

        // Variable
        int i;
        String[] ln = beli.split(",");
        data = new String[ln.length][2];

        for (i = 0; i < ln.length; i++) {
            data[i][0] = ln[i].split("=")[0];
            data[i][1] = ln[i].split("=")[1];
        }

    }

    public void setCookie (String s1, String s2) {

        if (config())
            beli = beli + "," + s1 + "=" + s2;
        else
            beli = s1 + "=" + s2;
        
        getCookie();
        
        try {
            out = new FileOutputStream(cookie);
            prop.setProperty("beli", beli);
            prop.store(out, null);
            out.close();

        } catch (Exception ex) {System.out.println(ex);}

    }

    // METHOD
    public void deleteCookie () {
        try {
            
            out = new FileOutputStream(cookie);
            prop.setProperty("beli", "");
            prop.store(out, null);
            out.close();

        } catch (Exception ex) {System.out.println(ex);}
    }

    public static void main(String[] args) {
        new BeliController();
    }
    
}
