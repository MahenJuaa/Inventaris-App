package main;

import config.KoneksiDB;
import java.sql.Connection;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("TEST MASUK MAIN");

        Connection conn = KoneksiDB.getConnection();

        if (conn != null) {
            System.out.println("✅ Koneksi ke database BERHASIL");
        } else {
            System.out.println("❌ Koneksi ke database GAGAL");
        }
    }
}