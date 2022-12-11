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
    
}
