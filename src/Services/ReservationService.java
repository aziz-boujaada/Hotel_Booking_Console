package Services;

import Enums.ReservationStatus;
import Models.Reservation;
import Models.Room;
import Repositories.impl.InMemoryRoomRepo;
import Utils.DatesUtil;

import java.time.LocalDate;
import java.util.Optional;

public class ReservationService {

    private final InMemoryRoomRepo roomRepository;
    private final DatesUtil datesUtil;
    public ReservationService(){
         this.roomRepository = new InMemoryRoomRepo();
         this.datesUtil = new DatesUtil();
    }
    public Reservation addNewReservation(String roomID , String checkIn , String checkOut ,long nights ){

          LocalDate parsedCheckIn = datesUtil.parseStringToDate(checkIn);
          LocalDate parsedCheckOut = datesUtil.parseStringToDate(checkOut);

          datesUtil.checkGreaterDate(checkIn , checkOut);
          nights =  datesUtil.calculNights(checkIn , checkOut);

          Optional<Room> roomOptional = roomRepository.findById(roomID);
          if(roomOptional.isEmpty()){
              throw new IllegalArgumentException("Room not found");
          }

          Room room = roomOptional.get();

          double total = room.getNightPrice() * (int) nights;



          return new Reservation(null , null , room ,parsedCheckIn , parsedCheckOut , nights ,total, ReservationStatus.CONFIRMED);

    }
}
