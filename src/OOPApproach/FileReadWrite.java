package OOPApproach;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReadWrite{
    private boolean readSuccessfully=false;
    private boolean writtenSuccessfully =false;
    //Read will be used in Open.
    static boolean windowCanClose=false;
    public void read(String path){
        try{
            Notepad.ta.setText("");
            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            /*int x;
            while((x = bis.read()) != -1){
                Notepad.ta.append((char) x + "");
            }*/
            //------------------------New Addition To speed up read on Notepad------------//
            StringBuilder content = new StringBuilder();
            int x;
            while ((x = bis.read()) != -1) {
                content.append((char) x);
            }
            // Append all at once to reduce the number of UI updates
            Notepad.ta.append(content.toString());
            setReadSuccessfully(true);
            //-----------------------------------------------//
            bis.close(); fis.close();
        }
        catch(Exception e) {
            e.getMessage();
        }

    }

    //Write will be used for Save/Save As.
    public void write(String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(Notepad.ta.getText().getBytes());
            bos.close(); fos.close();
            setWrittenSuccessfully(true);
            if(WindowCloseAction.windowClosingEvent==true){
                setWindowCanClose(true);
            }
        }
        catch(Exception e) {
            e.getMessage();
        }

    }

    public boolean isWrittenSuccessfully() {
        return writtenSuccessfully;
    }

    public boolean isReadSuccessfully() {
        return readSuccessfully;
    }

    public void setReadSuccessfully(boolean readSuccessfully) {
        this.readSuccessfully = readSuccessfully;
    }

    public void setWrittenSuccessfully(boolean writtenSuccessfully) {
        this.writtenSuccessfully = writtenSuccessfully;
    }

    public static boolean isWindowCanClose() {
        return windowCanClose;
    }

    public static void setWindowCanClose(boolean windowCanClose) {
        FileReadWrite.windowCanClose = windowCanClose;
    }
}
