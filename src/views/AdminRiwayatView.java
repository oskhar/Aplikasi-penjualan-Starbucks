package views;

import javax.swing.*;
import java.awt.*;
import controllers.AdminController;

public class AdminRiwayatView extends KelasView {

    // ATRIBUTE
    AdminController control = new AdminController();
    JTable table;
    
    int width = control.model.width;
    int height = control.model.height;
    String pathImg = control.model.locPathImg;
    
    // CONTAINER
    public AdminRiwayatView() {

        // Variable
        String[] judul = {"Nama", "Alamat", "Harga Total"};

        // Set container
        setContainer(width, height);

        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 900, 270);
        panel.setBackground(new Color(0, 0, 0, 0));;
        panel.setOpaque(false);
        add(panel);

        // Set table
        table = new JTable(control.model.databaseRiwayat, judul);
        table.setBounds(0, 0, 900, 270);
        panel.add(new JScrollPane(table));

        // Painting
        addBackground(pathImg + "latar.jpg");
        setVisible(true);

    }

    public static void main(String[] args) {
        new AdminRiwayatView();
    }

}
