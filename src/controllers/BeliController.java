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

        String beli = getCookie("beli");

        if (checkCookie("beli"))
            beli = beli + "," + s1 + "=" + s2;
        else
            beli = s1 + "=" + s2;

        return beli;

    }

    public static void main(String[] args) {
        new BeliController();
    }
    
}
