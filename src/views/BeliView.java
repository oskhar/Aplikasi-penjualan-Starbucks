package views;

import controllers.BeliController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BeliView extends KelasView implements ActionListener{
    
    // ATRIBUTE
    BeliController control = new BeliController();
    
    JLabel[] komponen = new JLabel[4];
    JButton[] t = new JButton[4];
    JButton[] l = new JButton[4];
    JLabel latar;
    JLabel ank;
    JLabel notif;

    JButton back;
    JButton beli1;
    JButton beli2;
    JButton tbh;
    JButton krn;
    JButton prdk;
    JButton cart;
    JButton harganya;

    String pathImg = control.model.locPathImg;
    String img;
    int[] data = new int[4];

    public BeliView (int[] data) {

        // Set value
        this.data = data;

        // Container
        setContainer(1000, 570);

        // Set back button
        back = new JButton("Back");
        layoutTombol(back, 20, 20, 100, 25, hitam, putih, 15);
        back.addActionListener(this);
        add(back);

        // Set latar component
        latar = new JLabel(new ImageIcon(pathImg + "komponen1.png"));
        latar.setBounds(60, 310, 860, 260);
        add(latar);

        // Set latar component
        notif = new JLabel(new ImageIcon(pathImg + "notifMasuk.png"));
        notif.setBounds(790, 600, 195, 70);
        add(notif);

        // Set shoping cart
        cart = new JButton(new ImageIcon(pathImg + "cart.png"));
        cart.setLayout(null);
        layoutImg(cart, 950, 30, 20, 16);
        cart.addActionListener(this);
        add(cart, 1);

        // Frame painting
        tambahTombolAksi();
        tambahComponent();
        notifShoping();

        // Set background
        addBackground(pathImg + "latar3.jpg");

        // Show frame
        setVisible(true);

    }

    // METHOD
    public void tambahTombolAksi () {

        tbh = new JButton(new ImageIcon(pathImg+"tbh.png"));
        layoutImg(tbh, 800, 148, 20, 20);
        tbh.addActionListener(this);
        add(tbh);

        krn = new JButton(new ImageIcon(pathImg+"krn.png"));
        layoutImg(krn, 750, 148, 20, 20);
        krn.addActionListener(this);
        add(krn);
        
        beli1 = new JButton("Beli");
        layoutTombol(beli1, 850, 140, 100, 36, hitam, putih, 16);
        beli1.addActionListener(this);
        add(beli1);

        beli2 = new JButton("Tambah Keranjang");
        layoutTombol(beli2, 720, 200, 230, 36, hitam, putih, 16);
        beli2.addActionListener(this);
        add(beli2);

        ank = new JLabel("1");
        ank.setBounds(765, 148, 40, 20);
        ank.setHorizontalAlignment(JLabel.CENTER);
        ank.setFont(new Font("Arial", Font.BOLD, 16));
        ank.setForeground(hitam);
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
            l[i] = new JButton(control.model.database[data[i]][1]);

            img = pathImg + control.model.database[data[i]][0];
            if (i == 0) {
                komponen[i].setBounds(penX[i], penY, 200, 200);
                komponen[i].setLayout(null);
                add(komponen[i]);
                t[i] = new JButton( new ImageIcon(pathImg + "bm" + (data[i]+1) + ".png") );
                layoutImg( t[i], 25, 25, 150, 150 );
                t[i].addActionListener(this);

                l[i] = new JButton(control.model.database[data[i]][1].replace("<br>", " ").replace("<html>", "").replace("</html>", ""));
                layoutTombol(l[i], 70, 120, 350, 50, transparent, hitam, 30);
                l[i].setHorizontalAlignment(JButton.LEFT);
                l[i].setContentAreaFilled(false);
                add(l[i]);

                harganya = new JButton("<html><font color='#f07c57'>Rp</font> "+manipHarga(control.model.database[data[i]][3])+"<font color='#f07c57'>.-</font></html>");
                layoutTombol(harganya, 70, 165, 250, 40, transparent, hitam, 24);
                harganya.setHorizontalAlignment(JButton.LEFT);
                harganya.setContentAreaFilled(false);
                add(harganya);

            } else {
                komponen[i].setBounds(penX[i], penY, 150, 150);
                komponen[i].setLayout(null);
                latar.add(komponen[i]);
                t[i] = new JButton( new ImageIcon(img));
                layoutImg( t[i], 25, 25, 100, 100 );
                t[i].addActionListener(this);

                layoutLabel(l[i], penX[i], (penY + 160), 150, 40);
                l[i].setForeground(Color.white);
                l[i].addActionListener(this);
                latar.add(l[i]);
            }
            komponen[i].add(t[i]);
            

        }

    }

    // METHOD
    public void notifShoping () {
        if (control.checkCookie("beli")) {
            prdk = new JButton(new ImageIcon(pathImg + "prdk.png"));
            layoutImg(prdk, 957, 24, 13, 13);
            prdk.addActionListener(this);
            add(prdk, 0);
        }
    }

    // METHOD
    public void layoutLabel(JButton el, int x, int y, int wi, int he) {

        // Set layout
        el.setBounds(x, y, wi, he);
        el.setHorizontalAlignment(JLabel.CENTER);
        el.setFont(new Font("Arial", Font.BOLD, 18));
        el.setBorder(null);
        el.setBorderPainted(false);
        el.setContentAreaFilled(false);
        el.setOpaque(false);
        el.setForeground(hitam);
        el.addActionListener(this);

    }

    public static void main(String[] args) {
        int[] d = {0,1,2,3};
        new BeliView(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Object
        Object source = e.getSource();
        int i;

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

        } else if (source == beli2) {
            String beliValue = control.manipString(Integer.toString(data[0]), ank.getText());
            control.setCookie("beli", beliValue);
            notif.setBounds(790, 50, 195, 70);
            notifShoping();

        } else if (source == cart || source == prdk) {

            if (control.checkCookie("beli")) {
                new BayarView(control.getData(control.getCookie("beli")));
                this.setVisible(false);

            } else {
                new BayarView(new String[0][0]);
                this.setVisible(false);
            
            }

        }

        for (i = 1; i <= 3; i++) {
            if (source == t[i] || source == l[i]) {
                control.changeSlide(this, data[i]);

            }
        }
        
    }

}
