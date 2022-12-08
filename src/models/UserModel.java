// PROGRAM user model
// {Program ini diigunakan untuk menangani data dari user dalam verivikasi autentikasi pengguna aplikasi}

// PACKAGE
package models;

// KELAS
public class UserModel extends KelasModel{
    
    // ATRIBUTE
    public String[][] database;
    
    // CONSTRUCTUR
    public UserModel () {
        
        // Connect to sql server
        sqlCon();

        // Set database as array
        String[] isiData = {"email", "pass", "nama", "alamat"};
        database = sqlGetAll("akun", isiData);
        
    }

}
