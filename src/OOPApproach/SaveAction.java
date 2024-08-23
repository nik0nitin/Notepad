package OOPApproach;
import java.awt.event.*;


public class SaveAction {
    static String initialContent = "";
    static String filePath = "";
    static String definedSavePath="";
    //When we are writing on Notepad.ta(TextArea), don't have filepath, then SaveAs will be called.
    public static boolean hasPath() {
        if(!Content.filepath.equals("")){
            System.out.println("hasPath: true");
            return true;
        }
        else {
            System.out.println("hasPath: false");
            return false;
        }
    }
    public void save() {
        if(SaveAction.hasPath() /*|| !SaveAction.filePath.equals("")*/){
//            new FileReadWrite().write((SaveAction.filePath.equals("") ? OpenAction.filepath : SaveAction.filePath));
            FileReadWrite frw = new FileReadWrite();
            frw.write(Content.getFilepath());

            if(frw.isWrittenSuccessfully() == true) {
                SaveAction.initialContent = Notepad.ta.getText();
                Content.initialContent = SaveAction.initialContent;
                SaveAction.initialContent = "";
            }
            System.out.println();
            System.out.println("Save Action Triggered");
            System.out.println("Content.initialContent: " + Content.initialContent);
            System.out.println("Content.filepath: " + Content.filepath);
            System.out.println();
        }
        else{
            saveAs();
//            FileDialogFrame fdf = new FileDialogFrame();
//            fdf.fdSave();
//            FileReadWrite frw = new FileReadWrite();
//            SaveAction.filePath = fdf.filepath;
//
//            SaveAction.initialContent = Notepad.ta.getText();
//            Content.initialContent=SaveAction.initialContent;
//            SaveAction.initialContent="";
//
//            frw.write(fdf.filepath);
//            System.out.println("Save Action filepath: " + SaveAction.filePath);
        }
    }
    public void saveAs() {
        //Here we are having a FileDialog frame for new location.
        FileDialogFrame fdf = new FileDialogFrame();
        fdf.fdSave();
        FileReadWrite frw = new FileReadWrite();

        frw.write(fdf.filepath);

        if(frw.isWrittenSuccessfully()== true) {
            SaveAction.filePath = fdf.filepath;
            Content.filepath = SaveAction.filePath;
            SaveAction.filePath = "";
            SaveAction.initialContent = Notepad.ta.getText();
            Content.initialContent = SaveAction.initialContent;
            SaveAction.initialContent = "";
        }

        System.out.println();
        System.out.println("SaveAs Action Triggered");
        System.out.println("SaveAs Action filepath: " + SaveAction.filePath);
        System.out.println("Content.filepath: " + Content.getFilepath());
        System.out.println("Content.initialContent: " + Content.initialContent);
    }
}
