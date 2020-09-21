import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Prompt{
    static int promptIncrement = 0;
    static final String[] prompts = Prompt.getShuffle();
    public static String getPrompt() throws FileNotFoundException{
        try{
            String prompt = prompts[promptIncrement];
            promptIncrement++;
            return prompt;
        }
        catch(IndexOutOfBoundsException e){
            return "(there are no more prompts)";
        }
    }
    private static String[] getShuffle(){
        try{
            File f = Tool.createTxtFile(Setup.platformDrive()+"/Users/"+System.getProperty("user.name")+"/Documents/JavaTeachingUtility/promptListFile");
            ArrayList<String> prompts = Tool.readFileToArray(f);
            Collections.shuffle(prompts);
            String[] ans = new String[prompts.size()];
            prompts.toArray(ans);
            return ans;
        }
        catch(FileNotFoundException e){
            String[] error = {"Fatal Error: "+e};
            return error;
        }
    }
}