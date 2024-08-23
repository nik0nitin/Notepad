package OOPApproach;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseAction extends WindowAdapter implements ActionListener {
    static boolean windowClosingEvent=false;
    public void windowClosing(WindowEvent e){
        windowClosingEvent=true;
        Window w = e.getWindow();
        Content c = new Content();

        //Content is Same || Content is ""//

        if(!(c.isDifferent()) || (c.getFinalContent().equals(""))){
            w.setVisible(false);
            w.dispose();
            System.exit(1);
        }
        else{
            PopUp pop = new PopUp();
            pop.sv.addActionListener(this);
            pop.dsv.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        System.out.println("-------------------------------------");
        System.out.println("window Close Action: " + str);
        if(str.equals("Don\'t save")){
            System.exit(0);
        }
        if(FileReadWrite.isWindowCanClose()) {
            System.exit(1);
        }
    }
}
