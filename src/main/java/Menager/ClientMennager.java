package Menager;

import Player.ClientConnect;
import org.eclipse.jetty.websocket.api.Session;

import java.util.HashMap;

/**
 * Created by Ryuu on 20.01.2017.
 */

public class ClientMennager
{
    private HashMap<Session, ClientConnect> playerList = new HashMap<Session, ClientConnect>();

    public ClientConnect geClientConnection(Session session)
    {
        return playerList.get(session);
    }

    public void AddClientConnection(ClientConnect clientConnect)
    {
        playerList.put(clientConnect.getClienSesion(), clientConnect);
    }

    public void RemoveClient(Session session)
    {
        playerList.remove(session);
    }
}
