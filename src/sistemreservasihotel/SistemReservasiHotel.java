/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemreservasihotel;

import sistemreservasihotel.helper.DatabaseConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author fdn-user
 */
public class SistemReservasiHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       if (!DatabaseConnection.testConnection()) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal. Tutup aplikasi.");
            System.exit(0);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
    
}
