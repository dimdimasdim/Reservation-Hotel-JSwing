/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.helper.service;

/**
 *
 * @author fdn-user
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sistemreservasihotel.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sistemreservasihotel.helper.DatabaseConnection;
import java.sql.SQLException;

public class RoomService {

    public static List<Room> loadRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM rooms";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Room room = new Room(
                    rs.getInt("room_id"),
                    rs.getString("room_number"),
                    rs.getString("type"),
                    rs.getDouble("price_per_night"),
                    rs.getString("status")
                );
                rooms.add(room);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public static boolean saveRoom(Room room) {
        try (Connection conn = DatabaseConnection.getConnection()) {
        String sql = "INSERT INTO rooms (room_number, type, price_per_night, status) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, room.getRoomNumber());
        stmt.setString(2, room.getType());
        stmt.setDouble(3, room.getPrice());
        stmt.setString(4, room.getStatus());

        int rows = stmt.executeUpdate();
        stmt.close();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

    public static boolean updateRoom(Room room) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE rooms SET room_number = ?, type = ?, price_per_night = ?, status = ? WHERE room_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, room.getRoomNumber());
            stmt.setString(2, room.getType());
            stmt.setDouble(3, room.getPrice());
            stmt.setString(4, room.getStatus());
            stmt.setInt(5, room.getRoomId());

            int rows = stmt.executeUpdate();
            stmt.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteRoom(int roomId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM rooms WHERE room_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roomId);

            int rows = stmt.executeUpdate();
            stmt.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void updateRoomStatus(int roomId, String status) {
        String sql = "UPDATE rooms SET status = ? WHERE room_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, roomId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Room> getAvailableRooms() {
        List<Room> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM reservation_hotel.rooms WHERE status = 'available'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Room room = new Room(
                    rs.getInt("room_id"),
                    rs.getString("room_number"),
                    rs.getString("type"),
                    rs.getDouble("price_per_night"),
                    rs.getString("status")
                );
                rooms.add(room);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }
    
}