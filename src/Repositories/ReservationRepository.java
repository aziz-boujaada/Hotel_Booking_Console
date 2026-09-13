package Repositories;

import Models.Reservation;
import Models.Room;
import Models.User;

import java.util.List;

public interface ReservationRepository {
     Reservation save(Reservation reservation);
     List<Reservation> findByRoomId(String roomId);
     List<Reservation> myReservations(User loggedUser);
}
