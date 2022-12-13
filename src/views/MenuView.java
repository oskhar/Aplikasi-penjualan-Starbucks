package views;

import javax.swing.*;
import controllers.MenuController;
import java.awt.*;
import java.awt.event.*;

public class MenuView extends KelasView implements ActionListener {

    // ATRIBUTE
    JButton[] tombol = new JButton[8];
    JButton[] label = new JButton[8];
    JButton logout;
    JButton cart;
    JButton prdk;
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
        setContainer(width, height);

        // Set judul
        judul = new JLabel("STARBUCKS");
        judul.setBounds(0, 40, width, 40);
        judul.setHorizontalAlignment(JLabel.CENTER);
        judul.setFont(new Font("Arial", Font.BOLD, 24));
        judul.setForeground(new Color(31, 33, 48));
        add(judul);

        // Set back button
        logout = new JButton("<< Logout");
        logout.setBounds(890, 510, 100, 20);
        logout.setBorder(null);
        logout.setFocusable(false);
        logout.setContentAreaFilled(false);
        logout.addActionListener(this);
        logout.setFont(new Font("Arial", Font.PLAIN, 15));
        add(logout);

        // Set shoping cart
        cart = new JButton(new ImageIcon(pathImg + "cart.png"));
        cart.setLayout(null);
        layoutTombol(cart, 950, 30, 20, 16);
        add(cart, 1);

        // Frame painting
        tambahButton();
        tambahLabel();
        notifShoping();

        // Set background
        addBackground(pathImg + "latar.jpg");

        // Show
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
    public void notifShoping () {
        if (control.checkCookie("beli")) {
            prdk = new JButton(new ImageIcon(pathImg + "prdk.png"));
            layoutTombol(prdk, 957, 24, 13, 13);
            add(prdk, 0);
        }
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
        if (source == logout) {

            control.deleteCookie("user");
            control.deleteCookie("pass");
            control.deleteCookie("alamat");
            control.deleteCookie("nama");
            new UserView();
            this.setVisible(false);

        } else if (source == cart || source == prdk) {

            if (control.checkCookie("beli")) {
                new BayarView(control.getData(control.getCookie("beli")));
                this.setVisible(false);

            } else {
                new BayarView(new String[0][0]);
                this.setVisible(false);
            
            }

        }
        for (i = 0; i < control.model.database.length ; i++) {
            if (source == tombol[i] || source == label[i])
                control.changeSlide(this, i);
        }
        
    }

}
