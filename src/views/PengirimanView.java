package views;

import javax.swing.*;
import java.awt.*;

public class PengirimanView extends JFrame{

    // ATRIBUTE
    JLabel text;

    // CONSTRUCTOR
    public PengirimanView (String nama, String alamat, String hargaTot) {
        
        // Set container
        setSize(450, 570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painting
        String data = "<html>Pembelian minuman seharga "+ hargaTot +" telah berhasil dilakukan atas nama \""+ nama +"<br><br>Minuman akan dikirim ke alamat berikut: "+ alamat +"</html>";
        text = new JLabel(data);
        text.setForeground(new Color(40, 167, 69));
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setBounds(20, 20, 410, 530);
        add(text);

        // Show
        setVisible(true);

    }

}
