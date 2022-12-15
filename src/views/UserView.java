// PROGRAM user view
// {Menampilkan halaman login}

// PACKAGE
package views;

// PUSTAKA
import javax.swing.*;
import controllers.UserController;
import java.awt.*;
import java.awt.event.*;

// KELAS
public class UserView extends JFrame implements ActionListener, KeyListener{

    // ATRIBUTE
    UserController control = new UserController();
    JLabel latar1;
    JLabel latar2;
    JLabel latar3;
    JLabel latar4;
    JLabel notifArea;

    JPanel boxLogin;
    JLabel judulLogin;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;

    JTextField username;
    JTextField password;
    JTextField passwordUlang;
    JTextField nama;
    JTextField alamat;

    JButton submitLogin;
    JButton submitTambah;
    JButton submitChPass;
    JButton submitAdmin;
    JButton bukaLogin;
    JButton bukaTambahAkun;
    JButton bukaEditPassword;
    JButton back;
    JButton halamanAdmin;

    int width;
    int height;
    String img;

    Color merah = new Color(220, 53, 69);
    Color hijau = new Color(40, 167, 69);
    Color hitam = new Color(31, 33, 48);
    Color putih = new Color(255, 250, 248);
    
    // CONSTRUCTOR
    public UserView () {

        // Set atribute
        this.img = control.model.locPathImg + "latar2.jpg";
        this.width = control.model.width;
        this.height = control.model.height;

        // Set container
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Painting latar1
        tambahLatar1();

        // Frame visible on
        setVisible(true);
        
        // Check cookie
        config();

    }

    // METHOD
    public void tambahLatar1 () {

        // Set background img
        latar1 = new JLabel(new ImageIcon(img));
        latar1.setLayout(null);
        latar1.setBounds( 0, 0, width, height);
        this.add(latar1);

        // Set Judul
        judulLogin = new JLabel("Login pembelian Starbucks");
        judulLogin.setBounds(0, 40, width, 50);
        judulLogin.setFont(new Font("Arial", Font.BOLD, 24));
        judulLogin.setForeground(hitam);
        judulLogin.setHorizontalAlignment(JLabel.CENTER);
        latar1.add(judulLogin);

        // Set logo
        JLabel logo = new JLabel(new ImageIcon(control.model.locPathImg+"logoStarbucks.png"));
        logo.setBounds(30, 360, 150, 150);
        latar1.add(logo);

        // Set button
        bukaTambahAkun = new JButton("Buat Akun");
        layoutBack(bukaTambahAkun, 860, 505, 120, 25);
        latar1.add(bukaTambahAkun);

        // Set button
        bukaEditPassword = new JButton("Ubah Sandi");
        layoutBack(bukaEditPassword, 860, 475, 120, 25);
        latar1.add(bukaEditPassword);
        
        // Set button
        halamanAdmin = new JButton("Login Admin");
        layoutBack(halamanAdmin, 860, 445, 120, 25);
        latar1.add(halamanAdmin);

        // Set box input
        boxLogin = new JPanel();
        boxLogin.setBounds(300, 135, 400, 300);
        boxLogin.setLayout(null);
        boxLogin.setBackground(putih);
        latar1.add(boxLogin);
        
        // Set label input
        label1 = new JLabel("Email");
        label1.setBounds( 100, 48, 200, 12);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        label1.setForeground(hitam);
        boxLogin.add(label1);

        // Set input component
        username = new JTextField();
        username.setBounds(100, 60, 200, 40);
        username.addKeyListener(this);
        boxLogin.add(username);

        // Set label input
        label2 = new JLabel("Password");
        label2.setBounds( 100, 118, 200, 12);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        label2.setForeground(hitam);
        boxLogin.add(label2);

        // Set input component
        password = new JTextField();
        password.setBounds(100, 130, 200, 40);
        password.addKeyListener(this);
        boxLogin.add(password);
        
        // Set button submitLogin
        submitLogin = new JButton("Login");
        layoutBack(submitLogin, 100, 200, 200, 40);
        submitLogin.addActionListener( this );
        boxLogin.add(submitLogin);
        
        // Set notif
        notifArea = new JLabel("");
        notifArea.setBounds(100, 10, 980, 20);
        notifArea.setForeground(new Color(220, 53, 69));
        notifArea.setFont(new Font("Arial", Font.BOLD, 18));
        notifArea.setBorder(null);
        latar1.add(notifArea);

    }
    
    // METHOD
    public void tambahLatar2 () {

        // Set background img
        latar2 = new JLabel(new ImageIcon(img));
        latar2.setLayout(null);
        latar2.setBounds( 0, 0, width, height);
        this.add(latar2);
        
        // Set label input
        label1 = new JLabel("Email");
        label1.setBounds( 200, 48, 600, 12);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        latar2.add(label1);

        // Set input component
        username = new JTextField();
        username.setBounds(200, 60, 600, 40);
        latar2.add(username);

        // Set label input
        label2 = new JLabel("Password");
        label2.setBounds( 200, 118, 600, 12);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        latar2.add(label2);

        // Set input component
        password = new JTextField();
        password.setBounds(200, 130, 600, 40);
        latar2.add(password);

        // Set label input
        label3 = new JLabel("Ulangi Password");
        label3.setBounds( 200, 188, 600, 12);
        label3.setFont(new Font("Arial", Font.BOLD, 12));
        latar2.add(label3);

        // Set input component
        passwordUlang = new JTextField();
        passwordUlang.setBounds(200, 200, 600, 40);
        latar2.add(passwordUlang);
        
        // Set label input
        label4 = new JLabel("Nama Lengkap");
        label4.setBounds( 200, 258, 600, 12);
        label4.setFont(new Font("Arial", Font.BOLD, 12));
        latar2.add(label4);

        // Set input component
        nama = new JTextField();
        nama.setBounds(200, 270, 600, 40);
        latar2.add(nama);
        
        // Set label input
        label5 = new JLabel("Alamat");
        label5.setBounds( 200, 328, 600, 12);
        label5.setFont(new Font("Arial", Font.BOLD, 12));
        latar2.add(label5);

        // Set input component
        alamat = new JTextField();
        alamat.setBounds(200, 340, 600, 40);
        latar2.add(alamat);
        
        // Set button submitLogin
        submitTambah = new JButton("Buat Akun");
        layoutBack(submitTambah, 200, 410, 200, 40);
        submitTambah.addActionListener( this );
        latar2.add(submitTambah);

        // Set button back
        back = new JButton("Back");
        layoutBack(back, 880, 500, 100, 25);
        back.addActionListener(this);
        latar2.add(back);
        
        // Set notif
        notifArea = new JLabel("");
        notifArea.setBounds(100, 10, 980, 20);
        notifArea.setForeground(new Color(220, 53, 69));
        notifArea.setFont(new Font("Arial", Font.BOLD, 18));
        notifArea.setBorder(null);
        latar2.add(notifArea);

    }
    
    // METHOD
    public void tambahLatar3 () {

        // Set background img
        latar3 = new JLabel(new ImageIcon(img));
        latar3.setLayout(null);
        latar3.setBounds( 0, 0, width, height);
        this.add(latar3);
        
        // Set label input
        label1 = new JLabel("Email");
        label1.setBounds( 200, 48, 600, 12);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        latar3.add(label1);

        // Set input component
        username = new JTextField();
        username.setBounds(200, 60, 600, 40);
        latar3.add(username);

        // Set label input
        label2 = new JLabel("Password Baru");
        label2.setBounds( 200, 118, 600, 12);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        latar3.add(label2);

        // Set input component
        password = new JTextField();
        password.setBounds(200, 130, 600, 40);
        latar3.add(password);

        // Set label input
        label3 = new JLabel("Ulangi Password");
        label3.setBounds( 200, 188, 600, 12);
        label3.setFont(new Font("Arial", Font.BOLD, 12));
        latar3.add(label3);

        // Set input component
        passwordUlang = new JTextField();
        passwordUlang.setBounds(200, 200, 600, 40);
        latar3.add(passwordUlang);
        
        // Set button submitLogin
        submitChPass = new JButton("Ubah Sandi");
        layoutBack(submitChPass, 200, 270, 200, 40);
        submitChPass.addActionListener( this );
        latar3.add(submitChPass);

        // Set button back
        back = new JButton("Back");
        layoutBack(back, 870, 500, 110, 30);
        back.addActionListener(this);
        latar3.add(back);
        
        // Set notif
        notifArea = new JLabel("");
        notifArea.setBounds(10020, 20, 980, 20);
        notifArea.setFont(new Font("Arial", Font.BOLD, 18));
        notifArea.setBorder(null);
        latar3.add(notifArea);

    }

    // METHOD
    public void tambahLatar4 () {

        // Set background img
        latar4 = new JLabel(new ImageIcon(img));
        latar4.setLayout(null);
        latar4.setBounds( 0, 0, width, height);
        this.add(latar4);
        
        // Set label input
        label1 = new JLabel("Password admin");
        label1.setBounds( 200, 174, 600, 12);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        latar4.add(label1);

        // Set input component
        password = new JTextField();
        password.setBounds(200, 188, 600, 40);
        latar4.add(password);
        
        // Set button submitLogin
        submitAdmin = new JButton("Login halaman Admin");
        layoutBack(submitAdmin, 200, 270, 200, 40);
        submitAdmin.addActionListener( this );
        latar4.add(submitAdmin);

        // Set button back
        back = new JButton("Back");
        layoutBack(back, 870, 500, 110, 30);
        back.addActionListener(this);
        latar4.add(back);
        
        // Set notif
        notifArea = new JLabel("");
        notifArea.setBounds(10020, 20, 980, 20);
        notifArea.setFont(new Font("Arial", Font.BOLD, 18));
        notifArea.setBorder(null);
        latar4.add(notifArea);

    }

    // METHOD
    public void config () {

        if (control.checkCookie("user"))
            if (control.verUser(control.getCookie("user"), control.getCookie("pass"))) {
                new MenuView();
                this.setVisible(false);

            } else {
                notifArea.setText("Password atau Email salah!");

            }
    }

    // METHOD
    public void layoutBack (JButton el, int x, int y, int wi, int he) {
        el.setBounds(x, y, wi, he);
        el.addActionListener(this);
        el.setBorder(null);
        el.setFocusable(false);
        el.setBackground(new Color(31, 33, 48));
        el.setForeground(Color.white);
    }

    // METHOD main
    public static void main (String[] s) {
        new UserView();
    }

    // EVENT HANDLER
    @Override
    public void actionPerformed (ActionEvent e) {

        // Object
        Object source = e.getSource();

        // Check button
        if (source == submitLogin) {
            if (control.verAkun(notifArea, username.getText(), password.getText())) {
                new MenuView();
                this.setVisible(false);
            }

        } else if (source == submitTambah) {

            // Query sql insert
            if (!(username.getText().equals("")) && !(nama.getText().equals("")) && !(alamat.getText().equals(""))){
                switch (control.addUser(username.getText(), password.getText(), passwordUlang.getText(), nama.getText(), alamat.getText())) {

                    case "true":
                        notifArea.setText("Akun berhasil ditambahkan");
                        username.setText("");
                        password.setText("");
                        passwordUlang.setText("");
                        nama.setText("");
                        alamat.setText("");
                        break;

                    case "email":
                        notifArea.setText("Email sudah digunakan!");
                        break;

                    case "ppass":
                        notifArea.setText("Password harus lebih dari 6 karakter!");
                        break;
                        
                    case "epass":
                        notifArea.setText("Password tidak sama dengan ulangi password!");
                        break;

                    default:
                        notifArea.setText("Data invalid!");

                }
            } else {
                notifArea.setText("Data invalid!");

            }

        } else if (source == submitChPass) {

            if (!(username.getText().equals(""))) {
                // Query sql update
                switch (control.changePass(username.getText(), password.getText(), passwordUlang.getText())) {

                    case "true":
                        notifArea.setText("Password berhasil diubah");
                        username.setText("");
                        password.setText("");
                        passwordUlang.setText("");
                        break;

                    case "email":
                        notifArea.setText("Email sudah digunakan!");
                        break;

                    case "ppass":
                        notifArea.setText("Password harus lebih dari 6 karakter!");
                        break;
                        
                    case "epass":
                        notifArea.setText("Password tidak sama dengan ulangi password!");
                        break;

                    default:
                        notifArea.setText("Data invalid!");

                }
            } else {
                notifArea.setText("Data invalid!");

            }

        } else if (source == submitAdmin) {
            if (password.getText().equals("rootAdmin")) {
                new AdminMenuView();
            } else {
                notifArea.setText("Password salah!");
            }
        
        } else if (source == bukaTambahAkun) {

            // Change latar
            this.getContentPane().removeAll();
            this.repaint();
            tambahLatar2();

        } else if (source == bukaEditPassword) {

            // Change latar
            this.getContentPane().removeAll();
            this.repaint();
            tambahLatar3();

        } else if (source == halamanAdmin) {

            // Change latar
            this.getContentPane().removeAll();
            this.repaint();
            tambahLatar4();

        } else if (source == back) {

            // Change latar
            this.getContentPane().removeAll();
            this.repaint();
            tambahLatar1();

        }
            
    }

    // EVENT HANDLER
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            if (control.verAkun(notifArea, username.getText(), password.getText())) {
                new MenuView();
                this.setVisible(false);
            }
            
        }
    
    }

    // EVENT HANDLER
    @Override
    public void keyTyped(KeyEvent e) {}

    // EVENT HANDLER
    @Override
    public void keyReleased(KeyEvent e) {}

}
