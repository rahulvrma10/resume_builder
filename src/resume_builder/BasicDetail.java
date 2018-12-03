
package resume_builder;

import connection.Connect;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import resume_builder.BasicDetail.*;



public class BasicDetail extends JFrame implements ActionListener{
    
    public Education edu = new Education();
    public employer emp = new employer();
    public Skills skill = new Skills();
    public Project project = new Project();
    public references refer = new references();
    public static Last last = new Last();  //initialising last frame 
    
    public JPanel p1;
    private JLabel nameLabel;
    private JTextField name;
    private JLabel emailLabel;
    private JTextField email;
    private JLabel contactLabel;
    private JTextField contact;
    private JLabel addressLabel;
    private JTextArea address;
    private JLabel cityLabel;
    private JTextField city;
    private JSeparator separator;
    private JLabel jobTypeLabel;
    private JTextField jobType;
    private JLabel objectiveLabel;
    private JLabel hint1;
    private JTextArea objective;
    private JButton next;
    private JLabel page;
    private JLabel idLabel;
    private int counter = 0;
    
    
    public BasicDetail()
    {
        
        setBounds(200,50,1000,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        p1 = new JPanel();
        add(p1);
        p1.setVisible(true);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createTitledBorder("New Resume"));
        
        idLabel = new JLabel("Id : "+Resume_Builder.id);
        idLabel.setBounds(800,10,100,25);
        idLabel.setFont(new java.awt.Font("Default", 1,18 ));
        idLabel.setForeground(Color.BLUE);
        
        nameLabel = new JLabel("Name   ");
        nameLabel.setBounds(100,50,100,25);
        nameLabel.setFont(new java.awt.Font("Default", 1,18 ));
        nameLabel.setForeground(Color.BLUE);
        //nameLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        name = new JTextField(25);
        name.setBounds(300, 50, 300, 25);
        
        emailLabel = new JLabel("Email ID");
        emailLabel.setBounds(100,100,100,25);
        emailLabel.setFont(new java.awt.Font("Default", 1,18 ));
        emailLabel.setForeground(Color.BLUE);
         
        email = new JTextField(30);
        email.setBounds(300, 100, 300, 25);
        
        contactLabel = new JLabel("Contact No.");
        contactLabel.setBounds(100,150,120,25);
        contactLabel.setFont(new java.awt.Font("Default", 1,18 ));
        contactLabel.setForeground(Color.BLUE);
        
         contact = new JTextField(11);
         contact.setBounds(300, 150, 300, 25);
        
         addressLabel = new JLabel("Address");
         addressLabel.setBounds(100,200,100,25);
         addressLabel.setFont(new java.awt.Font("Default", 1,18 ));
         addressLabel.setForeground(Color.BLUE);
       
       
        address = new JTextArea(3,200);
        address.setBounds(300, 200, 300, 80);
        address.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        address.setLineWrap(true);
        
        cityLabel = new JLabel("City");
        cityLabel.setBounds(650,200,100,25);
        cityLabel.setFont(new java.awt.Font("Default", 1,18 ));
        cityLabel.setForeground(Color.BLUE);
        
        city = new JTextField(11);
        city.setBounds(700, 200, 200, 25);
        
        separator = new JSeparator();
        separator.setBounds(50,300,900,5);  
        
        jobTypeLabel = new JLabel("What kind of job you are interested in?");
        jobTypeLabel.setBounds(50,320,400,25);
        jobTypeLabel.setFont(new java.awt.Font("Default", 1,18 ));
        jobTypeLabel.setForeground(Color.BLUE);
        
        jobType = new JTextField(30);
        jobType.setBounds(500, 320, 300, 25);
        
        hint1 = new JLabel("eg. Software Developer");
        hint1.setBounds(500,360,200,20);
        hint1.setFont(new java.awt.Font("Italic", 5,15 ));
        hint1.setForeground(Color.BLUE);
        
        objectiveLabel = new JLabel("Career Objective");
        objectiveLabel.setBounds(50,400,400,25);
        objectiveLabel.setFont(new java.awt.Font("Default", 1,18 ));
        objectiveLabel.setForeground(Color.BLUE);
        
        objective = new JTextArea(3,400);
        objective.setBounds(500, 400,300,80);
        objective.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        objective.setLineWrap(true);
        
        next = new JButton("Next");
        next.setBounds(860,520,100,25);
        next.addActionListener(this);
        
        page = new JLabel("1/7");
        page.setBounds(500,520,50,25);

        
        p1.add(idLabel);
        p1.add(page);
        p1.add(next);
        p1.add(objective);
        p1.add(objectiveLabel);
        p1.add(hint1);
        p1.add(separator);
        p1.add(nameLabel);
        p1.add(name);
        p1.add(emailLabel);
        p1.add(email);
        p1.add(contactLabel);
        p1.add(contact);
        p1.add(addressLabel);
        p1.add(address);
        p1.add(jobTypeLabel);
        p1.add(jobType);
        p1.add(cityLabel);
        p1.add(city);
       
        setVisible(true);
        setTitle("RESUME BUILDER");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
     @Override
     public void actionPerformed(ActionEvent evt)
     {
         String cmd = evt.getActionCommand();
         if(cmd=="Next")
         {
           
             if(name.getText().trim().equals("")||email.getText().trim().equals("")||
                     contact.getText().trim().equals("")||address.getText().trim().equals("")||
                     city.getText().trim().equals("")||jobType.getText().trim().equals("")||
                     objective.getText().trim().equals(""))
             {
                 JOptionPane.showMessageDialog(rootPane,"Complete all fields");
                 return;
             }
             
           else
        {
            if(counter==0)
            { 
                //edu = new Education();
            try
            {
         String query = "insert into person (id,name,email,contact,address,state,job_type,objective) values ('"+Resume_Builder.id+"','"+name.getText()+"','"+email.getText()+"','"
                 +contact.getText()+"','"+address.getText()+"','"
                 +city.getText()+"','"+jobType.getText()+"','"+objective.getText()+"')";
        int row = Connect.st.executeUpdate(query);
        if(row>0)
        {
                   
           p1.setVisible(false);
           add(edu);
           edu.setVisible(true);
           counter=1;
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane,"Error Occured");
        }
            }         
    catch(Exception e)
    {
        System.out.println(e);
    } 
            }
        else if(counter==1)
        {
            try
            {
         String query = "update person set name='"+name.getText()+"',email='"+email.getText()+"',contact='"
                 +contact.getText()+"',address='"+address.getText()+"',state='"
                 +city.getText()+"',job_type='"+jobType.getText()+"',objective='"+objective.getText()+"' where id='"+Resume_Builder.id+"'";
        int row = Connect.st.executeUpdate(query);
        if(row>0)
        {
                   
           p1.setVisible(false);
           add(edu);
           edu.setVisible(true);
           counter=1;
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane,"Error Occured");
        }
            }         
    catch(Exception e)
    {
        System.out.println(e);
    } 
  }
            
 }
}            
         
         
     
}         

}
