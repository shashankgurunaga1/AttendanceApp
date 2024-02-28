import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;



public class Attendance extends JFrame {
    private String names[] = { "Aditya", "Aman", "Rahul", "Vidhyan","Choraka"};
    private int count=0;
    private ArrayList<String> arr1=new ArrayList<>();
    private JCheckBox boxes[];  //CheckBox array
    JPanel airPanel=new JPanel();
    JPanel newairPanel=new JPanel();
    JLabel presenceLabel=new JLabel();
    private JLabel notwelcomLabel[]=new JLabel[10];

    //Checkbox creation for elements of an array
    public void createCheckBox(int i){
        boxes[i]=new JCheckBox(names[i]);
        boxes[i].setBorder(new EmptyBorder(0,i*30,0,0));
        airPanel.add(boxes[i]);

        // notwelcomLabel2=new JLabel();
       
        
        //
    }
    
    public void count(int i)
    {
        boxes[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s=boxes[i].getText();
                if(boxes[i].isSelected() && !arr1.contains(s)){
                  arr1.add(s);
                  count++;
                  //notwelcomLabel[0]=new JLabel(count+" "+arr1);
                  //notwelcomLabel[i].setText(s+" "+count);
                
                  notwelcomLabel[i]=new JLabel(count+". "+s);
                  newairPanel.add(notwelcomLabel[i]);
                  newairPanel.revalidate();
                  //presenceLabel.setText("Hello");
                }
                if(!boxes[i].isSelected()  && arr1.contains(s)){
                    arr1.remove(s);
                    count--;
                }
            }
            
            
        });
    }

    


    

    public void start(){
      
      JLabel welcomel=new JLabel("Check the students of class CSE");
      boxes=new JCheckBox[names.length];
      for(int i=0;i<names.length;i++){
          createCheckBox(i);
      }
    
      for(int i=0;i<names.length;i++){
       
        count(i);
        
    }
      /*form panel */

      JPanel formPanel=new JPanel();
      formPanel.setLayout(new GridLayout(names.length,names.length,3,3));
      formPanel.add(welcomel);
      formPanel.add(airPanel);
     

      /*main panel */
      JPanel mainPanel=new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(formPanel,BorderLayout.NORTH);
      mainPanel.add(newairPanel,BorderLayout.CENTER);
      add(mainPanel);
        setTitle("Welcome to the attendace app");
        setSize(900,900);
        setMinimumSize(new Dimension(300,400)); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
    }



    public static void main(String[] args){
              Attendance a=new Attendance();
              a.start();
    }

   
}
