package controllers;

import javax.swing.JLabel;

// PUSTAKA
import models.UserModel;

// KELAS
public class UserController extends KelasController {

    // ATRIBUTE
    public UserModel model = new UserModel();
    public String nama = "";
    public String alamat = "";

    // CONSTRUCTOR
    public UserController () {

        // Object
        this.cookie = model.cookie;

    }

    // METHOD
    public boolean verAkun (JLabel objc, String s1, String s2) {

        // Variable
        boolean hasil = false;

        // Verification acount
        if (verUser(s1, s2)){
            hasil = true;
            try {
                
                setCookie("user", s1);
                setCookie("pass", s2);
                setCookie("nama", nama);
                setCookie("alamat", alamat);

            } catch (Exception ex) {System.out.println(ex);}

        }else{
            objc.setText("Password atau Email salah");
        
        }
        return hasil;
    }

    // METHOD
    public boolean verUser (String user, String pass) {

        // Variable
        boolean hasil = false;
        int i;

        // Search data
        for (i = 0; i < model.database.length; i++) {
            if (model.database[i][0].equals(user) && model.database[i][1].equals(pass)){
                nama = model.database[i][2];
                alamat = model.database[i][3];
                hasil = true;
            }

        }
        return hasil;

    }

    // METHOD
    public String addUser (String user, String pass, String passUlang, String nama, String alamat) {

        // Variable
        String hasil = "false";
        String data;
        boolean c1 = pass.length() >= 6;
        boolean c2 = passUlang.equals(pass);
        boolean c3 = !(checkCookie(user));
        data = "'" + user + "', '" + pass + "', '" + nama + "', '" + alamat + "'";

        // Check validasi data
        if ( c1 && c2 && c3) {
            model.sqlInsert("akun", data);
            hasil = "true";

        } else if (c1 && c2) {
            hasil = "email";

        } else if (c2 && c3) {
            hasil = "ppass";

        } else if (c1 && c3) {
            hasil = "epass";

        }

        return hasil;

    }

    public String changePass (String email, String pass, String passUlang) {

        // Variable
        String hasil = "false";
        boolean c1 = pass.length() >= 6;
        boolean c2 = passUlang.equals(pass);
        boolean c3 = checkCookie(email);
        String data = "pass='" + pass + "'";
        String lokasi = "email='" + email + "'";
        
        // Check validasi data
        if ( c1 && c2 && c3) {
            model.sqlUpdate("akun", data, lokasi);
            hasil = "true";

        } else if (c1 && c2) {
            hasil = "email";

        } else if (c2 && c3) {
            hasil = "ppass";

        } else if (c1 && c3) {
            hasil = "epass";

        }

        return hasil;

    }
    
}