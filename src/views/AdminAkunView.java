package views;

import javax.swing.*;
import java.awt.*;
import controllers.AdminController;

public class AdminAkunView extends KelasView {

    // ATRIBUTE
    AdminController control = new AdminController();
    JTable table;
    
    int width = control.model.width;
    int height = control.model.height;
    String pathImg = control.model.locPathImg;
    
    // CONTAINER
    public AdminAkunView() {

        // Variable
        String[] judul = {"Email", "Password", "Nama", "Alamat"};

        // Set container
        setContainer(width, height);

        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 900, 470);
        panel.setBackground(new Color(0, 0, 0, 0));;
        panel.setOpaque(false);
        add(panel);

        // Set table
        table = new JTable(control.model.databaseAkun, judul);
        table.setBounds(0, 0, 900, 470);
        panel.add(new JScrollPane(table));

        // Painting
        addBackground(pathImg + "latar.jpg");
        setVisible(true);

    }

    public static void main(String[] args) {
        new AdminAkunView();
    }

}
