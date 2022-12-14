package views;

import javax.swing.JTable;

import controllers.AdminController;

public class AkunManView extends KelasView {

    // ATRIBUTE
    AdminController control = new AdminController();
    JTable
    
    int width = control.model.width;
    int height = control.model.height;

    String pathImg = control.model.locPathImg;
    
    // CONTAINER
    public AkunManView() {

        // Set container
        setContainer(width, height);

        // Set 

        // Set background
        addBackground(pathImg + "latar.jpg");

    }

}
