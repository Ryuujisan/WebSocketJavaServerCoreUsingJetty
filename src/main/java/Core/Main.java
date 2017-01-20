package Core;

import Untils.ServerDebugLog;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.slf4j.impl.SimpleLogger;


/**
 * Created by Ryuu on 19.01.2017.
 */
public class Main
{
    private static boolean serverIsDeveloper = true;

    public static void main(String[] arg) throws Exception {

        //System.setProperty(SimpleLogger.SHOW_SHORT_LOG_NAME_KEY, "TRACE");

        if(arg.length > 1)
        {
            serverIsDeveloper = !arg[1].equals("produkcja");
        }

        ServerDebugLog.DebugLog("Test");

        StartJettyServer();

    }



    private static void StartJettyServer() throws Exception
    {
        ServerMenager server = new ServerMenager(6969);
        server.setHandler(CreateHandler());

        server.start();
        server.join();
    }

    public static WebSocketHandler CreateHandler()
    {
         WebSocketHandler handler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory webSocketServletFactory) {
                webSocketServletFactory.register(CoreWebSocket.class);
            }
        };

        return handler;
    }


    public static boolean isServerIsDeveloper()
    {
        return serverIsDeveloper;
    }
}
