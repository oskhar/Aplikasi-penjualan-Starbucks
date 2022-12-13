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

    // METHOD
    public String sum(int[] listHarga) {
        int hasil = 0;
        for (int i = 0; i < listHarga.length; i++) {
            hasil += listHarga[i];
        }

        return hasil+"";
    }

    // METHOD
    public void bayar (String nama, String alamat, String hargaTot) {

        String query = "0,'"+ nama +"','"+ alamat +"','"+ hargaTot +"'";
        model.sqlInsert("riwayat", query);
    }

    // METHOD
    public String[][] getProduk () {
        
        int i, j = 0, pen = 0;
        for (i = 0; i < data.length; i++) {
            if (data[i][0].equals("0")) {
                pen++;
            }
        }
        String[][] hasil = new String[data.length-pen][3];

        for (i = 0; i < data.length; i++) {
            if (!(data[i][0].equals("0"))) {
                hasil[j][0] = model.database[Integer.parseInt(data[i][0])][1];
                hasil[j][1] = data[i][1];
                hasil[j][2] = (Integer.parseInt(model.database[Integer.parseInt(data[i][0])][3]) * Integer.parseInt(data[i][1]))+"";
                j++;
            }
        }

        return hasil;
    }

}
