package OOPApproach;
import java.awt.*;
import java.io.File;

public class FileDialogFrame {
    FileDialog fd;
    static String filepath;
    public void fdLoad(){
        fd = new FileDialog(Notepad.f, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile() != null){
            filepath = fd.getDirectory() + fd.getFile();
        }
        else{
            filepath = "";
        }
    }
    public void fdSave(){
        fd = new FileDialog(Notepad.f, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile() != null){
            filepath = fd.getDirectory() + fd.getFile();
        }
        else{
            filepath = "";
        }
    }


}
