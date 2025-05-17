/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.helper.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import sistemreservasihotel.helper.DatabaseConnection;
import java.sql.SQLException;
import sistemreservasihotel.model.Reservation;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistemreservasihotel.model.ReservationOption;

/**
 *
 * @author fdn-user
 */
public class ReservationService {
    
    public static boolean saveReservation(Reservation reservation) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO reservations (guest_id, room_id, check_in_date, check_out_date, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, reservation.getGuestId());
            stmt.setInt(2, reservation.getRoomId());
            stmt.setDate(3, new java.sql.Date(reservation.getCheckInDate().getTime()));
            stmt.setDate(4, new java.sql.Date(reservation.getCheckOutDate().getTime()));
            stmt.setString(5, reservation.getStatus());

            int rows = stmt.executeUpdate();
            stmt.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void loadReservationsByStatus(JTable table, String status) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String baseQuery = "SELECT r.reservation_id, g.name, rm.room_number, r.check_in_date, r.check_out_date, r.status " +
                           "FROM reservations r " +
                           "JOIN guests g ON r.guest_id = g.guest_id " +
                           "JOIN rooms rm ON r.room_id = rm.room_id";

        if (status != null && !status.trim().isEmpty()) {
            baseQuery += " WHERE r.status = ?";
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(baseQuery)) {

            // Isi parameter jika ada status
            if (status != null && !status.trim().isEmpty()) {
                stmt.setString(1, status);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("reservation_id"),
                    rs.getString("name"),
                    rs.getString("room_number"),
                    rs.getDate("check_in_date"),
                    rs.getDate("check_out_date"),
                    rs.getString("status")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data reservasi: " + e.getMessage());
        }
    }
    
    public static void checkInReservation(int reservationId, int roomId) {
        String sql = "UPDATE reservations SET status = 'checked_in' WHERE reservation_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reservationId);
            stmt.executeUpdate();

            // Update status kamar
            RoomService.updateRoomStatus(roomId, "Occupied");

            JOptionPane.showMessageDialog(null, "Check-In berhasil!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal check-in: " + e.getMessage());
        }
    }
    
    
    public static void checkOutReservation(int reservationId, int roomId) {
        String sql = "UPDATE reservations SET status = 'checked_out' WHERE reservation_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reservationId);
            stmt.executeUpdate();

            // Update status kamar
            RoomService.updateRoomStatus(roomId, "Available");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal check-in: " + e.getMessage());
        }
    }
    
    public static void loadReservationsToComboBox(JComboBox<ReservationOption> comboBox) {
        comboBox.removeAllItems();
        String sql = "SELECT r.reservation_id, g.name " +
                 "FROM reservations r " +
                 "JOIN guests g ON r.guest_id = g.guest_id " +
                 "LEFT JOIN payments p ON r.reservation_id = p.reservation_id " +
                 "WHERE r.status = 'checked_out' AND p.payment_id IS NULL";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("reservation_id");
                String name = rs.getString("name");

                ReservationOption option = new ReservationOption(id, name);
                comboBox.addItem(option);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data reservasi.");
        }
    }
    
    
   public static double calculateTotalPayment(int reservationId) {
        String sql = "SELECT DATEDIFF(r.check_out_date, r.check_in_date) AS duration, rm.price_per_night " +
                     "FROM reservations r " +
                     "JOIN rooms rm ON r.room_id = rm.room_id " +
                     "WHERE r.reservation_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reservationId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int days = rs.getInt("duration");
                double pricePerNight = rs.getDouble("price_per_night");

                // Minimal menginap 1 hari (misal tanggal sama)
                if (days <= 0) days = 1;

                return pricePerNight * days;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }



    
}
