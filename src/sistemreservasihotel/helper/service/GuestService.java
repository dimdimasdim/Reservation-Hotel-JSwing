/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.helper.service;

/**
 *
 * @author fdn-user
 */
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sistemreservasihotel.helper.DatabaseConnection;
import java.sql.SQLException;
import sistemreservasihotel.model.Guest;

public class GuestService {
    public static List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT guest_id, name FROM guests";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("guest_id");
                String name = rs.getString("name");
                guests.add(new Guest(id, name));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guests;
    }
}

