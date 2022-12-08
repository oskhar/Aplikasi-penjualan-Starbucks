package controllers;

// PUSTAKA
import models.MenuModel;
import views.BeliView;
import views.MenuView;
import views.UserView;

// KELAS
public class MenuController {
    
    // ATRIBUTE
    public MenuModel model;

    // CONSTRUCTOR
    public MenuController () {

        // Object
        this.model = new MenuModel();

    }

    // METHOD
    public void changeSlide (MenuView objc, int angka) {

        // Variable
        int tmp;
        int n = model.database.length;
        int[] data = new int[4];

        // Set data
        for (int i = angka; i < angka+4; i++){
            tmp = i < n ? i : (i % n);
            data[i-angka] = tmp;
        }

        // Change slide
        new BeliView(data);
        objc.setVisible(false);

    }

    public void logout (MenuView objc) {
        
        new UserView();
        objc.setVisible(false);

    }

}
