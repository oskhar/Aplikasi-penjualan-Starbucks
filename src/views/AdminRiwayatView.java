package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.AdminController;

public class AdminRiwayatView extends KelasView implements ActionListener {

    // ATRIBUTE
    AdminController control = new AdminController();
    DefaultTableModel model;
    JScrollPane sp;
    JTable table;
    JButton back;
    JButton clear;
    JLabel total;
    
    int width = control.model.width;
    int height = control.model.height;
    String pathImg = control.model.locPathImg;
    
    // CONTAINER
    public AdminRiwayatView() {

        // Set container
        setContainer(width, height);

        // Painting
        painting(control.model.databaseRiwayat);
        setVisible(true);

    }

    // METHOD
    public void painting (String[][] dataBS) {

        // Variable
        String[] judul = {"Nama", "Alamat", "Harga Total"};

        // Set panel
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 900, 470);
        panel.setBackground(new Color(0, 0, 0, 0));;
        panel.setOpaque(false);
        add(panel);

        // Set table
        model = new DefaultTableModel(dataBS, judul);
        table = new JTable(model);
        table.setBounds(0, 0, 900, 470);
        sp = new JScrollPane(table);
        panel.add(sp);

        // Set label
        total = new JLabel("<html><b>total:</b> Rp "+manipHarga(control.sumHarga(dataBS))+".-</html>");
        total.setBounds(30, 100, 300, 40);
        total.setFont(new Font("Arial", Font.PLAIN, 16));
        total.setHorizontalAlignment(JLabel.LEFT);
        add(total);

        // Set button
        clear = new JButton("Clear");
        clear.addActionListener(this);
        layoutTombol(clear, 30, 140, 100, 25, merah, putih, 15);
        add(clear);

        // Set button
        back = new JButton("Back");
        back.addActionListener(this);
        layoutTombol(back, 880, 500, 100, 25, hitam, putih, 15);
        add(back);

        // Painting
        addBackground(pathImg + "latar.jpg");
    }

    public static void main(String[] args) {
        new AdminRiwayatView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Object
        Object source = e.getSource();

        // Check button
        if(source == clear) {

            String[][] fakeData = {};
            control.model.sqlDeleteAll("riwayat");
            this.getContentPane().removeAll();
            this.repaint();
            painting(fakeData);

        } else if(source == back) {

            new AdminMenuView();
            setVisible(false);

        }

    }

}
