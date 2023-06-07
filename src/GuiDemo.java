import net.MainThread;
import net.Server;

public class GuiDemo
{
    public static final int PORT = 50001;

    public static void main(String[] args) throws InterruptedException
    {
        Server      server  = new Server(PORT);
        MainThread  mThread = new MainThread(PORT);

        server.start();
        mThread.start();
    }
}
