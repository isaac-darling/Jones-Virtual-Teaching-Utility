import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception{
        File f = Tools.createTxtFile("PromptListFile");
        System.out.println(Prompts.init(f));
        System.out.println(Groups.makeGroups(3));
        //GUI.gui();
    }
}
