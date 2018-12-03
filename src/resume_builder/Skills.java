
package resume_builder;

import connection.Connect;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Skills extends JPanel implements ActionListener{
    
    int counter=0 ;
    JButton next;
    JButton previous;
    JLabel page;
    JTextField skill1;
    JTextField skill2;
    JTextField skill3;
    JTextField skill4;
    JPanel skillPanel;
    JPanel strengthPanel;
    JTextField strength1;
    JTextField strength2;
    JTextField strength3;
    JTextField strength4;
    JLabel idLabel;
    
    
    
   public Skills()
   {
        setLayout(null);
        setBounds(200,50,1000,600);
        setBorder(BorderFactory.createTitledBorder("Skills And Strengths"));
        
        idLabel = new JLabel("Id : "+Resume_Builder.id);
        idLabel.setBounds(800,10,100,25);
        idLabel.setFont(new java.awt.Font("Default", 1,18 ));
        idLabel.setForeground(Color.BLUE);
        add(idLabel);
        
        
        skillPanel = new JPanel();
        skillPanel.setBorder(BorderFactory.createTitledBorder("Enter Your Skills"));
        skillPanel.setBounds(50,70,900,200);
        skillPanel.setVisible(true);
        skillPanel.setBackground(Color.WHITE);
        add(skillPanel);
        
        
        skill1 = new JTextField(50);
        skill1.setForeground(Color.LIGHT_GRAY);
        skill1.setText("Skill 1 (Optional)");
        skill1.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            skill1.setText("");
            skill1.setForeground(Color.BLACK);
            
        }
        });
         skillPanel.add(skill1);
        
        skill2 = new JTextField(50);
         skill2.setForeground(Color.LIGHT_GRAY);
        skill2.setText("Skill 2 (Optional)");
        skill2.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            skill2.setText("");
            skill2.setForeground(Color.BLACK);
            
        }
        });
         skillPanel.add(skill2);
        
        skill3 = new JTextField(50);
        skill3.setForeground(Color.LIGHT_GRAY);
        skill3.setText("Skill 3 (Optional)");
        skill3.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            skill3.setText("");
            skill3.setForeground(Color.BLACK);
            
        }
        });
        
        skillPanel.add(skill3);
        
        skill4 = new JTextField(50);
        skill4.setForeground(Color.LIGHT_GRAY);
        skill4.setText("Skill 4 (Optional)");
        skill4.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            skill4.setText("");
            skill4.setForeground(Color.BLACK);
            
        }
        });
         skillPanel.add(skill4);
         
         
        strengthPanel = new JPanel();
        strengthPanel.setBorder(BorderFactory.createTitledBorder("Enter Your Strengths"));
        strengthPanel.setBounds(50,300,900,200);
         strengthPanel.setVisible(true);
        strengthPanel.setBackground(Color.WHITE);
        add(strengthPanel);
        
        
        strength1 = new JTextField(50);
        strength1.setForeground(Color.LIGHT_GRAY);
        strength1.setText("Strength 1 (Optional)");
        strength1.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            strength1.setText("");
            strength1.setForeground(Color.BLACK);
            
        }
        });
         strengthPanel.add(strength1);
        
        strength2 = new JTextField(50);
         strength2.setForeground(Color.LIGHT_GRAY);
        strength2.setText("Strength 2 (Optional)");
        strength2.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            strength2.setText("");
            strength2.setForeground(Color.BLACK);
            
        }
        });
         strengthPanel.add(strength2);
        
        strength3 = new JTextField(50);
        strength3.setForeground(Color.LIGHT_GRAY);
        strength3.setText("Strength 3 (Optional)");
        strength3.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            strength3.setText("");
            strength3.setForeground(Color.BLACK);
            
        }
        });
        
        strengthPanel.add(strength3);
        
        strength4 = new JTextField(50);
        strength4.setForeground(Color.LIGHT_GRAY);
        strength4.setText("Strength 4 (Optional)");
        strength4.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt)
        {
            strength4.setText("");
           strength4.setForeground(Color.BLACK);
            
        }
        });
         strengthPanel.add(strength4);
        
        page = new JLabel("3/7");
        page.setBounds(500,520,50,25);
        add(page);
        
        next = new JButton("Next");
        next.setBounds(860,520,100,25);
        next.addActionListener(this);
        add(next);
        
        previous = new JButton("Previous");
        previous.setBounds(755,520,100,25);
        previous.addActionListener(this);
        add(previous);
   }
   
    @Override
   public void actionPerformed(ActionEvent evt)
   {
        String cmd = evt.getActionCommand();
             
             if(cmd=="Next")
             {
                 if(counter==0)
                 {
                 if(!(skill1.getText().trim().equals("")||(skill1.getText().trim().equals("Skill 1 (Optional)"))))
                 {
                    insertskills();
                    if(!(strength1.getText().trim().equals("")||(strength1.getText().trim().equals("Strength 1 (Optional)"))))
                    {
                        insertstrengths();
                        
                    }
                    }
                    counter=1;
                   
                  }
                 else if(counter==1)
                 {
                      try
                {
                 String query5 ="delete from skills where id='"+Resume_Builder.id+"'"; 
                int row5 = Connect.st.executeUpdate(query5);
                if(row5>0)
                {

                  // counter=1;
                }
                
                String query6 ="delete from strengths where id='"+Resume_Builder.id+"'"; 
                int row6 = Connect.st.executeUpdate(query6);
                if(row6>0)
                {
                   //counter=1;
                }
                if(!(skill1.getText().trim().equals("")||(skill1.getText().trim().equals("Skill 1 (Optional)"))))
                {
                    insertskills();
                }
                if(!(strength1.getText().trim().equals("")||(strength1.getText().trim().equals("Strength 1 (Optional)"))))
                {
                    insertstrengths();
                }
               }         
    catch(Exception e)
    {
        System.out.println(e);
    } 
  }
                    setVisible(false);
                    Resume_Builder.base.add(Resume_Builder.base.emp);
                    Resume_Builder.base.emp.setVisible(true);
                     
}            
             
             else if(cmd=="Previous")
             {
             setVisible(false);
             Resume_Builder.base.edu.setVisible(true);
             }   
   }

   
   void insertskills()
    {
        try
            {
         String query1 = "insert into skills (id,skill) values ('"+Resume_Builder.id+"','"+skill1.getText()+"')";
        int row1 = Connect.st.executeUpdate(query1);
        if(row1>0)
        {
                   System.out.println("query 1 fine");
           
        }
        if(!(skill2.getText().trim().equals("")||(skill2.getText().trim().equals("Skill 2 (Optional)")))){
            String query2 = "insert into skills (id,skill) values ('"+Resume_Builder.id+"','"+skill2.getText()+"')";
        int row2 = Connect.st.executeUpdate(query2);
        if(row2>0)
        {
             System.out.println("query 2 fine");      
        }
        }
        if(!(skill3.getText().trim().equals("")||(skill3.getText().trim().equals("Skill 3 (Optional)"))))
        {
            String query3 = "insert into skills (id,skill) values ('"+Resume_Builder.id+"','"+skill3.getText()+"')";
        int row3 = Connect.st.executeUpdate(query3);
        if(row3>0)
        {
                   System.out.println("query 3 fine");
        }
        } 
        if(!(skill4.getText().trim().equals("")||(skill4.getText().trim().equals("Skill 4 (Optional)"))))
        {
            String query4 = "insert into skills (id,skill) values ('"+Resume_Builder.id+"','"+skill4.getText()+"')";
        int row4 = Connect.st.executeUpdate(query4);
        if(row4>0)
        {
                   System.out.println("query 4 fine");
        }
        } 
            }         
    catch(Exception e)
    {
        System.out.println(e);
    } 
        
    }
   
   
   public void insertstrengths()
   {
       try
            {
         String query1 = "insert into strengths (id,strength) values ('"+Resume_Builder.id+"','"+strength1.getText()+"')";
        int row1 = Connect.st.executeUpdate(query1);
        if(row1>0)
        {
                   System.out.println("strength 1 fine");
           
        }
        if(!(strength2.getText().trim().equals("")||(strength2.getText().trim().equals("Strength 2 (Optional)")))){
            String query2 = "insert into strengths (id,strength) values ('"+Resume_Builder.id+"','"+strength2.getText()+"')";
        int row2 = Connect.st.executeUpdate(query2);
        if(row2>0)
        {
             System.out.println("query 2 fine");      
        }
        }
        if(!(strength3.getText().trim().equals("")||(strength3.getText().trim().equals("Strength 3 (Optional)"))))
        {
            String query3 = "insert into strengths (id,strength) values ('"+Resume_Builder.id+"','"+strength3.getText()+"')";
        int row3 = Connect.st.executeUpdate(query3);
        if(row3>0)
        {
                   System.out.println("query 3 fine");
        }
        } 
        if(!(strength4.getText().trim().equals("")||(strength4.getText().trim().equals("Strength 4 (Optional)"))))
        {
            String query4 = "insert into strengths (id,strength) values ('"+Resume_Builder.id+"','"+strength4.getText()+"')";
        int row4 = Connect.st.executeUpdate(query4);
        if(row4>0)
        {
                   System.out.println("query 4 fine");
        }
        } 
            }         
    catch(Exception e)
    {
        System.out.println(e);
    } 
        
   }
   
   
}
