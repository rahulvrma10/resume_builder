
package resume_builder;

import connection.Connect;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.SQLException;
import javax.swing.RootPaneContainer;

public class Project extends JPanel{
    String project;
    int counter = 0;
    
    JLabel j_name1;
    JLabel j_name2;
    JLabel j_name3;
    JLabel j_name4;
    JLabel j_details1;
    JLabel j_details2;
    JLabel j_details3;
    JLabel j_details4;
    JLabel page;
    
    JTextField t_name1;
    JTextField t_name2;
    JTextField t_name3;
    JTextField t_name4;
    JTextField t_detail1;
    JTextField t_detail2;
    JTextField t_detail3;
    JTextField t_detail4;
    
    JButton b_next;
    JButton b_prev;

    
    Project()
    {
        setLayout(null);
        //setVisible(true); // delete afterwords ------------------------------------- 
        setBorder(BorderFactory.createTitledBorder("Enter the projects undertaken"));
        
        page = new JLabel("5/7");
        page.setBounds(500,520,50,25);
        add(page);
        
        
        JPanel p1 = new JPanel();
        p1.setBounds(50, 50, 880,70);
        p1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        j_name1 = new JLabel("Name :");
        p1.add(j_name1);
        j_name1.setSize(100,25);
        j_name1.setFont(new Font("Default", 1, 18)); 
        j_name1.setForeground(Color.BLUE);
        
        t_name1 = new JTextField(70);
        p1.add(t_name1);
         add(p1);
         
        j_details1 = new JLabel("Details :");
        p1.add(j_details1);
        j_details1.setSize(100,25);
        j_details1.setFont(new Font("Default", 1, 18));
        j_details1.setForeground(Color.BLUE);
        
        t_detail1 = new JTextField(69);
        p1.add(t_detail1);
        add(p1);
        
        JPanel p2 = new JPanel();
        p2.setBounds(50,150, 880,70);
        p2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        j_name2 = new JLabel("Name :");
        p2.add(j_name2);
        j_name2.setSize(100,25);
        j_name2.setFont(new Font("Default", 1, 18)); 
        j_name2.setForeground(Color.BLUE);
        
        t_name2 = new JTextField(70);
        p2.add(t_name2);
         add(p1);
         
        j_details2 = new JLabel("Details :");
        p2.add(j_details2);
        j_details2.setSize(100,25);
        j_details2.setFont(new Font("Default", 1, 18)); 
        j_details2.setForeground(Color.BLUE);
        
        t_detail2 = new JTextField(69);
        p2.add(t_detail2);
        add(p2);

        
        JPanel p3 = new JPanel();
        p3.setBounds(50, 250, 880, 70);
        p3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        j_name3 = new JLabel("Name :");
        p3.add(j_name3);
        j_name3.setSize(100,25);
        j_name3.setFont(new Font("Default", 1, 18));  
        j_name3.setForeground(Color.BLUE);
        
        t_name3 = new JTextField(70);
        p3.add(t_name3);
         
        j_details3 = new JLabel("Details :");
        p3.add(j_details3);
        j_details3.setSize(100,25);
        j_details3.setFont(new Font("Default", 1, 18));
        j_details3.setForeground(Color.BLUE);
        
                t_detail3 = new JTextField(69);
        p3.add(t_detail3);
        add(p3);

        
        JPanel p4 = new JPanel();
        p4.setBounds(50, 350, 880, 70);
        p4.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        j_name4 = new JLabel("Name :");
        p4.add(j_name4);
        j_name4.setSize(100,25);
        j_name4.setFont(new Font("Default", 1, 18));
        j_name4.setForeground(Color.BLUE);
        
        t_name4 = new JTextField(70);
        p4.add(t_name4);
         
        j_details4 = new JLabel("Details :");
        p4.add(j_details4);
        j_details4.setSize(100,25);
        j_details4.setFont(new Font("Default", 1, 18));
        j_details4.setForeground(Color.BLUE);
        
        t_detail4 = new JTextField(69);
        p4.add(t_detail4);
        add(p4);
        
        b_next = new JButton("Next");
        b_next.setBounds(860, 520,100, 25);
        add(b_next);
        b_next.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                
                if(counter == 0) // insert into table project
                {

                    insert();
                    counter = 1; // ready for updation if user comes previous from next panel
                    System.out.println("fields saved in database ");
                    
                }
                
                else if(counter == 1) //--------------------------------------- ready for updation
                {
                    try
                        { 

                            Connect.getConnection();
                            project = "delete from project where id ='"+Resume_Builder.id+"'";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                                System.out.println("deleted fields n now updating fields in db ");
                                insert();
                                counter = 1; 
                                


                            }
                            else
                            {
                                insert();
                                System.out.println("nothing deleted , but fields inserted in db");
                            }
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                }
                   
                setVisible(false);
                Resume_Builder.base.add(Resume_Builder.base.refer);
                Resume_Builder.base.refer.setVisible(true);
                    
                
                

            }
        });


        b_prev = new JButton("Previous");
        b_prev.setBounds(755,520,100,25);
        add(b_prev);
        b_prev.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           
                setVisible(false);
                Resume_Builder.base.emp.setVisible(true);
            
            }
        });



        
        

    }
    
    void insert()
    {
        if(!t_name1.getText().trim().equals("")) // if panel 1 filled insert into project table
                    {
                        try
                        { 

                            Connect.getConnection();
                            project = "insert into project (id,name,details) values('"+Resume_Builder.id+"',' "+t_name1.getText()+"','"+t_detail1.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                                 System.out.println("project 1 ");

                            }
                            else
                            {
                                System.out.println("someting wrong");
                            }
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                    }

                    if(!t_name2.getText().trim().equals("")) // if panel 2 filled insert into project table
                    {
                        try
                        { 

                            Connect.getConnection();
                            project = "insert into project (id,name,details) values('"+Resume_Builder.id+"',' "+t_name2.getText()+"','"+t_detail2.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                                 System.out.println("project 2 ");
                            }
                            else
                            {
                                System.out.println("someting wrong");
                            }
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                    }

                    if(!t_name3.getText().trim().equals("")) // if panel 2 filled insert into project table
                    {
                        try
                        { 

                            Connect.getConnection();
                            project = "insert into project (id,name,details) values('"+Resume_Builder.id+"',' "+t_name3.getText()+"','"+t_detail3.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                                 System.out.println("project 3 ");
                            }
                            else
                            {
                                System.out.println("someting wrong");
                            }
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                    }

                    if(!t_name4.getText().trim().equals("")) // if panel 4 filled insert into project table
                    {
                        try
                        { 

                            Connect.getConnection();
                            project = "insert into project (id,name,details) values('"+Resume_Builder.id+"',' "+t_name4.getText()+"','"+t_detail4.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                                 System.out.println("project 4 ");

                            }
                            else
                            {
                                System.out.println("someting wrong");
                            }
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                    }
    }
    
}

