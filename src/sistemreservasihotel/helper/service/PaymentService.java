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
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistemreservasihotel.utils.CurrencyUtil;

public class PaymentService {

    public static void savePayment(int reservationId, double totalAmount, String method, String notes) {
    String sqlInsert = "INSERT INTO payments (reservation_id, payment_date, total_amount, payment_method, note) VALUES (?, CURDATE(), ?, ?, ?)";
    String sqlUpdate = "UPDATE reservations SET status = 'paid' WHERE reservation_id = ?";

    try (Connection conn = DatabaseConnection.getConnection()) {
        conn.setAutoCommit(false); // Mulai transaksi

        try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {

            // Simpan pembayaran
            stmtInsert.setInt(1, reservationId);
            stmtInsert.setDouble(2, totalAmount);
            stmtInsert.setString(3, method);
            stmtInsert.setString(4, notes);
            stmtInsert.executeUpdate();

            // Update status reservasi
            stmtUpdate.setInt(1, reservationId);
            stmtUpdate.executeUpdate();

            conn.commit();

            JOptionPane.showMessageDialog(null, "Pembayaran berhasil disimpan dan status reservasi diperbarui.");
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menyimpan pembayaran: " + e.getMessage());
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Kesalahan koneksi: " + e.getMessage());
    }
}

    
    public static void loadPayments(JTable tblPayment) {
        String[] columnNames = {
            "No", "Payment ID", "Reservation ID", "Nama Tamu",
            "No. Kamar", "Tanggal", "Total", "Metode", "Catatan"
        };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        String sql = """
            SELECT p.payment_id, p.reservation_id, g.name AS guest_name,
                   rm.room_number, p.payment_date, p.total_amount,
                   p.payment_method, p.note AS notes
            FROM payments p
            JOIN reservations r ON p.reservation_id = r.reservation_id
            JOIN guests g ON r.guest_id = g.guest_id
            JOIN rooms rm ON r.room_id = rm.room_id
            ORDER BY p.payment_date DESC
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            int no = 1;

            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getInt("payment_id"),
                    rs.getInt("reservation_id"),
                    rs.getString("guest_name"),
                    rs.getString("room_number"),
                    rs.getDate("payment_date"),
                    CurrencyUtil.formatRupiah(rs.getDouble("total_amount")),
                    rs.getString("payment_method"),
                    rs.getString("notes")
                });
            }

            tblPayment.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data pembayaran: " + e.getMessage());
        }
    }

    
}
