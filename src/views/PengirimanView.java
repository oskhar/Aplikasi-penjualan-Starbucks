package views;

import javax.swing.*;

import models.KelasModel;

import java.awt.*;
import java.awt.event.*;


public class PengirimanView extends KelasView implements ActionListener {

    // ATRIBUTE
    JLabel text;
    JButton back;
    KelasModel model = new KelasModel();

    // CONSTRUCTOR
    public PengirimanView (String nama, String alamat, String hargaTot) {
        
        // Set container
        setContainer(450, 570);

        // Painting
        String data = "<html><font color='#28a745'>Pembelian berhasil!</font><br><br><font color='#1f2130'>Nama: " + nama + 
                                                                                                      "<br>Alamat pengiriman: " + alamat + 
                                                                                                      "<br><br><center><b>PESANAN</b></center></font><br><br><br><p align='right' color='#1f2130' width='400'>total:<br>" + hargaTot + "</p></html>";
        text = new JLabel(data);
        text.setForeground(new Color(40, 167, 69));
        text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        text.setBounds(20, 20, 410, 530);
        text.setVerticalAlignment(JLabel.TOP);
        add(text);

        back = new JButton("back");
        layoutTombol(back, 20, 490, 160, 30, hitam, putih, 16);
        back.addActionListener(this);
        add(back);

        // Painting
        addBackground(model.locPathImg + "latar.jpg");
        setVisible(true);

    }

    public static void main(String[] args) {
        new PengirimanView("oskhar", "jakarta", "100.000");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        
        new MenuView();
        this.setVisible(false);
		
	}

}
