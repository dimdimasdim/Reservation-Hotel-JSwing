/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.model;

/**
 *
 * @author fdn-user
 */
public class Guest {
    private int guestId;
    private String name;

    public Guest(int guestId, String name) {
        this.guestId = guestId;
        this.name = name;
    }

    public int getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
