package Models;

import Enums.ReservationStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Reservation {

    private String reservationID ;
    private User client ;
    private Room room ;
    private Date checkIn ;
    private Date checkOut ;
    private int nights ;
    private BigDecimal total ;
    private ReservationStatus status;

    public static int counter = 0 ;
    public Reservation(String reservationID, User client, Room room, Date checkIn, Date checkOut, int nights, BigDecimal total, ReservationStatus status) {
        this.reservationID = reservationID;
        this.client = client;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = nights;
        this.total = total;
        this.status = status;
    }


    // generate unique identify to room
    public String generateReservationID(){
        UUID identify = UUID.randomUUID();
        return "RES-" + identify.toString().substring(0 , 4) + "-" + String.format("%04d" , counter++);
    }

    public String getReservationNumber() {
        return reservationID;
    }

    public void setReservationNumber(String reservationID) {
        this.reservationID = reservationID;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
