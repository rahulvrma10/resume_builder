package resume_builder;
import connection.Connect;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class Education extends JPanel implements ActionListener{
    
     
  //private  JLabel main;
  private  JLabel edu1Label1;
  private  JLabel edu1Label2;
  private  JLabel edu1Label3;
  private  JLabel edu1Label4;
  private  JLabel edu1Label5;
  private  JLabel edu2Label1;
  private  JLabel edu2Label2;
  private  JLabel edu2Label3;
  private  JLabel edu2Label4;
  private  JLabel edu2Label5;
  private  JLabel edu3Label1;
  private  JLabel edu3Label2;
  private  JLabel edu3Label3;
  private  JLabel edu3Label4;
  private  JLabel edu3Label5;
   private JTextField edu1univ;
  private  JTextField edu2univ;
   private JTextField edu3univ; 
  private  JTextField edu1degree;
   private JTextField edu2degree;
  private  JTextField edu3degree;
  private  JTextField edu1ins;
  private  JTextField edu2ins;
   private JTextField edu3ins;
private JTextField edu1marks;
private JTextField edu2marks;
private JTextField edu3marks;
private JTextField edu1year;
private JTextField edu2year;
private JTextField edu3year;
private JSeparator separator1;
private JSeparator separator2;
private JButton next;
private JButton previous;
private JLabel page;    
private JLabel idLabel;  
private int counter=0;
   
    
    public Education()
    {
        //System.out.println(Resume_builder.id);
        
        
        setBounds(200,50,1000,600);
        setBorder(BorderFactory.createTitledBorder("Education"));
        //setVisible(true);
        setLayout(null);
        
        idLabel = new JLabel("Id : "+Resume_Builder.id);
        idLabel.setBounds(800,10,100,25);
        idLabel.setFont(new java.awt.Font("Default", 5,18 ));
        idLabel.setForeground(Color.BLUE);
        add(idLabel);
        
//        main = new JLabel("Enter your Education in chronological order");
//        main.setBounds(50,10,500,25);
//        main.setFont(new java.awt.Font("Default", 1,18 ));
//        main.setForeground(Color.BLUE);
//        add(main);
        
        edu1Label1 = new JLabel("1. Board/University");
        edu1Label1.setBounds(100,50,200,25);
        edu1Label1.setFont(new java.awt.Font("Default", 5,18 ));
        edu1Label1.setForeground(Color.BLUE);
        add(edu1Label1);
        
        
        edu1univ = new JTextField((20));
        edu1univ.setBounds(300,50,200,25);
        add(edu1univ);
        
        edu1Label2 = new JLabel("Institute Name");
        edu1Label2.setBounds(550,50,200,25);
        edu1Label2.setFont(new java.awt.Font("Default", 5,18 ));
        edu1Label2.setForeground(Color.BLUE);
        add(edu1Label2);
        
        edu1ins = new JTextField(100);
        edu1ins.setBounds(700,50,200,25);
        add(edu1ins);
       
        
        edu1Label3 = new JLabel("Accomplishment");
        edu1Label3.setBounds(120,100,150,25);
        edu1Label3.setFont(new java.awt.Font("Default", 5,18 ));
        edu1Label3.setForeground(Color.BLUE);
        add(edu1Label3);
        
        edu1degree = new JTextField(20);
        edu1degree.setBounds(270,100,100,25);
        add(edu1degree);
        
        edu1Label4 = new JLabel("Yera of Completion");
        edu1Label4.setBounds(400,100,200,25);
        edu1Label4.setFont(new java.awt.Font("Default", 5,18 ));
        edu1Label4.setForeground(Color.BLUE);
        add(edu1Label4);
        
        edu1year = new JTextField(4);
        edu1year.setBounds(600,100,70,25);
        add(edu1year);
        edu1year.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent evt)
           {
               if(!Character.isDigit(evt.getKeyChar()))
    {
        evt.consume();   
    }
           }
        
        });
        
        
        edu1Label5 = new JLabel("Marks");
        edu1Label5.setBounds(700,100,100,25);
        edu1Label5.setFont(new java.awt.Font("Default", 5,18 ));
        edu1Label5.setForeground(Color.BLUE);
        add(edu1Label5);
        
        edu1marks = new JTextField(10);
        edu1marks.setBounds(800,100,100,25);
        add(edu1marks);
        edu1marks.addKeyListener(new KeyAdapter() {
           
        
        });
        
        
        separator1 = new JSeparator();
        separator1.setBounds(50,150,900,5);
        add(separator1);
        
        
        edu2Label1 = new JLabel("2. Board/University");
        edu2Label1.setBounds(100,200,200,25);
        edu2Label1.setFont(new java.awt.Font("Default", 5,18 ));
        edu2Label1.setForeground(Color.BLUE);
        add(edu2Label1);
        
        
        edu2univ = new JTextField((20));
        edu2univ.setBounds(300,200,200,25);
        add(edu2univ);
        
        edu2Label2 = new JLabel("Institute Name");
        edu2Label2.setBounds(550,200,200,25);
        edu2Label2.setFont(new java.awt.Font("Default", 5,18 ));
        edu2Label2.setForeground(Color.BLUE);
        add(edu2Label2);
        
        edu2ins = new JTextField(100);
        edu2ins.setBounds(700,200,200,25);
        add(edu2ins);
       
        
        edu2Label3 = new JLabel("Accomplishment");
        edu2Label3.setBounds(120,250,150,25);
        edu2Label3.setFont(new java.awt.Font("Default", 5,18 ));
        edu2Label3.setForeground(Color.BLUE);
        add(edu2Label3);
        
        edu2degree = new JTextField(20);
        edu2degree.setBounds(270,250,100,25);
        add(edu2degree);
        
        edu2Label4 = new JLabel("Yera of Completion");
        edu2Label4.setBounds(400,250,200,25);
        edu2Label4.setFont(new java.awt.Font("Default", 5,18 ));
        edu2Label4.setForeground(Color.BLUE);
        add(edu2Label4);
        
        edu2year = new JTextField(4);
        edu2year.setBounds(600,250,70,25);
        add(edu2year);
        edu2year.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent evt)
           {
               if(!Character.isDigit(evt.getKeyChar()))
    {
        evt.consume();   
    }
           }
        
        });
        
        edu2Label5 = new JLabel("Marks");
        edu2Label5.setBounds(700,250,100,25);
        edu2Label5.setFont(new java.awt.Font("Default", 5,18 ));
        edu2Label5.setForeground(Color.BLUE);
        add(edu2Label5);
        
        edu2marks = new JTextField(10);
        edu2marks.setBounds(800,250,100,25);
        add(edu2marks);
        
        separator2 = new JSeparator();
        separator2.setBounds(50,300,900,5);
        add(separator2);
        
        edu3Label1 = new JLabel("2. Board/University");
        edu3Label1.setBounds(100,350,200,25);
        edu3Label1.setFont(new java.awt.Font("Default", 5,18 ));
        edu3Label1.setForeground(Color.BLUE);
        add(edu3Label1);
        
        
        edu3univ = new JTextField((20));
        edu3univ.setBounds(300,350,200,25);
        add(edu3univ);
        
        edu3Label2 = new JLabel("Institute Name");
        edu3Label2.setBounds(550,350,200,25);
        edu3Label2.setFont(new java.awt.Font("Default", 5,18 ));
        edu3Label2.setForeground(Color.BLUE);
        add(edu3Label2);
        
        edu3ins = new JTextField(100);
        edu3ins.setBounds(700,350,200,25);
        add(edu3ins);
       
        
        edu3Label3 = new JLabel("Accomplishment");
        edu3Label3.setBounds(120,400,150,25);
        edu3Label3.setFont(new java.awt.Font("Default", 5,18 ));
        edu3Label3.setForeground(Color.BLUE);
        add(edu3Label3);
        
        edu3degree = new JTextField(20);
        edu3degree.setBounds(270,400,100,25);
        add(edu3degree);
        
        edu3Label4 = new JLabel("Yera of Completion");
        edu3Label4.setBounds(400,400,200,25);
        edu3Label4.setFont(new java.awt.Font("Default", 5,18 ));
        edu3Label4.setForeground(Color.BLUE);
        add(edu3Label4);
        
        edu3year = new JTextField(4);
        edu3year.setBounds(600,400,70,25);
        add(edu3year);
        edu3year.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent evt)
           {
               if(!Character.isDigit(evt.getKeyChar()))
    {
        evt.consume();   
    }
           }
        
        });
        
        edu3Label5 = new JLabel("Marks");
        edu3Label5.setBounds(700,400,100,25);
        edu3Label5.setFont(new java.awt.Font("Default", 5,18 ));
        edu3Label5.setForeground(Color.BLUE);
        add(edu3Label5);
        
        edu3marks = new JTextField(10);
        edu3marks.setBounds(800,400,100,25);
        add(edu3marks);
        
        next = new JButton("Next");
        next.setBounds(860,520,100,25);
        next.addActionListener(this);
        add(next);
        
        previous = new JButton("Previous");
        previous.setBounds(755,520,100,25);
        previous.addActionListener(this);
        add(previous);
        
        page = new JLabel("2/7");
        page.setBounds(500,520,50,25);
        add(page);
        
        
        
    }
    
    @Override
     public void actionPerformed(ActionEvent evt)
     {
         String cmd = evt.getActionCommand();
             
             if(cmd=="Next")
         {
           
             if(edu1univ.getText().trim().equals("")||edu1ins.getText().trim().equals("")||
                     edu1degree.getText().trim().equals("")||edu1year.getText().trim().equals("")||
                     edu1marks.getText().trim().equals(""))
             {
                 JOptionPane.showMessageDialog(this,"Add atleast one degree to your profile");
                 return;
             }
             else
              {
            if(counter==0)
            { 
                insert();
                Resume_Builder.base.add(Resume_Builder.base.skill);
                Resume_Builder.base.skill.setVisible(true);
                counter=1;
            
            }
        else if(counter==1)
        {
            try
            {
         String query4 ="delete from education where id='"+Resume_Builder.id+"'"; 
        int row4 = Connect.st.executeUpdate(query4);
        if(row4>0)
        {
                   
          setVisible(false);
           
           insert();
           Resume_Builder.base.add(Resume_Builder.base.skill);
           Resume_Builder.base.skill.setVisible(true);
           counter=1;
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Error Occured");
        }
            }         
    catch(Exception e)
    {
        System.out.println(e);
    } 
  }
            
 }
    }
         
         else if(cmd=="Previous")
         {
             setVisible(false);
             Resume_Builder.base.p1.setVisible(true);
             
         }
         
    
       }
    
    void insert()
    {
        try
            {
         String query1 = "insert into education (id,degree,year,marks,university,institute) values ('"+Resume_Builder.id+"','"+edu1degree.getText()+"','"+edu1year.getText()+"','"
                 +edu1marks.getText()+"','"+edu1univ.getText()+"','"
                 +edu1ins.getText()+"')";
        int row1 = Connect.st.executeUpdate(query1);
        if(row1>0)
        {
                   
           setVisible(false);
           
        }
        if(!edu2degree.getText().trim().equals("")){
            String query2 = "insert into education (id,degree,year,marks,university,institute) values ('"+Resume_Builder.id+"','"+edu2degree.getText()+"','"+edu2year.getText()+"','"
                 +edu2marks.getText()+"','"+edu2univ.getText()+"','"
                 +edu2ins.getText()+"')";
        int row2 = Connect.st.executeUpdate(query2);
        if(row2>0)
        {
                   
           setVisible(false);
           Resume_Builder.base.add(Resume_Builder.base.skill);
           Resume_Builder.base.skill.setVisible(true);
           counter=1;
        }
        }
        if(!edu3degree.getText().trim().equals(""))
        {
            String query3 = "insert into education (id,degree,year,marks,university,institute) values ('"+Resume_Builder.id+"','"+edu3degree.getText()+"','"+edu3year.getText()+"','"
                 +edu3marks.getText()+"','"+edu3univ.getText()+"','"
                 +edu3ins.getText()+"')";
        int row3 = Connect.st.executeUpdate(query3);
        if(row3>0)
        {
                   
           setVisible(false);
           Resume_Builder.base.add(Resume_Builder.base.skill);
           Resume_Builder.base.skill.setVisible(true);
           counter=1;
        }
        } 
            }         
    catch(Exception e)
    {
        System.out.println(e);
    } 
        
    }
    
   }

