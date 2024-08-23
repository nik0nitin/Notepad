package OOPApproach;

public class NewAction {
    public void newScreen(){
        System.out.println();
        System.out.println("New Action Triggered");

        Content c = new Content();
        if(!c.isDifferent()){
            Notepad.ta.setText("");
            OpenAction.filepath = ""; SaveAction.filePath = ""; FileDialogFrame.filepath = "";
            Content.filepath="";
            Content.initialContent="";
        }
        else{
            PopUp pop = new PopUp();
        }


    }
}
