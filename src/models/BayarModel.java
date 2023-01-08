// PACKAGE
package models;

// KELAS
public class BayarModel extends KelasModel{
    
    // ATRIBUTE
    public String[][] database;
    
    // CONSTRUCTUR
    public BayarModel () {
        
        // Konek dengan sql server
        sqlCon();

        // Mengambil database sebagai array 2 dimensi
        String[] isiData = {"img", "name", "rate", "harga"};
        database = sqlGetAll("minuman", isiData);
        
    }
    
}
