package controllers;

import models.BayarModel;

public class BayarController {
    
    // ATRIBUTE
    public BayarModel model = new BayarModel();
    public String[][] data;

    // CONSTRUCTOR
    public BayarController (String[][] data) {

        // Set data
        this.data = data;

    }
    
    public static void main(String[] args) {
        String[][] data = {{"behasil", "tes"},{"g"}};
        new BayarController(data);
    }

}
