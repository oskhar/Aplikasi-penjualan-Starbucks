package controllers;

import models.AdminModel;

public class AdminController extends KelasController{
    
    // ATRIBUTE
    public AdminModel model = new AdminModel();

    // CONTAINER
    public AdminController () {

        // Set data
        cookie = model.cookie;

    }

    // METHOD
    public String sumHarga (String[][] data) {

        // Variable
        int hasil = 0;
        int i;

        // Looping
        for (i = 0; i < data.length; i++) {
            hasil += Integer.parseInt(data[i][2]);

        }
        return hasil+"";
    }

    // METHOD
    public String[][] dbReplaced (String[][] data) {
        String[][] hasil = new String[data.length][6];
        int i;

        for (i = 0; i < data.length; i++) {
            hasil[i][0] = data[i][0];
            hasil[i][2] = data[i][2];
            hasil[i][3] = data[i][3];
            hasil[i][4] = data[i][4];
            hasil[i][5] = data[i][5];
            hasil[i][1] = data[i][1].replace("<br>", "");
            hasil[i][1] = hasil[i][1].replace("<html>", "");
            hasil[i][1] = hasil[i][1].replace("</html>", "");
        }
        return hasil;

    }

}
