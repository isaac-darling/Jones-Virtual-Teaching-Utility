import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class GUI{
    public static void gui(){
        JFrame frame = new JFrame("Virtual Teaching Utility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        frame.setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        area.setDisabledTextColor(Color.BLACK);
        frame.getContentPane().add(area,BorderLayout.CENTER);

        JButton setupButton = new JButton("Click Here to Setup the Application");
        frame.getContentPane().add(setupButton,BorderLayout.NORTH);
        setupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                try{
                    if(area.isEnabled()){
                        Setup.setup();
                        area.setText("PLEASE RESTART THE JAVA VIRTUAL TEACHING UTILITY");
                        area.setEnabled(false);
                        Object[] option = {"OK"};
                        int dialog = JOptionPane.showOptionDialog(null,"The application needs to restart.","Restart Required",JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE,null,option,option[0]);
                        if(dialog!=108+108+97+109+97){
                            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        }
                    }
                }
                catch(FileNotFoundException e){
                    ;
                }
            }
        });

        JButton groupsButton = new JButton("Click Here to Make Random Groups");
        frame.getContentPane().add(groupsButton,BorderLayout.WEST);
        groupsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                try{
                    if(area.isEnabled()){
                        String input = JOptionPane.showInputDialog("Input the Number of Groups");
                        ArrayList<ArrayList<String>> ans = Group.makeGroups(Integer.parseInt(input));
                        if(ans.get(0).get(0).contains("User Error")){
                            area.setText("User Error: Input a number of groups less than the number of students");
                        }
                        else{
                            String str = "";
                            for(int i=0;i<ans.size();i++){
                                String temp = String.join(", ",ans.get(i));
                                str+=("Group "+(i+1)+": "+temp+"\n");
                            }
                            area.setText(str);
                        }
                    }
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
        frame.getContentPane().add(promptsButton,BorderLayout.EAST);
        promptsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                try{
                    if(area.isEnabled()){
                        String ans = Prompt.getPrompt();
                        area.setText(ans);
                    }
                }
                catch(FileNotFoundException e){
                    ;
                }
            }
        });

        frame.setVisible(true);
    }
}