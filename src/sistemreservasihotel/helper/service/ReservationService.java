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
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public static void loadReservations(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        String sql = "SELECT r.reservation_id, g.name AS guest_name, rm.room_number, " +
                     "r.check_in_date, r.check_out_date, r.status " +
                     "FROM reservations r " +
                     "JOIN guests g ON r.guest_id = g.guest_id " +
                     "JOIN rooms rm ON r.room_id = rm.room_id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("reservation_id");
                String guestName = rs.getString("guest_name");
                String roomNumber = rs.getString("room_number");
                Date checkIn = rs.getDate("check_in_date");
                Date checkOut = rs.getDate("check_out_date");
                String status = rs.getString("status");

                model.addRow(new Object[]{id, guestName, roomNumber, checkIn, checkOut, status});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data reservasi: " + e.getMessage());
        }
    }
    
}
