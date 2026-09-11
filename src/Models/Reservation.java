package Models;

import Enums.ReservationStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Reservation {

    private String reservationID ;
    private User client ;
    private Room room ;
    private LocalDate checkIn ;
    private LocalDate checkOut ;
    private long nights ;
    private double total ;
    private ReservationStatus status;
    private int personneNumbers;

    public static int counter = 0 ;
    public Reservation(String reservationID, User client, Room room, LocalDate checkIn, LocalDate checkOut, long nights, double total, int personneNumbers, ReservationStatus status) {
        this.reservationID = reservationID;
        this.client = client;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = nights;
        this.total = total;
        this.personneNumbers = personneNumbers;
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

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public long getNights() {
        return nights;
    }

    public void setNights(long nights) {
        this.nights = nights;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPersonneNumbers() {
        return personneNumbers;
    }

    public void setPersonneNumbers(int personneNumbers) {
        this.personneNumbers = personneNumbers;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Reservation{" +
                "ID='" + reservationID + '\'' +
                ", Room ='" + room.toString() + '\'' +
                ", Chek-In='" + checkIn + '\'' +
                ", Check-Out='" + checkOut + '\'' +
                ", Nights='" + nights + '\'' +
                ", Total='" + total + '\'' +
                ", Persons='" + personneNumbers + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}
