# DOKUMENTASI SISTEM

## Pendahuluan

Pada program aplikasi ini kami mencoba untuk menerapkan metode pemrograman MVC yang membagi keseluruhan program menjadi 3 komponen yaitu model, view, dan controller guna mempermudah pemeliharaan serta pengembangan aplikasi.

## Konsep Pembuatan

Pembahasan akan dimulai dari pengorganisaian file. Di dalam folder src ada folder config untuk mengkonfigurasi system dengan sangat fleksibel tanpa harus merubah keseluruhan program, ini akan sangat mempermudah pengembangan jangka panjang.

> Bahkan saat ingin mengganti jenis database maupun mengganti tema warna itu sangat mungkin untuk dilakukan
> Selain itu lokasi folder pada project tidak selalu berada di posisi yang serupa, bahkan penanda folder linux dengan folder windows sangat jauh berbeda, mengingat saya dengan kawan kawan pengembang tidak menggunakan Oprating System yanng sama

Lalu ada folder models, views, dan controllers yang masing masing menampung bagian bagian tertentu tanpa bercampur satu sama lain. Sehingga memudahkan perbaikan bug dan hanya perlu membuka folder yang diperlukan saat error terjadi. Yang lebih penting lagi setiap folder memiliki kelas parent masing masing contohnya pada Folder models yang memiliki kelas parent berupa "KelasModel.java", yang dimana program ini berisi semua konfigurasi terhadap database serta method method yang diperlukan untuk mengatur isi data pada database.

'''java
public void sqlCon () {

        // Variable
        config();
        locPathImg = prop.getProperty("pathImg");
        cookie = prop.getProperty("cookie");
        width = Integer.parseInt(prop.getProperty("width"));
        height = Integer.parseInt(prop.getProperty("height"));
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String pass = prop.getProperty("pass");
        String driver = prop.getProperty("driver");
        
        // Connect to mysql
        try {
            Class.forName(driver);
            con = DriverManager.getConnection( url, user, pass);
            stmt = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Data tidak dapat diakses!");
            System.out.println("Error = " + ex);

        }

    }

    // METHOD config
    public void config () {

        // Access data from java.properties
        try {
            prop = new Properties();
            File file = new File("src/config/java.properties");
            String path = file.getCanonicalPath();
            prop.load(new FileInputStream(path));

        } catch (Exception ex) {
            System.out.println("Configurasi gagal!");
            System.out.println("Error = " + ex);

        }

    }

    // METHOD update data
    public void sqlUpdate (String table, String data, String lokasi) {

        // Execute query sql
        try {
            sql = "UPDATE " + table + " SET " + data + " WHERE " + lokasi;
            stmt.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println("Error =" + ex);

        }

    }

    // METHOD 
    public String[][] sqlGetAll (String table, String[] index) {

        // Variable
        String[][] data = new String[getCount(table)][index.length];
        int i = 0;

        // Execure query sql
        try{
            sql = "SELECT * FROM " + table;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                for (int j = 0; j < index.length; j++) {
                    data[i][j] = rs.getString(index[j]);
                }
                i++;
            }
            return data;

        } catch (Exception ex) {
            System.out.println("Gagal mendapatkan semua data dari table '" + table + "'");
            System.out.println("Error =" + ex);
            return data;

        }

    }

    // METHOD
    public int getCount (String table) {

        // Execute query sql
        try {
            String strSql = "SELECT count(*) FROM " + table;
            ResultSet fakeRs = stmt.executeQuery(strSql);
            fakeRs.next();
            return fakeRs.getInt(1);

        } catch (Exception ex) {
            System.out.println("Gagal mendapatkan count dari table '" + table + "'");
            System.out.println("Error =" + ex);
            return 0;

        }
    }

    // METHOD
    public void sqlInsert (String table, String data) {

        // Execute query sql
        try {
            sql = "INSERT INTO " + table + " VALUES (" + data +")";
            stmt.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println("Error =" + ex);

        }

    }

    // METHOD
    public void sqlDeleteAll (String table) {

        // Execute query sql
        try {
            sql = "DELETE FROM " + table;
            stmt.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println("Error =" + ex);

        }

    }
'''