package laundryfix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection mysqlconfig;

    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/db_laundryfix"; // URL database
            String user = "root"; // User database
            String pass = ""; // Password database
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("Koneksi gagal: " + e.getMessage()); // Menampilkan pesan kesalahan pada koneksi
        }
        return mysqlconfig;
    }

    public static void closeConnection() {
        try {
            if (mysqlconfig != null && !mysqlconfig.isClosed()) {
                mysqlconfig.close(); // Menutup koneksi jika tidak null dan belum ditutup
            }
        } catch (SQLException e) {
            System.err.println("Tutup koneksi gagal: " + e.getMessage()); // Menampilkan pesan kesalahan saat menutup koneksi
        }
    }
}
