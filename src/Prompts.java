import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Prompts {
    public static ArrayList<String> prompts = new ArrayList<String>();
    public static String init(File f) throws FileNotFoundException {
        prompts = Tools.readFileToArray(f);
        int arraySize = prompts.size();
        Random ran = new Random();
        int promptPositionInArray = ran.nextInt(arraySize);
        String prompt = prompts.get(promptPositionInArray);
        //System.out.println(prompt);
        return prompt;
    }
}
