import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Prompts{
    static int promptIncrement = 0;
    static String[] prompts = Prompts.getShuffle();
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
            File f = Tools.createTxtFile("promptListFile");
            ArrayList<String> prompts = Tools.readFileToArray(f);
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