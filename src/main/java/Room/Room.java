package Room;

import Core.Main;
import Menager.RoomMenager;
import Player.Player;
import Untils.Constance;

import java.util.HashMap;
import java.util.Timer;

/**
 * Created by Ryuu on 20.01.2017.
 */
public class Room implements Runnable
{
    private RoomMenager roomMenager;

    private int ID;
    private String roomName;

    private HashMap<Integer, Player> playerList;

    private Thread thread;

    private Timer timer = new Timer();

    public Room()
    {
        thread = new Thread(this);
        thread.start();
    }


    public Room(int ID, RoomMenager roomMenager)
    {   this();
        this.ID = ID;
        this.roomMenager = roomMenager;
    }

    @Override
    public void run()
    {
        while(true)
        {
            long start = GetCurretTime();
            try
            {
                Thread.sleep(start + Constance.FPS - GetCurretTime());
            } catch (Exception e)
            {
                if(Main.isServerIsDeveloper())
                {
                    e.printStackTrace();
                }
            }
        }
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

    protected long GetCurretTime()
    {
        return System.currentTimeMillis();
    }
}
