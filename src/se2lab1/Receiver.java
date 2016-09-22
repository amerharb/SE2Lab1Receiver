package se2lab1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Receiver
{

    //in case the file is taken from server
    private final int PORT = 8000;
    private final String SERVER = "127.0.0.1";
    private final boolean FROM_FILE = false;

    public void receive()
    {
        String filename = "../SE2Lab1Sender/panel.ser";
        TheFrame theFrame = null;
        ThePanel panel = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {

            if (FROM_FILE) {// the file case TODO later server
                fis = new FileInputStream(filename);
                in = new ObjectInputStream(fis);
            } else { //from network
                Socket socket = new Socket(SERVER, PORT);
                InputStream is = socket.getInputStream();
                //isr = new InputStreamReader(is);
                //STOP BR br = new BufferedReader(isr);
                in = new ObjectInputStream(is);

            }
            panel = (ThePanel) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        theFrame = new TheFrame(panel);
        System.out.println("Panel info: " + panel.getInfo());
    }
}
