package OOPApproach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class FileMenuAction implements ActionListener {
    static String actionRegistered = "";
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        actionRegistered = str;
        switch (str) {
            case "Open":
                new OpenAction();
                break;
            case "Save":
                SaveAction sa = new SaveAction();
                sa.save();
                break;
            case "Save As":
                new SaveAction().saveAs();
                break;
            case "New":
                new NewAction().newScreen();
                break;
            case "Exit":
                WindowCloseAction wca = new WindowCloseAction();
                wca.windowClosing(new WindowEvent(Notepad.f, WindowEvent.WINDOW_CLOSING));
                break;
        }
        actionRegistered="";
    }
}
