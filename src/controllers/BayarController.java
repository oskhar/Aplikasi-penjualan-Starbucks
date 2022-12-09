package controllers;

import models.BayarModel;

public class BayarController extends KelasController {
    
    // ATRIBUTE
    public BayarModel model = new BayarModel();
    public String[][] data;

    // CONSTRUCTOR
    public BayarController (String[][] data) {

        // Set data
        cookie = model.cookie;
        this.data = new String[data.length][2];
        for (int i = 0; i < data.length; i++) {
            this.data[i][0] = data[i][0];
            this.data[i][1] = data[i][1];
        }

    }

    public String totalHarga (int index, int jumlah) {
        
        // Variable
        String hasil = "";

        // Set value
        hasil += (Integer.parseInt(model.database[index][3]) * jumlah);
        return hasil;

    }

    // METHOD
    public void setData (int index, String s1) {

        // Variable
        String[] temp = new String[data.length];
        String hasil;
        int i, n = data.length;

        // Set data
        data[index][1] = s1;
        for (i = 0; i < n; i++) {
            temp[i] = String.join("=", data[i]);
        }

        hasil = String.join(",", temp);
        setCookie("beli", hasil);

    }

    public String sum(int[] listHarga) {
        int hasil = 0;
        for (int i = 0; i < listHarga.length; i++) {
            hasil += listHarga[i];
        }

        return hasil+"";
    }

    public void bayar (String nama, String alamat, String hargaTot) {

        String query = "nama='"+ nama +"',alamat='"+ alamat +"',hargaTot='"+ hargaTot +"'";
        model.sqlInsert("riwayat", query);
    }

}
