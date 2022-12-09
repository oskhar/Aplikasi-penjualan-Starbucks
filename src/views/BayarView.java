package views;

import controllers.BayarController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BayarView extends JFrame implements ActionListener {

    // ATRIBUTE
    JButton[] tombol;
    JButton[] label;
    JButton logout;
    JButton cart;
    JButton prdk;
    JButton clearAll;
    JButton bayar;
    JLabel background;
    JLabel judul;

    BayarController control;
    String pathImg;
    String cookie;
    String img;
    int width;
    int height;
    int penX = 158;
    int penY;

    // CONSTRUCTOR
    public BayarView (String[][] data) {
        
        // Set atribute
        this.control  = new BayarController(data);
        this.pathImg = control.model.locPathImg;
        this.cookie = control.model.cookie;
        this.width = control.model.width;
        this.height = control.model.height;

        // Set container
        setSize(350, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set judul
        judul = new JLabel("HALAMAN PEMBAYARAN");
        judul.setBounds(0, 10, 350, 20);
        judul.setHorizontalAlignment(JLabel.CENTER);
        judul.setFont(new Font("Arial", Font.BOLD, 18));
        judul.setForeground(new Color(31, 33, 48));
        add(judul);

        // Set back button
        logout = new JButton("<< Back");
        logout.setBounds(10, 500, 80, 30);
        logout.setBorder(null);
        logout.setFocusable(false);
        logout.setContentAreaFilled(false);
        logout.addActionListener(this);
        logout.setFont(new Font("Arial", Font.PLAIN, 15));
        add(logout);

        // Set clear button
        clearAll = new JButton("Clear All");
        clearAll.setBounds(115, 500, 100, 30);
        clearAll.setBorder(null);
        clearAll.setFont(new Font("Arial", Font.PLAIN, 15));
        clearAll.setBackground(new Color(220, 53, 69));
        clearAll.setForeground(Color.white);
        clearAll.setFocusable(false);
        clearAll.addActionListener(this);
        add(clearAll);

        // Set clear button
        bayar = new JButton("Bayar");
        bayar.setBounds(230, 500, 100, 30);
        bayar.setBorder(null);
        bayar.setFont(new Font("Arial", Font.PLAIN, 15));
        bayar.setBackground(new Color(40, 167, 69));
        bayar.setForeground(Color.white);
        bayar.setFocusable(false);
        bayar.addActionListener(this);
        add(bayar);

        // Frame painting
        tambahPrdk();
        aturBackground();

        // Show
        setVisible(true);

    }

    // METHOD
    public void aturBackground () {
        // Set background
        setLayout(new BorderLayout());
        background = new JLabel(new ImageIcon(pathImg + "latar.jpg"));
        background.setLayout(new FlowLayout());
        add(background);
    }

    // METHOD
    public void tambahPrdk () {

        int i, index;
        int penY = 40;
        tombol = new JButton[control.data.length];
        label = new JButton[control.data.length];

        for (i = 0; i < control.data.length; i++) {

            // Set data
            index = Integer.parseInt(control.data[i][0]);
            img = pathImg + "sm"+(index+1)+".png";

            // Painting
            tombol[i] = new JButton(new ImageIcon(img));
            label[i] = new JButton(control.model.database[i][1]);
            layoutTombol(tombol[i], 10, (penY+(55*i)), 50, 50);
            layoutLabel(label[i], 80, ((penY+7)+(55*i)), 100, 40);
            add(tombol[i]);
            add(label[i]);

        }
    }

    // METHOD
    public void layoutTombol(JButton el, int x, int y, int wi, int he) {

        // Set layout
        el.setBounds(x, y, wi, he);
        el.setBorder(null);
        el.setBorderPainted(false);
        el.setContentAreaFilled(false);
        el.setOpaque(false);
        el.addActionListener(this);

    }

    // METHOD
    public void layoutLabel(JButton el, int x, int y, int wi, int he) {

        // Set layout
        el.setBounds(x, y, wi, he);
        el.setHorizontalAlignment(JLabel.LEFT);
        el.setFont(new Font("Arial", Font.PLAIN, 14));
        el.setBorder(null);
        el.setBorderPainted(false);
        el.setContentAreaFilled(false);
        el.setOpaque(false);
        el.setForeground(new Color(31, 33, 48));
        el.addActionListener(this);

    }

    // MAIN
    public static void main(String[] args) {
        String data[][] = {{"0", "6"}, {"4", "1"}};
        new BayarView(data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Object
        Object source = e.getSource();

        // Check button
        if (source == clearAll) {}
        
    }

}
