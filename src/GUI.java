import javax.swing.*;
import java.awt.event.*;

public class GUI{
    static String defaultMessage = "What are the number of groups? Replace this text with only the number of groups.";
    public static void gui(){
        JFrame frame = new JFrame("Virtual School Utility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        JButton GroupsButton=new JButton("Click Here to Make Random Groups");
        GroupsButton.setBounds(50,50,300, 50);  
        frame.add(GroupsButton);
        JButton PromptsButton=new JButton("Click Here to Get A Random Prompt Today");
        PromptsButton.setBounds(50,110,300, 50);  
        frame.add(PromptsButton);
        JTextField txtInput = new JTextField(defaultMessage);
        GroupsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtInput.setText("Ok Button is clicked here");
            }
        });
        PromptsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtInput.setText("Ok Button is clicked here");
            }
         });
        frame.getContentPane().add(txtInput);
        txtInput.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                String input = txtInput.getText();
                String[] tuple = input.split(",");
                JOptionPane.showMessageDialog(null,tuple[0],"Output",JOptionPane.PLAIN_MESSAGE);
                txtInput.setText(defaultMessage);
           }
        });
        frame.setVisible(true);
    }
}
