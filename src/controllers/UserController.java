package controllers;

// PUSTAKA
import models.UserModel;

// KELAS
public class UserController {

    // ATRIBUTE
    public UserModel model;
    public String nama = "";
    public String alamat = "";

    // CONSTRUCTOR
    public UserController () {

        // Object
        this.model = new UserModel();

    }

    // METHOD
    public boolean cekEmail (String email) {

        // Variable
        boolean hasil = false;
        int i;

        // Search data
        for (i = 0; i < model.database.length; i++) {
            if (model.database[i][0].equals(email))
                hasil = true;

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
        boolean c3 = !(cekEmail(user));
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
        boolean c3 = cekEmail(email);
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


    public static void main (String[] s) {
        new UserController();
    }
    
}
