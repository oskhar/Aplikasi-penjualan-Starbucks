package views;

import controllers.BayarController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BayarView extends JFrame implements ActionListener {

    // ATRIBUTE
    JButton[] tombol;
    JButton[] label;
    JButton[] tbh;
    JButton[] krn;
    JLabel[] ank;
    JLabel[] harga;
    JLabel total;
    int[] listHarga;
    JButton back;
    JButton clearAll;
    JButton bayar;
    JLabel background;
    JLabel judul;

    BayarController control;
    String pathImg;
    String cookie;
    String img;
    int height;

    // CONSTRUCTOR
    public BayarView (String[][] data) {
        
        // Set atribute
        this.control  = new BayarController(data);
        this.pathImg = control.model.locPathImg;
        this.cookie = control.model.cookie;
        this.height = control.model.height;

        // Set container
        setSize(450, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set judul
        judul = new JLabel("HALAMAN PEMBAYARAN");
        judul.setBounds(0, 10, 450, 20);
        judul.setHorizontalAlignment(JLabel.CENTER);
        judul.setFont(new Font("Arial", Font.BOLD, 18));
        judul.setForeground(new Color(31, 33, 48));
        add(judul);

        // Set back button
        back = new JButton("<< Back");
        back.setBounds(10, 500, 80, 30);
        back.setBorder(null);
        back.setFocusable(false);
        back.setContentAreaFilled(false);
        back.addActionListener(this);
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        add(back);

        // Set clear button
        clearAll = new JButton("Clear All");
        clearAll.setBounds(215, 500, 100, 30);
        clearAll.setBorder(null);
        clearAll.setFont(new Font("Arial", Font.PLAIN, 15));
        clearAll.setBackground(new Color(220, 53, 69));
        clearAll.setForeground(Color.white);
        clearAll.setFocusable(false);
        clearAll.addActionListener(this);
        add(clearAll);

        // Set clear button
        bayar = new JButton("Bayar");
        bayar.setBounds(330, 500, 100, 30);
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

        int i, index, jumlah;
        int penY = 40;
        listHarga = new int[control.data.length];
        tombol = new JButton[control.data.length];
        label = new JButton[control.data.length];
        harga = new JLabel[control.data.length];
        tbh = new JButton[control.data.length];
        krn = new JButton[control.data.length];
        ank = new JLabel[control.data.length];

        for (i = 0; i < control.data.length; i++) {

            // Set data
            index = Integer.parseInt(control.data[i][0]);
            jumlah = Integer.parseInt(control.data[i][1]);
            img = pathImg + "sm"+(index+1)+".png";
            listHarga[i] = Integer.parseInt(control.totalHarga(index,jumlah));

            // Painting
            tombol[i] = new JButton(new ImageIcon(img));
            layoutTombol(tombol[i], 10, (penY+(55*i)), 50, 50);
            add(tombol[i]);

            label[i] = new JButton(control.model.database[index][1]);
            layoutLabel(label[i], 80, ((penY+7)+(55*i)), 100, 40);
            add(label[i]);

            tbh[i] = new JButton(new ImageIcon(pathImg + "tbh.png"));
            layoutTombol(tbh[i], 410, ((penY+15)+(55*i)), 20, 20);
            add(tbh[i]);

            krn[i] = new JButton(new ImageIcon(pathImg + "krn.png"));
            layoutTombol(krn[i], 360, ((penY+15)+(55*i)), 20, 20);
            add(krn[i]);

            ank[i] = new JLabel(jumlah+"");
            ank[i].setBounds(375, ((penY+15)+(55*i)), 40, 20);
            ank[i].setHorizontalAlignment(JLabel.CENTER);
            ank[i].setFont(new Font("Arial", Font.PLAIN, 17));
            ank[i].setForeground(new Color(31, 33, 48));
            add(ank[i]);

            harga[i] = new JLabel("<html><b>Rp </b>"+control.totalHarga(index,jumlah)+"<b>.-</b></html>");
            harga[i].setBounds(200, ((penY+15)+(55*i)), 150, 20);
            harga[i].setHorizontalAlignment(JLabel.LEFT);
            harga[i].setFont(new Font("Arial", Font.PLAIN, 17));
            harga[i].setForeground(new Color(31, 33, 48));
            add(harga[i]);

        }

        total = new JLabel("<html>Total: <b>Rp </b>"+control.sum(listHarga)+"<b>.-</b></html>");
        total.setBounds(230, 460, 200, 20);
        total.setHorizontalAlignment(JLabel.RIGHT);
        total.setFont(new Font("Arial", Font.PLAIN, 17));
        total.setForeground(new Color(31, 33, 48));
        add(total);
        if (control.sum(listHarga).equals("0"))
            bayar.setBackground(new Color(52, 58, 64));

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
        String data[][] = {};
        new BayarView(data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Object
        Object source = e.getSource();
        int i, angka, index;

        // Check button
        for (i = 0; i < control.data.length; i++) {
            angka = Integer.parseInt( ank[i].getText() );
            index = Integer.parseInt(control.data[i][0]);

            if (source == tbh[i]) {
                ank[i].setText(Integer.toString(angka + 1));
                control.setData(i, Integer.toString(angka + 1));
                harga[i].setText("<html><b>Rp </b>" + control.totalHarga(index, (angka + 1)) + "<b>.-</b></html>");
                listHarga[i] = Integer.parseInt(control.totalHarga(index, (angka + 1)));
                total.setText(control.sum(listHarga));
                if (control.sum(listHarga).equals("0"))
                    bayar.setBackground(new Color(52, 58, 64));

            } else if (source == krn[i]) {
                if (angka > 1) {
                    ank[i].setText(Integer.toString(angka - 1));
                    control.setData(i, Integer.toString(angka - 1));
                    harga[i].setText("<html><b>Rp </b>" + control.totalHarga(i,(angka - 1)) + "<b>.-</b></html>");
                    listHarga[i] = Integer.parseInt(control.totalHarga(index, (angka + 1)));
                    total.setText(control.sum(listHarga));

                }
                if (control.sum(listHarga).equals("0"))
                    bayar.setBackground(new Color(52, 58, 64));

            }
        }
        if (source == bayar && !(control.sum(listHarga).equals("0"))) {
            control.bayar(
                control.getCookie("nama"),
                control.getCookie("alamat"),
                control.sum(listHarga)
            );
            new PengirimanView(
                control.getCookie("nama"),
                control.getCookie("alamat"),
                control.sum(listHarga)
            );
            control.deleteCookie("beli");
            this.setVisible(false);
        }
        
    }

}
