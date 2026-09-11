package Repositories.impl;

import Models.Reservation;
import Repositories.ReservationRepository;
import Services.AuthService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryReservationRepo implements ReservationRepository {



    public InMemoryReservationRepo(){

    }
    private static final HashMap<String , Reservation> reservations = new HashMap<>();

    public Reservation save(Reservation reservation){

        String ReservationId = reservation.generateReservationID();
        reservations.put(ReservationId , reservation);

        return  reservation;
    }

    public List<Reservation> findByRoomId(String roomId){
         return reservations.values().stream()
                 .filter(reservation -> reservation.getRoom().getIdentify().equals(roomId))
                 .toList();
    }

}
