package views;

import javax.swing.*;

import models.KelasModel;

import java.awt.*;
import java.awt.event.*;


public class PengirimanView extends KelasView implements ActionListener {

    // ATRIBUTE
    JLabel text;
    JButton hiasan;
    JButton back;
    public KelasModel model = new KelasModel();

    // CONSTRUCTOR
    public PengirimanView (String nama, String alamat, String hargaTot, String[][] database) {

        // Configurasi
        model.sqlCon();
        
        // Variable
        int i;
        String tmp;

        // Set container
        setContainer(450, 570);

        // Painting
        String data = "<html><font color='#28a745'>Pembelian berhasil!</font><br><br><font color='#1f2130'>Nama: " + nama + 
                                                                                                      "<br>Alamat pengiriman: " + alamat + 
                                                                                                      "<br><br><center><b>PESANAN</b></center><br>";
        // LOOPING
        for (i = 0; i < database.length; i++) {
            tmp = database[i][0].replace("<html>", "");
            tmp = tmp.replace("<br>", " ");
            tmp = tmp.replace("</html>", "");
            tmp = tmp.toLowerCase();
            data += tmp + " (" + database[i][1] + "): <font align='right' color='#1f2130'>Rp " + manipHarga(database[i][2]) + ".- </font><br>";
        }

        // Set text
        data += "</font><br><br><br><p align='right' color='#1f2130' width='400'>total:<br>Rp " + manipHarga(hargaTot) + ".- </p></html>";
        text = new JLabel(data);
        text.setForeground(new Color(40, 167, 69));
        text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        text.setBounds(30, 20, 410, 530);
        text.setVerticalAlignment(JLabel.TOP);
        add(text);

        // Set hiasan
        hiasan = new JButton(new ImageIcon(model.locPathImg + "hiasan.png"));
        hiasan.setBounds(255, 420, 70, 100);
        hiasan.setBorder(null);
        hiasan.setBorderPainted(false);
        hiasan.setContentAreaFilled(false);
        hiasan.setOpaque(false);
        add(hiasan);

        // Set hiasan
        hiasan = new JButton(new ImageIcon(model.locPathImg + "hiasan.png"));
        hiasan.setBounds(295, 420, 70, 100);
        hiasan.setBorder(null);
        hiasan.setBorderPainted(false);
        hiasan.setContentAreaFilled(false);
        hiasan.setOpaque(false);
        add(hiasan);

        // Set hiasan
        hiasan = new JButton(new ImageIcon(model.locPathImg + "hiasan.png"));
        hiasan.setBounds(335, 420, 70, 100);
        hiasan.setBorder(null);
        hiasan.setBorderPainted(false);
        hiasan.setContentAreaFilled(false);
        hiasan.setOpaque(false);
        add(hiasan);


        back = new JButton("back");
        layoutTombol(back, 20, 490, 160, 30, hitam, putih, 16);
        back.addActionListener(this);
        add(back);

        // Painting
        addBackground(model.locPathImg + "latar.jpg");
        setVisible(true);

    }

	@Override
	public void actionPerformed(ActionEvent e) {
        
        new MenuView();
        this.setVisible(false);
		
	}

    public static void main(String[] args) {
        
    }

}
