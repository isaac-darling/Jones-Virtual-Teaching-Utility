import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;

public class Groups {
    public static ArrayList<ArrayList<String>> makeGroups(int groupCount){
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        //String input = "thing1\nthing2\nthing3\nthing4\nthing5\nthing6\nthing7";
        //String[] list = input.split("\n");
        File file = Tools.createTxtFile("roster");
        try{
            ArrayList<String> rosterList = Tools.readFileToArray(file);
            String[] roster = new String[rosterList.size()];
            rosterList.toArray(roster);
            Collections.shuffle(Arrays.asList(roster));
            int mod = roster.length%groupCount;
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
