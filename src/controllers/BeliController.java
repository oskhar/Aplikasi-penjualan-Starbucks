package controllers;

import models.BeliModel;
import views.BeliView;

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
    public void changeSlide (BeliView objc, int angka) {

        // Variable
        int tmp;
        int n = model.getCount("minuman");
        int[] data = new int[4];

        // Set data
        for (int i = angka; i < angka + 4; i++){
            tmp = i < n ? i : (i % n);
            data[i-angka] = tmp;
        }

        // Change slide
        new BeliView(data);
        objc.setVisible(false);

    }
    
}
