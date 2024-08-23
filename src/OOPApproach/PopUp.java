package OOPApproach;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class PopUp extends WindowAdapter implements ActionListener{
    static Frame f;
    Label l;
    static Button sv, dsv, cncl;
    Panel p1;
    static String actionRegistered = "";

    public PopUp() {
        f = new Frame("Notepad");
        f.setSize(350,140);
        f.setVisible(true);
        //-----------------------------------------------------------------
        //WindowCloseAction wca = new WindowCloseAction();
        //wca.windowClosing(new WindowEvent(Notepad.f, WindowEvent.WINDOW_CLOSING));
        f.addWindowListener(this);
        //-----------------------------------------------------------------
        sv=new Button("Save");
        //FileMenuAction fma = new FileMenuAction();
        sv.addActionListener(this);
        dsv=new Button("Don\'t save");
        dsv.addActionListener(this);
        cncl=new Button("Cancel");
        cncl.addActionListener(this);
        l=new Label("Do you want to save this file?");
        p1=new Panel();
        p1.add(sv); p1.add(dsv); p1.add(cncl); p1.setBackground(Color.gray);
        f.add(p1, "South"); f.add(l);
        f.setResizable(false);

    }
    static {
        System.out.println();
        System.out.println("Pop Up Triggered");
        System.out.println("Content.initialContent: " +Content.initialContent);
        System.out.println("Contetn.finalContent: " + Content.getFinalContent());
        System.out.println();
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Cancel")){
            actionRegistered = str;
            f.dispose();

        }
        else if(str.equals("Don\'t save")){
            String selected = Notepad.ta.getText();
            int no = selected.length();
            //System.out.println(no);
            Notepad.ta.setText("");
            Content.initialContent="";
            Content.filepath="";
            actionRegistered = str;
            f.dispose();

            //----------------------------------------------------

            String far = FileMenuAction.actionRegistered;
            switch (far) {
                case "Open":
                    new OpenAction();
                    break;
                case "New":
                    new NewAction().newScreen();
                    break;
            }
        }
        else {
            new SaveAction().save();
            actionRegistered = str;
            f.dispose();

            //-------------------------------------------------------------
            String far = FileMenuAction.actionRegistered;
            switch (far) {
                case "Open":
                    new OpenAction();
                    break;
                case "New":
                    new NewAction().newScreen();
                    break;
            }
        }

    }
    public void windowClosing(WindowEvent e) {
        Window w = e.getWindow();
        w.setVisible(false);
        w.dispose();
        //System.exit(1);
    }

}