package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class FakeData {

    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream("cookie.properties");
            FileInputStream in = new FileInputStream("cookie.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            props.setProperty("pass", "oskhar");
            props.store(out, null);
            out.close();
        } catch (Exception ex) {System.out.println(ex);}
    }

}
