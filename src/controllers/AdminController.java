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

}
