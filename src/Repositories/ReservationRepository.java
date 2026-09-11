package Repositories;

import Models.Reservation;
import Models.Room;

import java.util.List;

public interface ReservationRepository {
     Reservation save(Reservation reservation);
     List<Reservation> findByRoomId(String roomId);
}
