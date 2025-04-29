/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fdn-user
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/reservation_hotel";
    private static final String USER = "root";
    private static final String PASS = "root"; 
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
    public static boolean testConnection() {
    try (Connection conn = getConnection()) {
        System.out.println("Koneksi berhasil!");
        return true;
    } catch (SQLException ex) {
        System.err.println("Koneksi gagal: " + ex.getMessage());
        return false;
    }
}

}
