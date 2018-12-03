/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resume_builder;

import connection.Connect;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.SQLException;
import javax.swing.JCheckBox;

public class references extends JPanel
{
    Boolean a = true;
            
       
    int counter = 0;
    String refer;
    int i = 1;
    
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    
       
    JButton b_next;
    JButton b_prev; 
    
    JLabel confirm;
    JLabel page;
    JCheckBox tick;
 
    
    references()
    {
    setLayout(null);
    //setVisible(true); // deleete afterwords ------------------------------------- 
    setBorder(BorderFactory.createTitledBorder("Enter your references:"));
    
     page = new JLabel("6/7");
     page.setBounds(500,520,50,25);
     add(page);
        
        
    JPanel p1 = new JPanel();
    p1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    add(p1);
    p1.setBounds(50,100,900,140);

    
    t1 = new JTextField(70);
    t1.setText("Reference No 1.(optional)");
    t1.setForeground(Color.lightGray);
    t1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t1.setForeground(Color.BLACK);
                t1.setText("");
            }
    });
         
    t2 = new JTextField(70);
    t2.setText("Reference No 2.(optional)");
    t2.setForeground(Color.lightGray);
    t2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t2.setForeground(Color.BLACK);
                t2.setText("");
            }
    });
    
    t3 = new JTextField(70);
    t3.setText("Reference No 3.(optional)");
    t3.setForeground(Color.lightGray);
    t3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t3.setForeground(Color.BLACK);
                t3.setText("");
            }
    });
    
    t4 = new JTextField(70);
    t4.setText("Reference No 4.(optional)");
    t4.setForeground(Color.lightGray);
    t4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t4.setForeground(Color.BLACK);
                t4.setText("");
            }
    });
    
    t5 = new JTextField(70);
    t5.setText("Reference No 5.(optional)");
    t5.setForeground(Color.lightGray);
    t5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                t5.setForeground(Color.BLACK);
                t5.setText("");
            }
    });
    
    confirm = new JLabel("NOTE : Please confirm all the previous fields before clicking next !");
    confirm.setForeground(Color.red);
    confirm.setBounds(100, 270, 800, 50);
    confirm.setFont(new Font("Default", 1,15));
    
    tick = new JCheckBox();
    tick.setBounds(70, 270, 20, 50);
    tick.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {         
            
            b_next.setEnabled(a);
            a = !a;
            
            }
            
        });
    
    p1.add(t1);
    p1.add(t2);
    p1.add(t3);
    p1.add(t4);
    p1.add(t5);
    add(confirm);
    add(tick);
    
     b_next = new JButton("Next");
     b_next.setBounds(860, 520,100, 25);
     add(b_next);
     b_next.setEnabled(false);
     b_next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(counter ==0)
                {
                    insert();
                    System.out.println("counter 0");
                    counter = 1; 
                                
                }
                 
                else if(counter ==1)
                {
                    try
                    { 

                            Connect.getConnection();
                            refer = "delete from reference where id ='"+Resume_Builder.id+"'";                                 

                            int row = Connect.st.executeUpdate(refer);
                            if(row>0)
                            {
                             
                                System.out.println("deleted, counter 1");
                                insert();
                                counter = 1; 
                                


                            }
                            else
                            {
                                insert();
                                System.out.println("added fields in database as thew were already empty");
                            }
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                }

                setVisible(false);
                Resume_Builder.base.add(Resume_Builder.base.last);
                Resume_Builder.base.last.setVisible(true);
                
                       
            }
        }); //-- end of button next ---------
     
     
     b_prev = new JButton("Back");
     b_prev.setBounds(755,520,100,25);
     add(b_prev);
     b_prev.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                setVisible(false);
                Resume_Builder.base.project.setVisible(true);
            }
        });

    
    
    }
    void insert()
    {
        
        if(!(t1.getText().trim().equals("") || t1.getText().equals("Reference No 1.(optional)")) ) // if t1 filled insert into experience table
                    {
                       
                        try
                        { 

                            Connect.getConnection();
                            refer = "insert into reference(id,reference) values('"+Resume_Builder.id+"','"+t1.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(refer);
                            if(row>0)
                            {
                               System.out.println("reference entered 1");
                                

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
        
        if(!(t2.getText().trim().equals("") || t2.getText().equals("Reference No 2.(optional)")) ) // if t2 filled insert into experience table
                    {
                       
                        try
                        { 

                            Connect.getConnection();
                            refer = "insert into reference(id,reference) values('"+Resume_Builder.id+"','"+t2.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(refer);
                            if(row>0)
                            {
                               System.out.println("reference entered 2");
                                

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
        
        if(!(t3.getText().trim().equals("") || t3.getText().equals("Reference No 3.(optional)")) ) // if t3 filled insert into experience table
                    {
                       
                        try
                        { 

                            Connect.getConnection();
                            refer = "insert into reference(id,reference) values('"+Resume_Builder.id+"','"+t3.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(refer);
                            if(row>0)
                            {
                               System.out.println("reference entered 3");
                                

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
        
        if(!(t4.getText().trim().equals("") || t4.getText().equals("Reference No 4.(optional)")) ) // if t4 filled insert into experience table
                    {
                       
                        try
                        { 

                            Connect.getConnection();
                            refer = "insert into reference(id,reference) values('"+Resume_Builder.id+"','"+t4.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(refer);
                            if(row>0)
                            {
                               System.out.println("reference entered 4");
                                

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
        
        if(!(t5.getText().trim().equals("") || t5.getText().equals("Reference No 5.(optional)"))) // if t5 filled insert into experience table
                    {
                       
                        try
                        { 

                            Connect.getConnection();
                            refer = "insert into reference(id,reference) values('"+Resume_Builder.id+"','"+t5.getText()+"')";                                 

                            int row = Connect.st.executeUpdate(refer);
                            if(row>0)
                            {
                               System.out.println("reference entered 5");
                                

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
        
    } // ---- end of insert ---
    
    
}
