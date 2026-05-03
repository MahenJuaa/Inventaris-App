package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDB {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_inventaris",
                    "root",
                    ""
                );
                System.out.println("Koneksi berhasil");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}