/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2lab1;

/**
 *
 * @author amharb
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import se2lab1.ThePanel;

public class Receiver {

    public void receive() {
        String filename = "../SE2Lab1Sender/panel.ser";
        TheFrame theFrame = null;
        ThePanel panel = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
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
