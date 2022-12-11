package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PengirimanView extends JFrame implements ActionListener {

    // ATRIBUTE
    JLabel text;
    JButton back;

    // CONSTRUCTOR
    public PengirimanView (String nama, String alamat, String hargaTot) {
        
        // Set container
        setSize(450, 570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Painting
        String data = "<html>Pembelian minuman seharga "+ hargaTot +" telah berhasil dilakukan atas nama \""+ nama +"<br><br>Minuman akan dikirim ke alamat berikut: "+ alamat +"</html>";
        text = new JLabel(data);
        text.setForeground(new Color(40, 167, 69));
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setBounds(20, 20, 410, 530);
        add(text);

        back = new JButton("<< back");
        back.setBackground(Color.white);
        back.setBounds(20, 20, 200, 30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);

        // Show
        setVisible(true);

    }

	@Override
	public void actionPerformed(ActionEvent e) {
        
        new MenuView();
        this.setVisible(false);
		
	}

}
