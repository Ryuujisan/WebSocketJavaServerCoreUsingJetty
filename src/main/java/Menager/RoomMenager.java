package Menager;

import Room.Room;
import Untils.RoomIdGenerator;

import java.util.HashMap;

/**
 * Created by Ryuu on 20.01.2017.
 */
public class RoomMenager
{
    private HashMap<Integer, Room> roomList = new HashMap<Integer, Room>();


    public RoomMenager()
    {

    }

    public Room CreateRoom()
    {
        Room room = new Room(RoomIdGenerator.GenerateID(), this);
        roomList.put(room.getID(), room);
        return room;
    }
}
