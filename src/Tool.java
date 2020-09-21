import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tool{
    public static ArrayList<String> readFileToArray(File File) throws FileNotFoundException{
		ArrayList<String> ArrayOfLines = new ArrayList<String>();
		Scanner sc = new Scanner(File);
		while (sc.hasNextLine()){
			try{
				ArrayOfLines.add(sc.nextLine());
			} catch (Exception e){
				;
			}
		}
		sc.close();
		return ArrayOfLines;
    }
    public static File createTxtFile(String FileName){
		File file = null;
		try{
			File f = new File(FileName + ".txt");
			file = f;
			if (f.createNewFile()){
				;
			} else{
				;
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		return file;
    }
    public static void openFile(File File) throws AWTException{
		try{
			Desktop desktop = Desktop.getDesktop();
			desktop.open(File);
            } 
        catch(Exception e){
			e.printStackTrace();
		}
	}
}