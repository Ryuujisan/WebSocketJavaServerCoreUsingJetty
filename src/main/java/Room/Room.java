package Room;

import Menager.RoomMenager;
import Player.Player;

import java.util.HashMap;

/**
 * Created by Ryuu on 20.01.2017.
 */
public class Room implements Runnable
{
    private RoomMenager roomMenager;

    private int ID;
    private String roomName;

    private HashMap<Integer, Player> playerList;


    public Room()
    {

    }


    public Room(int ID, RoomMenager roomMenager)
    {
        this.ID = ID;
        this.roomMenager = roomMenager;
    }

    public void run()
    {

    }

    public int getID() {
        return ID;
    }

    public String getRoomName() {
        return roomName;
    }

    public HashMap<Integer, Player> getPlayerList() {
        return playerList;
    }
}
