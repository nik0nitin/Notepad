package OOPApproach;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;

public class Notepad {
    static Frame f;
    static TextArea ta;
    MenuBar mb;
    Menu m1, m2;
    static MenuItem nw, opn, sv, svas, ext, fnd, fndRe;

    public Notepad(){
        f=new Frame("Nitin\'s Notepad"); f.setSize(400,500);
        mb=new MenuBar();
        m1=new Menu("File");
        m2=new Menu("Edit");

        nw=new MenuItem("New");
        opn=new MenuItem("Open");
        sv=new MenuItem("Save");
        svas=new MenuItem("Save As");
        ext=new MenuItem("Exit");
        fnd=new MenuItem("Find");
        fndRe=new MenuItem("Find & Replace");

        ta=new TextArea();
        ta.setFont(new Font("Arial", Font.PLAIN, 20));

        FileMenuAction fma=new FileMenuAction();
        nw.addActionListener(fma);
        opn.addActionListener(fma);
        sv.addActionListener(fma);
        svas.addActionListener(fma);
        ext.addActionListener(fma);

        EditMenuAction ema = new EditMenuAction();
        fnd.addActionListener(ema);
        fndRe.addActionListener(ema);

        //--------------------------------------------------------------------------------------------
        //Creating inner class/or lambda Expression. (I could have achieved with ActionListener, there I would have done the same thing.//
        /*ext.addActionListener(e -> {
            WindowCloseAction wca = new WindowCloseAction();
            wca.windowClosing(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
                });
         */
        //--------------------------------------------------------------------------------------------
        /*EditMenuAction ema=new EditMenuAction();
        fnd.addActionListener(ema);
        fndRe.addActionListener(ema);*/

        m1.add(nw); m1.add(opn); m1.add(sv); m1.add(svas); m1.addSeparator(); m1.add(ext);
        m2.add(fnd); m2.add(fndRe);
        mb.add(m1); mb.add(m2);
        f.setMenuBar(mb); f.add(ta); f.setVisible(true);
        WindowCloseAction wca=new WindowCloseAction();
        f.addWindowListener(wca);
    }
    public static void main(String[] args){
        Notepad npf=new Notepad();
    }
}

