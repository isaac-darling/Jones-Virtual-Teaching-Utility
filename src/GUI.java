import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class GUI{
    static int num;
    public static void gui(){
        JFrame frame = new JFrame("Virtual Teaching Utility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);

        JButton setupButton = new JButton("Click Here to Setup the Application");
        frame.getContentPane().add(setupButton);
        setupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                try{
                    Setup.setup();
                }
                catch(FileNotFoundException e){
                    ;
                }
            }
        });
        JButton groupsButton = new JButton("Click Here to Make Random Groups");
        frame.getContentPane().add(groupsButton);
        groupsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                try{
                    String input = JOptionPane.showInputDialog("Input the Number of Groups");
                    ArrayList<ArrayList<String>> ans = Groups.makeGroups(Integer.parseInt(input));
                    String str = "";
                    for(int i=0;i<ans.size();i++){
                        String temp = String.join(", ",ans.get(i));
                        str+=("Group "+(i+1)+": "+temp+"\n");
                    }
                    area.setText(str);
                }
                catch(NumberFormatException e){
                    ;
                }
                catch(FileNotFoundException e){
                    ;
                }
            }
        });

        JButton promptsButton = new JButton("Click Here to Get a Random Prompt");
        frame.getContentPane().add(promptsButton);
        promptsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                try{
                    String ans = Prompts.getPrompt();
                    area.setText(ans);
                }
                catch(FileNotFoundException e){
                    ;
                }
            }
        });
        frame.getContentPane().add(area);
        frame.setVisible(true);
    }
}