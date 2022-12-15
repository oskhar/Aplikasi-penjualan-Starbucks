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
    JButton logout;

    // CONSTRUCTOR
    AdminMenuView () {

        // Configurasi
        model.sqlCon();

        // Set container
        setContainer(1000, 570);

        // Set button
        pengaturanUser = new JButton("Lihat tabel User");
        pengaturanUser.addActionListener(this);
        layoutTombol(pengaturanUser, 350, 150, 300, 40, hitam, putih, 16);
        add(pengaturanUser);

        // Set button
        minumanTersedia = new JButton("Lihat tabel Minuman");
        minumanTersedia.addActionListener(this);
        layoutTombol(minumanTersedia, 350, 210, 300, 40, hitam, putih, 16);
        add(minumanTersedia);

        // Set button
        riwayatPenjualan = new JButton("Riwayat Penjualan");
        riwayatPenjualan.addActionListener(this);
        layoutTombol(riwayatPenjualan, 350, 270, 300, 40, hitam, putih, 16);
        add(riwayatPenjualan);

        // Set button
        logout = new JButton("Logout");
        logout.addActionListener(this);
        layoutTombol(logout, 880, 500, 100, 25, hitam, putih, 15);
        add(logout);

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
            new AdminMinumanView();
            setVisible(false);
            
        } else if (source == riwayatPenjualan) {
            new AdminRiwayatView();
            setVisible(false);
            
        } else if (source == logout) {
            new UserView();
            setVisible(false);
            
        }
        
    }

}
