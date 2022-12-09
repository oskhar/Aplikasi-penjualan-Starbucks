package controllers;

import models.BayarModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class BayarController {
    
    // ATRIBUTE
    public BayarModel model = new BayarModel();
    public String[][] data;
    Properties prop = new Properties();
    FileInputStream in;
    FileOutputStream out;
    String cookie = model.cookie;

    // CONSTRUCTOR
    public BayarController (String[][] data) {

        // Set data
        this.data = data;

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
        String[][] data = {{"behasil", "tes"},{"g"}};
        new BayarController(data);
    }

}
