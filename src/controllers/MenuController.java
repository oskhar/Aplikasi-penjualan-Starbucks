package controllers;

// PUSTAKA
import models.MenuModel;
import views.BeliView;
import views.MenuView;
import views.UserView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

// KELAS
public class MenuController {
    
    // ATRIBUTE
    public MenuModel model = new MenuModel();
    Properties prop = new Properties();
    FileInputStream in;
    String cookie = model.cookie;

    // METHOD
    public void changeSlide (MenuView objc, int angka) {

        // Variable
        int tmp;
        int n = model.database.length;
        int[] data = new int[4];

        // Set data
        for (int i = angka; i < angka+4; i++){
            tmp = i < n ? i : (i % n);
            data[i-angka] = tmp;
        }

        // Change slide
        new BeliView(data);
        objc.setVisible(false);

    }

    public void logout (MenuView objc) {
        
        new UserView();
        objc.setVisible(false);

    }

    // METHOD
    public boolean checkCookie () {

        // Variable
        boolean hasil = false;

        try {
            in = new FileInputStream(cookie);
            prop.load(in);
            String u = prop.getProperty("beli");

            if (!(u.equals("")))
                hasil = true;

        } catch (Exception ex) {System.out.println(ex);}
        return hasil;

    }

    // METHOD
    public void deleteCookie () {
        try {
            
            FileOutputStream out = new FileOutputStream(cookie);
            prop.setProperty("user", "");
            prop.setProperty("pass", "");
            prop.store(out, null);
            out.close();

        } catch (Exception ex) {System.out.println(ex);}
    }

}
