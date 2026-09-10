package Repositories.impl;

import Models.Room;
import Repositories.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryRoomRepo implements RoomRepository {

    private static final HashMap<String, Room> rooms = new HashMap<>();

    @Override
    public Room addNewRoom(Room room) {

        rooms.put(room.generateRoomID() , room);

        return room;

    }

    @Override
    public List<Room> showAllRooms(){
        List<Room> roomList = new ArrayList<>();

        roomList.addAll(rooms.values());

        return roomList;

    }

}
