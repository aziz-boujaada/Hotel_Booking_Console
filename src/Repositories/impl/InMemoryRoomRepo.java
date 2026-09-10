package Repositories.impl;

import Models.Room;
import Repositories.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryRoomRepo implements RoomRepository {

    HashMap<String, Room> rooms = new HashMap<>();

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

    @Override
    public Optional<Room> findById(String id){
        for(Room room : rooms.values()){
            if(room.generateRoomID().equalsIgnoreCase(id)){
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }

}
