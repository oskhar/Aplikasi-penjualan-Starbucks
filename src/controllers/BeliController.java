package controllers;

import models.BeliModel;

public class BeliController extends KelasController {
    
    // ATRIBUTE
    public BeliModel model = new BeliModel();
    public String data[][];

    // CONSTRUCTOR
    public BeliController () {

        // Set data
        cookie = model.cookie;

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

    public String manipString (String s1, String s2) {

        // Variable
        String beli = getCookie("beli");
        String[][] data = getData(beli);
        boolean ada = false;
        int i;

        for (i = 0; i < data.length; i++) {
            if (s1.equals(data[i][0])) {
                ada = true;
                data[i][1] = Integer.toString(Integer.parseInt(s2) + Integer.parseInt(data[i][1]));
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
            beli = beli + "," + s1 + "=" + s2;

        } else {
            beli = s1 + "=" + s2;

        }

        return beli;

    }
    
}
