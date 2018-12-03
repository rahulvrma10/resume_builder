package resume_builder;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import connection.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;

public class employer extends JPanel {
    
    String project;
    String f_date;
    String t_date;
    int counter = 0;
    
    JLabel l_empDetail;
    JLabel l_jobTitle;
    JLabel l_from;
    JLabel l_to;
    JLabel l_msg;
    JLabel page;
    
    JSeparator j1 ;
    JSeparator j2;
    JSeparator j3;
    JSeparator j4;
    
    JTextArea t_empDetail1;
    JTextArea t_empDetail2;
    JTextArea t_empDetail3;
    JTextArea t_jobTitle1;
    JTextArea t_jobTitle2;
    JTextArea t_jobTitle3;
    
    JTextField f_year1;
    JTextField f_year2;
    JTextField f_year3;
    JTextField t_year1;
    JTextField t_year2;
    JTextField t_year3;
    
    JComboBox f_month1;
    JComboBox f_month2;
    JComboBox f_month3;
    JComboBox t_month1;
    JComboBox t_month2;
    JComboBox t_month3;
    
    JButton b_next;
    JButton b_prev;

  
    employer() {
        setLayout(null);
        //setVisible(true); // deleete afterwords ------------------------------------- 

        setBorder(BorderFactory.createTitledBorder("Enter Details of your recent employee :"));

       
                
        page = new JLabel("4/7");
        page.setBounds(500,520,50,25);
        add(page);
        
        l_empDetail = new JLabel("List your Employee :");
        l_empDetail.setFont(new Font("Default", 1, 18));
        l_empDetail.setForeground(Color.BLUE);
        add(l_empDetail);
        l_empDetail.setBounds(15, 125, 210, 25);

        t_empDetail1 = new JTextArea();
        add(t_empDetail1);
        t_empDetail1.setBounds(225, 40, 240, 220);
        t_empDetail1.setLineWrap(true);


        t_empDetail2 = new JTextArea();
        add(t_empDetail2);
        t_empDetail2.setBounds(480, 40, 240, 220);
        t_empDetail2.setLineWrap(true);

        t_empDetail3 = new JTextArea();
        add(t_empDetail3);
        t_empDetail3.setBounds(735, 40, 240, 220);
        t_empDetail3.setLineWrap(true);

        l_jobTitle = new JLabel("Job Description");
        l_jobTitle.setFont(new Font("Default", 1, 18));
        l_jobTitle.setForeground(Color.BLUE);
        add(l_jobTitle);
        l_jobTitle.setBounds(15, 300, 210, 80);

        t_jobTitle1 = new JTextArea();
        add(t_jobTitle1);
        t_jobTitle1.setBounds(225, 285, 240, 80);
        t_jobTitle1.setLineWrap(true);

        t_jobTitle2 = new JTextArea();
        add(t_jobTitle2);
        t_jobTitle2.setBounds(480, 285, 240, 80);
        t_jobTitle2.setLineWrap(true);

        t_jobTitle3 = new JTextArea();
        add(t_jobTitle3);
        t_jobTitle3.setBounds(735, 285, 240, 80);
        t_jobTitle3.setLineWrap(true);

        String[] t_month = new String[]{"Till Date","January", "February", "March", "April", "May", "June", "July", "August", "Setembper", "October", "November", "December"};

        String[] f_month = new String[]{"--select--","January", "February", "March", "April", "May", "June", "July", "August", "Setembper", "October", "November", "December"};
        
        l_from = new JLabel("From Date");
        add(l_from);
        l_from.setFont(new Font("Default", 1, 18));
        l_from.setForeground(Color.BLUE);
        l_from.setBounds(15, 390, 150, 25);

              
        j3 = new JSeparator();
        j3.setOrientation(SwingConstants.VERTICAL);
        j3.setBounds(217,20 , 2, 470);
        add(j3); 
        
        f_month1 = new JComboBox();
        f_month1.setModel(new DefaultComboBoxModel(f_month));
        add(f_month1);
        f_month1.setBounds(225, 390, 120, 25);
        
        
        j1 = new JSeparator();
        j1.setOrientation(SwingConstants.VERTICAL);
        j1.setBounds(472,20 , 2, 470);
        add(j1);


        f_month2 = new JComboBox();
        f_month2.setModel(new DefaultComboBoxModel(f_month));
        add(f_month2);
        f_month2.setBounds(480, 390, 120, 25);
        
        j2 = new JSeparator();
        j2.setOrientation(SwingConstants.VERTICAL);
        j2.setBounds(727,20, 2, 470);
        add(j2);


        f_month3 = new JComboBox();
        f_month3.setModel(new DefaultComboBoxModel(f_month));
        add(f_month3);
        f_month3.setBounds(735, 390, 120, 25);
           
        j4 = new JSeparator();
        j4.setOrientation(SwingConstants.VERTICAL);
        j4.setBounds(983,20, 2, 470);
        add(j4);


        f_year1 = new JTextField("yyyy");
        add(f_year1);
        f_year1.setBounds(365, 390, 40, 25); //365,380,40,25
        f_year1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                f_year1.setText("");
            }
        });

        f_year2 = new JTextField("yyyy");
        add(f_year2);
        f_year2.setBounds(620, 390, 40, 25);
        f_year2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                f_year2.setText("");
            }
        });

        f_year3 = new JTextField("yyyy");
        add(f_year3);
        f_year3.setBounds(875, 390, 40, 25);
        f_year3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                f_year3.setText("");
            }
        });

        l_to = new JLabel("To Date");
        add(l_to);
        l_to.setFont(new Font("Default", 1, 18));
        l_to.setForeground(Color.BLUE);
        l_to.setBounds(15, 430, 150, 25);


        t_month1 = new JComboBox();
        t_month1.setModel(new DefaultComboBoxModel(t_month));
        add(t_month1);
        t_month1.setBounds(225, 430, 120, 25);

        t_month2 = new JComboBox();
        t_month2.setModel(new DefaultComboBoxModel(t_month));
        add(t_month2);
        t_month2.setBounds(480, 430, 120, 25);

        t_month3 = new JComboBox();
        t_month3.setModel(new DefaultComboBoxModel(t_month));
        add(t_month3);
        t_month3.setBounds(735, 430, 120, 25);

        t_year1 = new JTextField("");
        add(t_year1);
        t_year1.setBounds(365, 430, 40, 25);
        t_year1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t_year1.setText("");
            }
        });

        t_year2 = new JTextField("");
        add(t_year2);
        t_year2.setBounds(620, 430, 40, 25);
        t_year2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t_year2.setText("");
            }
        });

        t_year3 = new JTextField("");
        add(t_year3);
        t_year3.setBounds(875, 430, 40, 25);
        t_year3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t_year3.setText("");
            }
        });
        
        
        b_next = new JButton("Next");
        b_next.setBounds(860, 520,100, 25);
        add(b_next);
        
        l_msg = new JLabel("");
        
        b_next.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            
            add(l_msg);
            l_msg.setFont(new Font("Default", -2, 15));
            l_msg.setForeground(Color.red);
            l_msg.setBounds(218, 525,200, 25);
            
            
            if(t_empDetail1.getText().trim().equals("")||t_jobTitle1.getText().trim().equals("")
                        ||(f_year1.getText().trim().equals("yyyy") || f_year1.getText().trim().equals(""))
                        ||f_month1.getSelectedItem().equals("--select--"))
                {   
                     if(!(t_empDetail1.getText().trim().equals(""))||!(t_jobTitle1.getText().trim().equals(""))
                        ||(!(f_year1.getText().trim().equals("yyyy") || f_year1.getText().trim().equals("")))
                        ||!(f_month1.getSelectedItem().equals("--select--")))
                     {
                          System.out.println("enter all fields in 1 block");
                          l_msg.setText("enter all fields in 1st block");
                          return;
                     }
                    
                   
                }
                
              if(t_empDetail2.getText().trim().equals("")||t_jobTitle2.getText().trim().equals("")
                        ||(f_year2.getText().trim().equals("yyyy") || f_year2.getText().trim().equals(""))
                        ||f_month2.getSelectedItem().equals("--select--"))
                {   
                     if(!(t_empDetail2.getText().trim().equals(""))||!(t_jobTitle2.getText().trim().equals(""))
                        ||(!(f_year2.getText().trim().equals("yyyy") || f_year2.getText().trim().equals("")))
                        ||!(f_month2.getSelectedItem().equals("--select--")))
                     {
                          System.out.println("enter all fields in 2 block");
                          l_msg.setText("enter all fields in 2nd block");
                          return;
                     }
                    
                   
                }
              
                  if(t_empDetail3.getText().trim().equals("")||t_jobTitle3.getText().trim().equals("")
                        ||(f_year3.getText().trim().equals("yyyy") || f_year3.getText().trim().equals(""))
                        ||f_month3.getSelectedItem().equals("--select--"))
                {   
                     if(!(t_empDetail3.getText().trim().equals(""))||!(t_jobTitle3.getText().trim().equals(""))
                        ||(!(f_year3.getText().trim().equals("yyyy") || f_year3.getText().trim().equals("")))
                        ||!(f_month3.getSelectedItem().equals("--select--")))
                     {
                          System.out.println("enter all fields in 3 block");
                          l_msg.setText("enter all fields in 3rd block");
                          return;
                     }
                    
                   
                }
                
                
                
               insertOnCheck();
                        
               setVisible(false);
               Resume_Builder.base.add(Resume_Builder.base.project);
               Resume_Builder.base.project.setVisible(true);
                
                  
            }
        
        });


        b_prev = new JButton("Previous");
        b_prev.setBounds(755,520,100,25);
        add(b_prev);
        b_prev.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               setVisible(false);
               Resume_Builder.base.add(Resume_Builder.base.skill);
               Resume_Builder.base.skill.setVisible(true);
             }
        });






    }
    
    void insertOnCheck()
    {
             if(counter ==0)
                {
                    insert();
                    counter = 1;
//                    
                     System.out.println("fields saved in database ");
                                
                }
                 
                else if(counter ==1)
                {
                    try
                    { 

                            Connect.getConnection();
                            project = "delete from experience where id ='"+Resume_Builder.id+"'";                                 

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
    }

    void insert()
    {
        
            if(!t_empDetail1.getText().trim().equals("")) // if t_empDetail1 filled insert into experience table
                    {
                        f_date = ""+f_month1.getSelectedItem()+" "+f_year1.getText()+"";
                                
                        t_date =""+t_month1.getSelectedItem()+" "+t_year1.getText()+"";

                        try
                        { 

                            Connect.getConnection();
                            project = "insert into experience (id,job,f_date,t_date,employer) values('"+Resume_Builder.id+"','"+t_jobTitle1.getText()+"','"+f_date+"','"+t_date+"','"+t_empDetail1.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                               System.out.println("employe entered 1");
                                

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

             if(!t_empDetail2.getText().trim().equals("")) // if panel 2 filled insert into project table
             {
                 f_date = ""+f_month2.getSelectedItem()+""+f_year2.getText()+"";
                 t_date =""+t_month2.getSelectedItem()+""+t_year2.getText()+"";

                        try
                        { 

                            Connect.getConnection();
                            project = "insert into experience (id,job,f_date,t_date,employer) values('"+Resume_Builder.id+"','"+t_jobTitle2.getText()+"','"+f_date+"','"+t_date+"','"+t_empDetail2.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                                System.out.println("employe entered 2");
                               

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
              if(!t_empDetail3.getText().trim().equals("")) // if panel 2 filled insert into project table
             {
                 f_date = ""+f_month3.getSelectedItem()+""+f_year3.getText()+"";
                 t_date =""+t_month3.getSelectedItem()+""+t_year3.getText()+"";

                        try
                        { 

                            Connect.getConnection();
                            project = "insert into experience (id,job,f_date,t_date,employer) values('"+Resume_Builder.id+"','"+t_jobTitle3.getText()+"','"+f_date+"','"+t_date+"','"+t_empDetail3.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(project);
                            if(row>0)
                            {
                                System.out.println("employe entered 3");
                               

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
        
    } // ---- end of insert
        
}
