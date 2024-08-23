package OOPApproach;

import javax.management.OperationsException;

public class Content {
    static String filepath ="";
    static String initialContent = "";
    static String finalContent = "";

//    public String getInitialContent() {
//        if(FileMenuAction.actionRegistered.equals("Save") || PopUp.actionRegistered.equals("Save") || FileMenuAction.actionRegistered.equals("Save As")){
////            this.initialContent = SaveAction.initialContent;
//            this.initialContent=Notepad.ta.getText();
//            return this.initialContent;
//        }
//        else if(FileMenuAction.actionRegistered.equals("Open")) {
//            this.initialContent = OpenAction.initialContent;
//            return this.initialContent;
//        }
//        else {
//            initialContent = "";
//            return initialContent;
//        }
//    }
    public static String getFinalContent() {
        Content.finalContent = Notepad.ta.getText();
        return Content.finalContent;
    }

    public static boolean isDifferent(){
        if(!(Content.initialContent.equals(Content.getFinalContent()))){
            System.out.println("Content isDifferent Triggered");
            System.out.println("initialContent " + Content.initialContent);
            System.out.println("finalContent " + Content.finalContent);
            System.out.println("----------------------------");

            return true;
        }
        else {
            System.out.println("Content isDifferent Triggered");
            System.out.println("initialContent " + Content.initialContent);
            System.out.println("finalContent " + Content.finalContent);
            System.out.println("----------------------------");
            return false;
        }
//
    }
//    public static boolean isDifferent(){
//        Content content = new Content();
//        System.out.println("isDifferent() called: " + !(content.getInitialContent().equals(content.getFinalContent())));
//        System.out.println("initialContent " + content.getInitialContent());
//        System.out.println("finalContent " + content.getFinalContent());
//        return !(content.getInitialContent().equals(content.getFinalContent()));
//    }


    public static String getFilepath() {
        return filepath;
    }

    public static void setFilepath(String filepath) {
        Content.filepath = filepath;
    }
}
