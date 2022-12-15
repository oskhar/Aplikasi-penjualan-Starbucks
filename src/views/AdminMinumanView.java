package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.AdminController;

public class AdminMinumanView extends KelasView implements ActionListener {

    // ATRIBUTE
    AdminController control = new AdminController();
    JTable table;
    JButton back;
    
    int width = control.model.width;
    int height = control.model.height;
    String pathImg = control.model.locPathImg;
    
    // CONTAINER
    public AdminMinumanView() {

        // Variable
        String[] judul = {"Image Path", "Nama", "Rate", "Harga"};

        // Set container
        setContainer(width, height);

        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 900, 470);
        panel.setBackground(new Color(0, 0, 0, 0));;
        panel.setOpaque(false);
        add(panel);

        // Set table
        table = new JTable(control.dbReplaced(control.model.databaseMinuman), judul);
        table.setBounds(0, 0, 900, 470);
        panel.add(new JScrollPane(table));

        // Set button
        back = new JButton("Back");
        back.addActionListener(this);
        layoutTombol(back, 880, 500, 100, 25, hitam, putih, 15);
        add(back);

        // Painting
        addBackground(pathImg + "latar.jpg");
        setVisible(true);

    }

    public static void main(String[] args) {
        new AdminMinumanView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Object
        Object source = e.getSource();

        // Check button
        if (source == back) {
            new AdminMenuView();
            setVisible(false);
        }
        
    }

}
