package com.app.keyalive.pasarungaran.apihelper;

/**
 * Created by ikitas27 on 1/31/2018.
 */

public class konfigurasi {

    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.1.5/Android/data%20pasar/koneksi.php";
    public static final String URL_GET_ALL = "http://192.168.1.5/Android/data%20pasar/tampilsemuadata.php";
    public static final String URL_GET_EMP = "http://192.168.1.5/Android/data%20pasar/tampildata.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.5/Android/data%20pasar/updatedata.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.5/Android/data%20pasar/hapusdata.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "name";
    public static final String KEY_EMP_POSISI = "pas"; //desg itu variabel untuk posisi
    public static final String KEY_EMP_GAJIH = "almt"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_POSISI = "pas";
    public static final String TAG_GAJIH = "almt";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
