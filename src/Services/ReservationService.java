package Services;

import Enums.ReservationStatus;
import Models.Reservation;
import Models.Room;
import Models.User;
import Repositories.impl.InMemoryReservationRepo;
import Repositories.impl.InMemoryRoomRepo;
import Utils.DatesUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ReservationService {

    private final InMemoryRoomRepo roomRepository;
    private final InMemoryReservationRepo reservationRepo;
    private final DatesUtil datesUtil;
    private final AuthService authService;

    public ReservationService(
            AuthService authService ,
            InMemoryReservationRepo reservationRepo ,
            InMemoryRoomRepo roomRepo,
            DatesUtil datesUtil
    ){
         this.roomRepository = roomRepo;
         this.datesUtil = datesUtil;
         this.reservationRepo = reservationRepo ;
         this.authService = authService;
    }
    public Reservation addNewReservation(String roomID , String checkIn , String checkOut ,int personsNumber ){

          LocalDate parsedCheckIn = datesUtil.parseStringToDate(checkIn);
          LocalDate parsedCheckOut = datesUtil.parseStringToDate(checkOut);

          datesUtil.checkGreaterDate(checkIn , checkOut);
          long nights =  datesUtil.calculNights(checkIn , checkOut);

          Optional<Room> roomOptional = roomRepository.findById(roomID);
          if(roomOptional.isEmpty()){
              throw new IllegalArgumentException("Room not found");
          }
          // check if room already reserved
          List<Reservation> reservations = reservationRepo.findByRoomId(roomID);
          checkAlreadyReserved(reservations , parsedCheckIn , parsedCheckOut);

          Room room = roomOptional.get();

          if(personsNumber > room.getCapacity()){
            throw new IllegalArgumentException("number of persons must be sma");
          }
          double total = room.getNightPrice() * (int) nights;

          // get logged user
          User user = authService.getLoggedUser();
          if (user == null) {
              throw new IllegalArgumentException("No user is logged in.");
          }
          System.out.println("Logged user: " + user);

          Reservation reservation = new Reservation(
                  user,
                  room,
                  parsedCheckIn,
                  parsedCheckOut,
                  nights,
                  total,
                  personsNumber,
                  ReservationStatus.CONFIRMED
          );

          reservationRepo.save(reservation);
          return reservation;

    }

    public void checkAlreadyReserved(List<Reservation> reservations ,LocalDate checkIn , LocalDate checkOut){
        for(Reservation reservation : reservations){
            if (checkIn.isBefore(reservation.getCheckOut())
                    && checkOut.isAfter(reservation.getCheckIn())) {

                throw new IllegalArgumentException(
                        "This room is already reserved for these dates"
                );
            }
        }
    }

}
