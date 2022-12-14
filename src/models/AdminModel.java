package models;

public class AdminModel extends KelasModel {
    
    // ATRIBUTE
    String[][] databaseAkun;
    String[][] databaseMinuman;
    String[][] databaseRiwayat;
    String[] isiData;

    public AdminModel () {
    
        // Connect to sql server
        sqlCon();

        // Set database as array
        isiData = new String[4];
        isiData[0] = "email";
        isiData[1] = "pass";
        isiData[2] = "nama";
        isiData[3] = "alamat";
        databaseAkun = sqlGetAll("akun", isiData);

        // Set database as array
        isiData = new String[3];
        isiData[0] = "nama";
        isiData[1] = "alamat";
        isiData[2] = "hargaTot";
        databaseRiwayat = sqlGetAll("riwayat", isiData);

        // Set database as array
        isiData = new String[4];
        isiData[0] = "img";
        isiData[1] = "name";
        isiData[2] = "rate";
        isiData[3] = "harga";
        databaseMinuman = sqlGetAll("minuman", isiData);
    
    }

}
