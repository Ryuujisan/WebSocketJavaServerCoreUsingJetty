package Player;

import org.eclipse.jetty.websocket.api.Session;

/**
 * Created by Ryuu on 19.01.2017.
 */
public class ClientConnect
{
    private Session session;

    public ClientConnect(Session session)
    {
        this.session = session;
    }

    public Session getClienSesion()
    {
        return session;
    }
}
