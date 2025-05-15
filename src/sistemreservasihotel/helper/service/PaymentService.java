/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.helper.service;

/**
 *
 * @author fdn-user
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import sistemreservasihotel.helper.DatabaseConnection;
import java.sql.SQLException;
import sistemreservasihotel.model.Reservation;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    public static void savePayment(int reservationId, double totalAmount, String method, String notes) {
        String sql = "INSERT INTO payments (reservation_id, payment_date, total_amount, payment_method, notes) VALUES (?, CURDATE(), ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reservationId);
            stmt.setDouble(2, totalAmount);
            stmt.setString(3, method);
            stmt.setString(4, notes);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Pembayaran berhasil disimpan.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menyimpan pembayaran: " + e.getMessage());
        }
    }

    public static List<Reservation> getReservationsForPayment() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE status = 'checkout'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Reservation res = new Reservation(
                    rs.getInt("reservation_id"),
                    rs.getInt("guest_id"),
                    rs.getInt("room_id"),
                    rs.getDate("check_in_date"),
                    rs.getDate("check_out_date"),
                    rs.getString("status")
                );
                list.add(res);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

