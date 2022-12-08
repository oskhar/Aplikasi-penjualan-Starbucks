package models;

public class MenuModel extends KelasModel{
    
    // ATRIBUTE
    public String[][] database;
    
    // CONSTRUCTUR
    public MenuModel () {
        
        // Connect to sql server
        sqlCon();

        // Set database as array
        String[] isiData = {"img", "name", "rate", "harga"};
        database = sqlGetAll("minuman", isiData);
        
    }

    public static void main(String[] args) {
        new MenuModel();
    }
    
}
