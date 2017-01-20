package Untils;

import Core.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ryuu on 19.01.2017.
 */

public class ServerDebugLog
{
    final static Logger logger = LoggerFactory.getLogger(ServerDebugLog.class);



    public static void LogError(String log)
    {
        if(Main.isServerIsDeveloper())
        {
            logger.error(log);
        }
    }

    public static void DebugLog(String log)
    {
        if(Main.isServerIsDeveloper())
        {
            logger.debug(log);
        }
    }

    public static void WarningLog(String log)
    {
        if(Main.isServerIsDeveloper())
        {
            logger.warn(log);
        }
    }
}
