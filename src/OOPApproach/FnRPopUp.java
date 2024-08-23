package OOPApproach;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JOptionPane.showMessageDialog;

public class FnRPopUp extends WindowAdapter implements ActionListener {
    private ArrayList<FoundObject> arr=new ArrayList<>();
    private static String lastWordSearched;

    private boolean isTextHighlighted=false;
    private String highlightedTerm="";
    private Matcher matcher;
    private int lastIndexChecker;
    private int lastIndex=0;
    private int replaceLastIndex;
    static Frame f;
    Label l1, l2;
    static TextField t1, t2;
    Button findNext, rplc, rplAll, cls;
    Panel p1, p2;

    public FnRPopUp(){
        f = new Frame();
        f.setSize(350, 140);
        f.setVisible(true); f.setResizable(false);

        l1 = new Label("Find");
        l2 = new Label("Replace with");

        t1 = new TextField();
        t2 = new TextField();

        p2 = new Panel();
        p2.add(l1); p2.add(t1); p2.add(l2); p2.add(t2);
        p2.setLayout(new GridLayout(2,1));
        f.add(p2);

        findNext = new Button("Find Next");
        findNext.addActionListener(this);
        rplc = new Button("Replace");
        rplc.addActionListener(this);
        rplAll = new Button("Replace All");
        rplAll.addActionListener(this);
        
        cls = new Button("Close");
        cls.addActionListener(this);

        p1 = new Panel();
        p1.add(findNext); p1.add(rplc); p1.add(rplAll); p1.add(cls);
        f.add(p1, "South");
        f.addWindowListener(this);
    }

    public void actionPerformed(ActionEvent e){
        String str = e.getActionCommand();
        switch (str) {
            case "Close":
                windowClosing(new WindowEvent(FnRPopUp.f, WindowEvent.WINDOW_CLOSING));
                break;
            case "Find Next":
                findNext();
                break;
            case "Replace":
                replace();
                break;
            case "Replace All":
                replaceAll();
                break;
        }
    }

    //-----------------------------------------------------
    private void findNext(){
        String text=Notepad.ta.getText();
        String find=null;
        if(t1.getText().equalsIgnoreCase("")){
            showMessageDialog(f, "Enter text to find.");
        }
        else {
            find=t1.getText();
            if (!find.equalsIgnoreCase(lastWordSearched)) {
                lastIndex = 0;
            }
            System.out.println("-------findNext---------");
            System.out.println("lastIndex " + lastIndex);
            lastIndexChecker = lastIndex;
            Pattern p = Pattern.compile(Pattern.quote(find));
            Matcher m = p.matcher(text);
            Matcher tempM = p.matcher(text);
            int count = 0;
            if (!tempM.find()) {
                showMessageDialog(f, "No match found.");
            } else {
                while (m.find()) {
                    Pattern line = Pattern.compile("\n");
                    Matcher m1 = line.matcher(text.substring(0, m.start()));
                    while (m1.find()) {
                        count++;
                    }

                    FoundObject foundObject = new FoundObject();
                    foundObject.setStart(m.start() - count);
                    foundObject.setEnd(m.end() - count);
                    arr.add(foundObject);
                    count = 0;
                }
                System.out.println("Arr size " + arr.size());
            /*for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }*/
                //int first=arr.get(lastIndex).getStart();
                //int last=arr.get(lastIndex++).getEnd();
                highlightedTerm=find;
                Notepad.ta.select(arr.get(lastIndex).getStart(), arr.get(lastIndex).getEnd());
                Notepad.ta.requestFocus();
                isTextHighlighted = true;
                if (lastIndex <= arr.size() - 2) {
                    lastIndex++;
                } else {
                    lastIndex = 0;
                }
                System.out.println("highlightedTerm " + highlightedTerm);
            }
        }

            System.out.println("lastIndex " + lastIndex);
            lastWordSearched = find;
            arr.clear();



    }

    private void replace(){
        String text=Notepad.ta.getText();
        String find=t1.getText();
        String replaceWith=t2.getText();

        replaceLastIndex = 0;

        System.out.println("-------replace---------");
        System.out.println("lastIndex " + lastIndex);
        System.out.println("replaceLastIndex " + replaceLastIndex);

        Pattern p = Pattern.compile(Pattern.quote(find));
        Matcher m = p.matcher(text);
        Matcher tempM = p.matcher(text);
        int count = 0;

        if (!tempM.find()) {
            showMessageDialog(f, "No match found.");
        } else {
            while (m.find()) {
                Pattern line = Pattern.compile("\n");
                Matcher m1 = line.matcher(text.substring(0, m.start()));
                while (m1.find()) {
                    count++;
                }

                FoundObject foundObject = new FoundObject();
                foundObject.setStart(m.start() - count);
                foundObject.setEnd(m.end() - count);
                arr.add(foundObject);
                count = 0;
            }
            System.out.println("highlightedTerm " + highlightedTerm +"\nfind OR t1.getText() " + find);
            if (!isTextHighlighted || (isTextHighlighted && !highlightedTerm.equals(t1.getText()))) {
            /*//replaceLastIndex=0;
            Notepad.ta.select(arr.get(replaceLastIndex).getStart(), arr.get(replaceLastIndex).getEnd());
            //System.out.println("replaceLastIndex " + replaceLastIndex);
            Notepad.ta.requestFocus();
            isTextHighlighted=true;*/
                showMessageDialog(f, "Click 'Find Next' to find first.");
                lastIndex=0;
            } else {
                if(t1.getText().equals("") || t1.getText() == null){
                    showMessageDialog(f, "Add text to be replaced.");
                    isTextHighlighted=false;
                }
                else {
                    if (lastIndexChecker == arr.size() - 1) {
                        System.out.println("lastIndexChecker " + lastIndexChecker);
                        replaceLastIndex = arr.size() - 1;
                        System.out.println("if Statement Exectued");
                    } else if (lastIndex != 0 || (lastIndex != arr.size() - 1 && lastIndex != 0))
                        /*else if(lastIndex !=0 && lastIndex != arr.size()-1)*/ {
                        replaceLastIndex = lastIndex - 1;
                        lastIndex -= 1;
                        System.out.println("Else if statement executed.");
                    }
                    System.out.println("last Index " + lastIndex);
                    System.out.println("replaceLastIndex " + replaceLastIndex);
                    System.out.println();
                    Notepad.ta.replaceRange(replaceWith, arr.get(replaceLastIndex).getStart(), arr.get(replaceLastIndex).getEnd());
                    isTextHighlighted = false;
                }
            }



        }
        lastWordSearched = find;
        arr.clear();
        replaceLastIndex=-1;
    }

    private void replaceAll(){
        String text = Notepad.ta.getText();
        String find = t1.getText();
        String replaceWith = t2.getText();

        // Use regex to replace all occurrences
        text = text.replaceAll(Pattern.quote(find), Matcher.quoteReplacement(replaceWith));
        Notepad.ta.setText(text);
        lastIndex=0;
        matcher = null; // Reset matcher to handle updated text
    }
    //-----------------------------------------------------

    public void windowClosing(WindowEvent e){
        Window w = e.getWindow();
        w.setVisible(false);
        w.dispose();
        //------------------//
        lastIndex=0;
        arr.clear();
    }

    private void showMessageDialog(Frame parent, String message) {
        Dialog dialog = new Dialog(parent, "Message", true);
        dialog.setLayout(new FlowLayout());
        Label label = new Label(message);
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        dialog.add(label);
        dialog.add(ok);
        dialog.setSize(300, 100);
        dialog.setVisible(true);
    }

    public static void main(String[] args){
        try{
            new FnRPopUp();
        }
        catch(Exception e){
            new FnRPopUp();
        }
    }
}
