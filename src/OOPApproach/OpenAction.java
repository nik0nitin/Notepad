package OOPApproach;

public class OpenAction extends Thread{
    static String filepath = "";
    static String initialContent = "";
    public OpenAction() {
        Content c = new Content();
        if( (Content.initialContent.equals(Content.getFinalContent()))|| c.getFinalContent().equals("")) {
            System.out.println();
            System.out.println("OpenAction Constructor Triggered.");

//            Notepad.ta.setText("");
            FileDialogFrame fdf = new FileDialogFrame();
            fdf.fdLoad();
            OpenAction.filepath = fdf.filepath;


            FileReadWrite frw = new FileReadWrite();
            if(!(OpenAction.filepath.equals(""))){
                frw.read(filepath);
            }
            if(frw.isReadSuccessfully()==true) {
                System.out.println("If statement triggered");
                OpenAction.initialContent = Notepad.ta.getText();
                Content.filepath = OpenAction.filepath;
                Content.initialContent = OpenAction.initialContent;
                OpenAction.initialContent = "";
                OpenAction.filepath = "";
            }



            System.out.println("Content filepath: " + Content.filepath);
            System.out.println("Content.initialContent: " + Content.initialContent);
            System.out.println();
//            initialContent = Notepad.ta.getText();
        }
        else{
            PopUp pop = new PopUp();
        }
    }

}
