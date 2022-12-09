package controllers;

// PUSTAKA
import models.MenuModel;
import views.BeliView;
import views.MenuView;

// KELAS
public class MenuController extends KelasController {
    
    // ATRIBUTE
    public MenuModel model = new MenuModel();

    // METHOD
    public void changeSlide (MenuView objc, int angka) {

        // Variable
        int tmp;
        int n = model.getCount("minuman");
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

}
