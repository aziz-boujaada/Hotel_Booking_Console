package Repositories;

import Models.Room;

import java.util.List;

public interface RoomRepository {
     Room addNewRoom(Room room) ;
     List<Room> showAllRooms();
}
