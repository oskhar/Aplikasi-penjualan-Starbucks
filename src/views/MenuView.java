package views;

import javax.swing.*;

import controllers.MenuController;

import java.awt.*;
import java.awt.event.*;

public class MenuView extends JFrame implements ActionListener {

    // ATRIBUTE
    JButton[] tombol = new JButton[8];
    JButton[] label = new JButton[8];
    JLabel background;
    JLabel judul;

    MenuController control = new MenuController();
    String pathImg = control.model.locPathImg;
    String img;
    int width;
    int height;
    int penX = 158;
    int penY;

    // CONSTRUCTOR
    public MenuView () {
        
        // Set atribute
        this.width = control.model.width;
        this.height = control.model.height;

        // Set container
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set judul
        judul = new JLabel("STARBUCKS");
        judul.setBounds(0, 40, 1000, 20);
        judul.setHorizontalAlignment(JLabel.CENTER);
        judul.setFont(new Font("Arial", Font.BOLD, 18));
        judul.setForeground(new Color(31, 33, 48));
        add(judul);

        // Frame painting
        tambahButton();
        tambahLabel();

        // Set background
        img = pathImg + "latar.jpg";
        setLayout(new BorderLayout());
        background = new JLabel(new ImageIcon(img));
        background.setLayout(new FlowLayout());
        add(background);

        // Show frame
        setVisible(true);

    }

    // METHOD
    public void tambahButton () {
        
        // Variable
        int i, j;

        // Looping
        for (i = 0; i < 8; i++){
        
            // Painting
            j = i < 4 ? i : (i % 4);
            penY = i < 4 ? 134 : 314;
            img = pathImg + control.model.database[i][0];
            tombol[i] = new JButton(new ImageIcon(img));
            layoutTombol(tombol[i], penX+(193*j), penY, 100, 100);
            this.add(tombol[i]);
        
        }
    }

    // METHOD
    public void tambahLabel () {
        
        // Variable
        int i, j;

        // Looping
        for (i = 0; i < 8; i++){

            // Painting
            j = i < 4 ? i : (i % 4);
            penY = i < 4 ? 235 : 415;
            label[i] = new JButton(control.model.database[i][1]);
            layoutLabel(label[i], penX+(193*j), penY, 100, 40);
            this.add(label[i]);
        
        }
    }
    
    // METHOD
    public void layoutTombol(JButton el, int x, int y, int wi, int he) {

        el.setBounds(x, y, wi, he);
        el.setBorder(null);
        el.setBorderPainted(false);
        el.setContentAreaFilled(false);
        el.setOpaque(false);
        el.addActionListener(this);

    }

    // METHOD set label
    public void layoutLabel(JButton el, int x, int y, int wi, int he) {

        el.setBounds(x, y, wi, he);
        el.setHorizontalAlignment(JLabel.CENTER);
        el.setFont(new Font("Arial", Font.BOLD, 15));
        el.setBorder(null);
        el.setBorderPainted(false);
        el.setContentAreaFilled(false);
        el.setOpaque(false);
        el.setForeground(new Color(31, 33, 48));
        el.addActionListener(this);

    }

    // METHOD
    public static void main(String[] args) {
        new MenuView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Object & Variable
        Object source = e.getSource();
        int i;

        // Check button
        for (i = 0; i < control.model.database.length ; i++) {
            if (source == tombol[i] || source == label[i])
                control.changeSlide(this, i);
        }
        
    }

}
