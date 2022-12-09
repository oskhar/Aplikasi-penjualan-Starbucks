// PROGRAM user view
// {Menampilkan halaman login}

// PACKAGE
package views;

// PUSTAKA
import javax.swing.*;
import controllers.UserController;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;

// KELAS
public class UserView extends JFrame implements ActionListener{

    // ATRIBUTE
    UserController control = new UserController();
    String cookie = control.model.cookie;
    Properties prop = new Properties();
    FileInputStream in;
    JLabel latar1;
    JLabel latar2;
    JLabel latar3;
    JLabel notifArea;

    JPanel boxLogin;
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
    JButton bukaLogin;
    JButton bukaTambahAkun;
    JButton bukaEditPassword;
    JButton back;

    int width;
    int height;
    String img;
    
    // CONSTRUCTOR
    public UserView () {

        // Set atribute
        this.img = control.model.locPathImg + "latar.jpg";
        this.width = control.model.width;
        this.height = control.model.height;

        // Set container
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        // Set button
        bukaTambahAkun = new JButton("Buat Akun");
        bukaTambahAkun.setBounds(860, 510, 120, 20);
        bukaTambahAkun.addActionListener(this);
        bukaTambahAkun.setBackground(Color.white);
        bukaTambahAkun.setBorder(null);
        latar1.add(bukaTambahAkun);

        // Set button
        bukaEditPassword = new JButton("Ubah Sandi");
        bukaEditPassword.setBounds(860, 485, 120, 20);
        bukaEditPassword.addActionListener(this);
        bukaEditPassword.setBackground(Color.white);
        bukaEditPassword.setBorder(null);
        latar1.add(bukaEditPassword);

        // Set box input
        boxLogin = new JPanel();
        boxLogin.setBounds(300, 135, 400, 300);
        boxLogin.setLayout(null);
        boxLogin.setBackground(Color.white);
        latar1.add(boxLogin);
        
        // Set label input
        label1 = new JLabel("Email");
        label1.setBounds( 100, 48, 200, 12);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        boxLogin.add(label1);

        // Set input component
        username = new JTextField();
        username.setBounds(100, 60, 200, 40);
        boxLogin.add(username);

        // Set label input
        label2 = new JLabel("Password");
        label2.setBounds( 100, 118, 200, 12);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        boxLogin.add(label2);

        // Set input component
        password = new JTextField();
        password.setBounds(100, 130, 200, 40);
        boxLogin.add(password);
        
        // Set button submitLogin
        submitLogin = new JButton("Login");
        submitLogin.setBounds(100, 200, 200, 40);
        submitLogin.addActionListener( this );
        boxLogin.add(submitLogin);
        
        // Set notif
        notifArea = new JLabel("");
        notifArea.setBounds(400, 20, 200, 20);
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
        submitTambah = new JButton("submit");
        submitTambah.setBounds(200, 410, 200, 40);
        submitTambah.addActionListener( this );
        latar2.add(submitTambah);

        // Set button back
        back = new JButton("<< Back");
        back.addActionListener(this);
        back.setBounds(890,510, 90, 20);
        back.setBackground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 12));
        latar2.add(back);
        
        // Set notif
        notifArea = new JLabel("");
        notifArea.setBounds(400, 20, 200, 20);
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
        submitChPass = new JButton("submit");
        submitChPass.setBounds(200, 270, 200, 40);
        submitChPass.addActionListener( this );
        latar3.add(submitChPass);

        // Set button back
        back = new JButton("<< Back");
        back.addActionListener(this);
        back.setBounds(890,510, 90, 20);
        back.setBackground(Color.white);
        back.setFont(new Font("Arial", Font.BOLD, 12));
        latar3.add(back);
        
        // Set notif
        notifArea = new JLabel("");
        notifArea.setBounds(200, 20, 400, 20);
        notifArea.setFont(new Font("Arial", Font.BOLD, 18));
        notifArea.setBorder(null);
        latar3.add(notifArea);

    }

    // METHOD
    public void config () {

        if (control.checkCookie("user"))
            verAkun(notifArea, prop.getProperty("user"), prop.getProperty("pass"));

    }

    @Override

    // METHOD
    public void actionPerformed (ActionEvent e) {

        // Object
        Object source = e.getSource();

        // Check button
        if (source == submitLogin) {
            verAkun(username.getText(), password.getText());

        } else if (source == submitTambah) {

            // Query sql insert
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

        } else if (source == submitChPass) {

            // Query sql update
            switch (control.changePass(username.getText(), password.getText(), passwordUlang.getText())) {

                case "true":
                    notifArea.setText("Akun berhasil ditambahkan");
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

        } else if (source == back) {

            // Change latar
            this.getContentPane().removeAll();
            this.repaint();
            tambahLatar1();

        }
            
    }

    // METHOD main
    public static void main (String[] s) {
        new UserView();
    }

}
