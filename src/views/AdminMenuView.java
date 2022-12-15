package views;

import models.KelasModel;
import javax.swing.*;
import java.awt.event.*;

// KELAS
public class AdminMenuView extends KelasView implements ActionListener {

    // ATRIBUTE
    KelasModel model = new KelasModel();
    JButton pengaturanUser;
    JButton riwayatPenjualan;
    JButton minumanTersedia;

    // CONSTRUCTOR
    AdminMenuView () {

        // Configurasi
        model.sqlCon();

        // Set container
        setContainer(1000, 570);

        // Painting
        pengaturanUser = new JButton("Mengatur User");
        pengaturanUser.addActionListener(this);
        layoutTombol(pengaturanUser, 350, 100, 300, 40, hitam, putih, 16);
        add(pengaturanUser);

        minumanTersedia = new JButton("Mengatur Minuman");
        minumanTersedia.addActionListener(this);
        layoutTombol(minumanTersedia, 350, 160, 300, 40, hitam, putih, 16);
        add(minumanTersedia);

        riwayatPenjualan = new JButton("Riwayat Penjualan");
        riwayatPenjualan.addActionListener(this);
        layoutTombol(riwayatPenjualan, 350, 220, 300, 40, hitam, putih, 16);
        add(riwayatPenjualan);

        addBackground(model.locPathImg+"latar.jpg");
        setVisible(true);

    }

    // METHOD main
    public static void main(String[] args) {
        new AdminMenuView();    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
