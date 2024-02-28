import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.ActionListener;

/*javax is used for standard extension packages */
/* java is used for core packages*/




public  class MainFrame extends JFrame{
    public void initialize(){
        JTextField txfirstName,txlastName;
        
        
        JLabel firstName=new JLabel("First Name");
        txfirstName=new JTextField();

        JLabel lastName=new JLabel("Last Name ");
        txlastName=new JTextField();




        JLabel  Welcome=new JLabel();

        /* creating a button inside the form */
            JButton butt=new JButton("Submit");
            butt.addActionListener(new ActionListener() {
                

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String fName=txfirstName.getText();
                    String lName=txlastName.getText();
                    Welcome.setText("Hi "+fName+" "+lName+"\n Welcome");
                }

            });
        /*sub panel */


        JPanel formpanel=new JPanel();
        formpanel.setLayout(new GridLayout(4,1,5,5));
        formpanel.add(firstName);
        formpanel.add(txfirstName);
        formpanel.add(lastName);
        formpanel.add(txlastName);

   /* Buttons panel */
       JPanel buttonsPanel=new JPanel();
       buttonsPanel.setLayout(new GridLayout(2,3,1,4));
       buttonsPanel.add(butt);


      /* main panel */
        JPanel myPanel=new JPanel();  //used for organizning multiple components
        myPanel.setLayout(new BorderLayout());//creating a layout within the window
       //adding formpanel into main panel
       myPanel.add(formpanel,BorderLayout.NORTH);
       myPanel.add(Welcome,BorderLayout.CENTER);
       myPanel.add(buttonsPanel,BorderLayout.SOUTH);



       add(myPanel);
        setTitle("Welcome");  //title of the sketch window
        setSize(500,500);  //size of the window
        setMinimumSize(new Dimension(300,400));  // minimum size of the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //   closing the constants
        setVisible(true);//important for making the window visible

    }
    public static void main(String[] args){
            MainFrame myFrame=new MainFrame();
            myFrame.initialize();
    }
}