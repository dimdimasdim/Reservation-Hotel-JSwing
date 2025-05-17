/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.model;

/**
 *
 * @author fdn-user
 */
public class ReservationOption {
    
    private int reservationId;
    private String guestName;

    public ReservationOption(int reservationId, String guestName) {
        this.reservationId = reservationId;
        this.guestName = guestName;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    @Override
    public String toString() {
        return "Reservasi ID : " + reservationId + " - Tamu :" + guestName;
    }
    
}
