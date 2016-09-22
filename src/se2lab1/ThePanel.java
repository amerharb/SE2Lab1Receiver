
package se2lab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;

public class ThePanel extends JPanel implements Serializable, ActionListener {

    private static final long serialVersionUID = 1L;
    private String info;

    ThePanel() {
        super();
        JButton yesButton = new JButton("YES");
        add(yesButton);
        yesButton.addActionListener(this);
        
        JButton noButton = new JButton("NO");
        add(noButton);
        noButton.addActionListener(this);
        
        JButton quitButton = new JButton("QUIT");
        add(quitButton);
        quitButton.addActionListener(this);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        if (command.equals("QUIT")) {
            System.exit(0);
        }
    }
}
