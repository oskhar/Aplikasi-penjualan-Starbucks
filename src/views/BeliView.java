package views;

import controllers.BeliController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BeliView extends JFrame implements ActionListener {
    
    // ATRIBUTE
    BeliController control = new BeliController();
    
    JLabel[] komponen = new JLabel[4];
    JLabel background;
    JLabel latar;
    JLabel ank;

    JButton back;
    JButton beli1;
    JButton beli2;
    JButton tbh;
    JButton krn;
    JButton prdk;
    JButton[] t = new JButton[4];

    String pathImg = control.model.locPathImg;
    String img;
    int[] data = new int[4];

    public BeliView (int[] data) {

        // Set value
        this.data = data;

        // CONTAINER
        setSize(1000, 570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set back button
        back = new JButton("<< Back");
        back.setBounds(10, 10, 100, 20);
        back.setBorder(null);
        back.setFocusable(false);
        back.setContentAreaFilled(false);
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        add(back);

        // Set latar component
        latar = new JLabel(new ImageIcon(pathImg + "komponen1.png"));
        latar.setBounds(60, 310, 860, 260);
        add(latar);

        // Frame painting
        tambahTombolAksi();
        tambahComponent();
        tambahMinuman();

        // Set background
        setLayout(new BorderLayout());
        background = new JLabel(new ImageIcon(pathImg + "latar.jpg"));
        background.setLayout(new FlowLayout());
        add(background);

        // Show frame
        setVisible(true);

    }

    // METHOD
    public void tambahTombolAksi () {

        tbh = new JButton(new ImageIcon(pathImg+"tbh.png"));
        layoutTombol(tbh, 280, 216, 20, 20);
        add(tbh);

        krn = new JButton(new ImageIcon(pathImg+"krn.png"));
        layoutTombol(krn, 230, 216, 20, 20);
        add(krn);
        
        beli1 = new JButton(new ImageIcon(pathImg+"beli1.png"));
        layoutTombol(beli1, 30, 200, 176, 55);
        add(beli1);

        beli2 = new JButton(new ImageIcon(pathImg+"beli2.png"));
        layoutTombol(beli2, 55, 260, 176, 55);
        add(beli2);

        ank = new JLabel("1");
        ank.setBounds(245, 216, 40, 20);
        ank.setHorizontalAlignment(JLabel.CENTER);
        ank.setFont(new Font("Arial", Font.BOLD, 16));
        ank.setForeground(new Color(31, 33, 48));
        add(ank);

    }

    // METHOD
    public void tambahComponent () {

        // Variable
        int i;
        int[] penX = {425, 155, 355, 555};
        int penY;

        // Painting
        for (i = 0; i < 4; i++) {
            penY = i == 0 ? 45 : 0;
            img = pathImg + ("biji" + (i+1) + ".png");
            komponen[i] = new JLabel(new ImageIcon(img));
            komponen[i].setBounds(penX[i], penY, 200, 200);
            komponen[i].setLayout(null);

            if (i == 0)
                add(komponen[i]);
            else
                latar.add(komponen[i]);

        }

    }

    // METHOD
    public void tambahMinuman () {

        // Variable
        int i;

        // Looping
        for (i = 0; i < 4; i++) {
            
            // Set data
            img = pathImg + control.model.database[data[i]][0];
            
            // Painting
            if (i == 0) {
                t[i] = new JButton( new ImageIcon(pathImg + "bm" + (data[i]+1) + ".png") );
                layoutTombol( t[i], 25, 25, 150, 150 );
            } else {
                t[i] = new JButton( new ImageIcon(img));
                layoutTombol( t[i], 50, 50, 100, 100 );
            }
            komponen[i].add(t[i]);
            
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
        if (control.checkCookie("")) {
            prdk = new JButton(new ImageIcon(pathImg + "prdk.png"));
            layoutTombol(prdk, 957, 24, 13, 13);
            add(prdk);
        }
    }

    public static void main(String[] args) {
        int[] d = {0,1,2,3};
        new BeliView(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Object
        Object source = e.getSource();

        // Check button
        if (source == tbh) {
            int angka = Integer.parseInt( ank.getText() );
            ank.setText("" + ( angka + 1 ));

        } else if (source == krn) {
            int angka = Integer.parseInt( ank.getText() );
            if (angka > 1) 
                ank.setText("" + ( angka - 1 ));

        } else if (source == back) {
            new MenuView();
            this.setVisible(false);

        } else if (source == beli1) {
            
            String beliValue = control.manipString(Integer.toString(data[0]), ank.getText());
            control.setCookie("beli", beliValue);

            new BayarView(control.getData(beliValue));
            this.setVisible(false);

        } else if (source == beli1) {
            String beliValue = control.manipString(Integer.toString(data[0]), ank.getText());
            control.setCookie("beli", beliValue);

        }
        
    }

}
