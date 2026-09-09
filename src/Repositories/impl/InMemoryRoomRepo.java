package Repositories.impl;

import Models.Room;
import Repositories.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryRoomRepo implements RoomRepository {

    HashMap<String , Room> rooms = new HashMap<>();

    @Override
    public Room addNewRoom(Room room) {

        rooms.put(room.generateRoomID() , room);

        return room;

    }

    @Override
    public List<Room> showAllRooms(){
        List<Room> roomList = new ArrayList<>();

        for (Room room : rooms.values()) {
            roomList.add(room);
        }

        return roomList;

    }
}
