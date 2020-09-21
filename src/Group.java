import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;

public class Group{
    public static ArrayList<ArrayList<String>> makeGroups(int groupCount) throws FileNotFoundException{
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        File file = Tool.createTxtFile(Setup.platformDrive()+"/Users/"+System.getProperty("user.name")+"/Documents/JavaTeachingUtility/roster");
        try{
            ArrayList<String> rosterList = Tool.readFileToArray(file);
            String[] roster = new String[rosterList.size()];
            rosterList.toArray(roster);
            Collections.shuffle(Arrays.asList(roster));
            int mod = roster.length%groupCount;
            if(mod==roster.length){
                for(int i=0;i<roster.length;i++){
                    ArrayList<String> arr = new ArrayList<String>();
                    arr.add("User Error: Input a number of groups less than the number of students");
                    ans.add(arr);
                }
                return ans;
            }
            int per = (roster.length-mod)/groupCount;
            int count = 0;
            int offset = 0;
            for(int i=0;i<groupCount;i++){
                ArrayList<String> group = new ArrayList<String>();
                for(int j=0;j<per;j++){
                    group.add(roster[(j+(per*count))+offset]);
                    if(mod>0&&j==per-1){
                        group.add(roster[(j+(per*count))+offset+1]);
                        mod--;
                        offset++;
                    }
                }
                ans.add(group);
                count++;
            }
            return ans;
        }
        catch(FileNotFoundException e){
            System.out.println("Fatal Error: "+e);
            return ans;
        }
    }
}