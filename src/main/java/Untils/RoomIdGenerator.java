package Untils;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created by Ryuu on 20.01.2017.
 */
public class RoomIdGenerator
{
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static int GenerateID()
    {
        return atomicInteger.getAndIncrement();
    }
}
