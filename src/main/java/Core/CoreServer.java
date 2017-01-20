package Core;

import Handlers.IncomingPacketHendler;
import Menager.ClientMennager;
import Menager.RoomMenager;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Created by Ryuu on 20.01.2017.
 */

@WebSocket
public class CoreServer
{
    private static CoreServer instance;

    private RoomMenager roomMenager;
    private IncomingPacketHendler incomingPacketHendler;
    private ClientMennager clientMennager;
    private PacketFactory packetFactory;


    public CoreServer()
    {
        instance = this;

        roomMenager = new RoomMenager();
        incomingPacketHendler = new IncomingPacketHendler();
        clientMennager = new ClientMennager();
        packetFactory = new PacketFactory();
    }

    public PacketFactory getPacketFactory()
    {
        return packetFactory;
    }

    public RoomMenager getRoomMenager() {
        return roomMenager;
    }

    public IncomingPacketHendler getIncomingPacketHendler() {
        return incomingPacketHendler;
    }

    public ClientMennager getClientMennager() {
        return clientMennager;
    }

    public static CoreServer getInstance()
    {
        return instance;
    }
}
