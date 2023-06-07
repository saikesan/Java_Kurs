package net;

import java.net.Socket;

public class ServerConnection
    extends Thread
{
    public CommunicationModule getCommunicationModule()
    {
        return com;
    }

    CommunicationModule com;

    public ServerConnection(Socket socket)
    {
        com = new CommunicationModule(socket);
        com.init();
    }

    public boolean isConnected()
    {
        return getCommunicationModule().isConnected();
    }

    /**
     * Facade method.
     * @param message
     */
    public void say(String message)
    {
        getCommunicationModule().say(message);
    }

    public String readLine()
    {
        return readLineBlocking();
    }

    String readLineBlocking()
    {
        return getCommunicationModule().readLineBlocking();
    }

    @Override
    public void run()
    {

    }
}
