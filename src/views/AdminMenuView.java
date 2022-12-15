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
        pengaturanUser = new JButton("Lihat tabel User");
        pengaturanUser.addActionListener(this);
        layoutTombol(pengaturanUser, 350, 150, 300, 40, hitam, putih, 16);
        add(pengaturanUser);

        minumanTersedia = new JButton("Lihat tabel Minuman");
        minumanTersedia.addActionListener(this);
        layoutTombol(minumanTersedia, 350, 210, 300, 40, hitam, putih, 16);
        add(minumanTersedia);

        riwayatPenjualan = new JButton("Riwayat Penjualan");
        riwayatPenjualan.addActionListener(this);
        layoutTombol(riwayatPenjualan, 350, 270, 300, 40, hitam, putih, 16);
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
        Object source = e.getSource();

        // Check botton
        if (source == pengaturanUser) {
            new AdminAkunView();
            setVisible(false);

        } else if (source == minumanTersedia) {
            new AdminAkunView();
            setVisible(false);
            
        }
        
    }

}
