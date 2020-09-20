import java.io.FileNotFoundException;
import java.io.File;
import java.awt.AWTException;

public class Setup{
    public static void setup() throws FileNotFoundException{
        File prompt = Tools.createTxtFile("promptListFile");
        File group = Tools.createTxtFile("roster");
        try{
            Tools.openFile(prompt);
            try{
                Thread.sleep(1500);
            }
            catch(InterruptedException e){
                ;
            }
            Tools.openFile(group);
        }
        catch(AWTException e){
            ;
        }
    }
}