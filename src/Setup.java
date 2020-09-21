import java.io.FileNotFoundException;
import java.io.File;
import java.awt.AWTException;

public class Setup{
    public static void setup() throws FileNotFoundException{
        final String documents = Setup.platformDrive()+"/Users/"+System.getProperty("user.name")+"/Documents";
        File file = new File(documents+"/JavaTeachingUtility");
        if(file.mkdir()){
            System.out.println("Success");
        }
        File prompt = Tool.createTxtFile(documents+"/JavaTeachingUtility/promptListFile");
        File group = Tool.createTxtFile(documents+"/JavaTeachingUtility/roster");
        try{
            Tool.openFile(prompt);
            try{
                Thread.sleep(1500);
            }
            catch(InterruptedException e){
                ;
            }
            Tool.openFile(group);
        }
        catch(AWTException e){
            ;
        }
    }
    public static String platformDrive(){
        final String sys = System.getProperty("os.name");
        if(sys.contains("Windows")){
            return "C:";
        }
        return "";
    }
}