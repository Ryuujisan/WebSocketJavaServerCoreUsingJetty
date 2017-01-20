package Core;

import Player.ClientConnect;
import Untils.ServerDebugLog;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.eclipse.jetty.server.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.OnClose;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Ryuu on 19.01.2017.
 */

@WebSocket
public class CoreWebSocket extends WebSocketHandler
{
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello World</h1>");

    }


    public void configure(WebSocketServletFactory webSocketServletFactory)
    {
        webSocketServletFactory.register(CoreServer.class);
    }

    public CoreWebSocket()
    {
        synchronized (this.getClass())
        {
            CoreServer coreServer = new CoreServer();
        }
    }

    @OnClose
    @OnWebSocketClose
    public void onClose(Session session, int statusCodem, String reasen)
    {
        CoreServer.getInstance().getClientMennager().RemoveClient(session);
    }

    @OnWebSocketError
    public void onError (Throwable t)
    {

    }

    @OnWebSocketConnect
    public void onConnect(Session session)
    {
        ServerDebugLog.DebugLog("Mew Connection");
        ClientConnect clientConnect = new ClientConnect(session);
        CoreServer.getInstance().getClientMennager().AddClientConnection(clientConnect);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, InputStream streamFromClient)
    {
        //TODO odbieranie pakietów tym sie zajmie prtobuffer ;-)
    }
}
