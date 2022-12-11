package views;

import javax.swing.*;
import java.awt.*;

public class KelasView extends JFrame {

    // ATRIBUTE
    JLabel background;
    
    // METHOD
    public void setContainer (int wi, int he) {
    
        setSize( wi, he);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    
    }

    // METHOD
    public void addBackground (String path) {

        setLayout(new BorderLayout());
        background = new JLabel(new ImageIcon(path));
        background.setLayout(new FlowLayout());
        add(background);
        
    }

}
