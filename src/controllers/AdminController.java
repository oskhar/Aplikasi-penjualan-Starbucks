package controllers;

import models.AdminModel;

public class AdminController extends KelasController{
    
    // ATRIBUTE
    public AdminModel model;

    // CONTAINER
    public AdminController () {

        // Set data
        cookie = model.cookie;
        model = new AdminModel();

    }

}
