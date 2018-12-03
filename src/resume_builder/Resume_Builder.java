package resume_builder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import connection.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.sql.*;


public class Resume_Builder extends JFrame {
   public  static BasicDetail base;
   
   public  static Resume_Builder resume;
  
   public static employer emp;
   public static String id;
   
    
   boolean sign_toggle = true;
    employer e1;
    
    String C_id;
   
    
    JPanel P_left;
    JPanel P_right;
    JLabel Label1_left;
    //JLabel Label2_left;
    JLabel Label2_right;
    JLabel Label3_right;    
    JLabel Label4_right; 
    JLabel l_cname;
    JLabel l_pass;
    JLabel l_cpass;
    
    
    JTextField txtUsername;
    JTextField txtId;
    JTextField C_name;    
    JPasswordField C_pass;
    JPasswordField C_cpass;
    
    JPasswordField txtPass;
    
    JButton btnLogin;
    JButton signUp;
    JButton createResume;
    JButton open;
    JButton sign_up;
    
    ResultSet rs;

    Resume_Builder()
    {
        super("Welcome to resume Builder");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        setBounds(200,50,1000,600);
        setResizable(false);
        //setResizable(false);
        
        P_left = new JPanel();
        P_left.setBorder(BorderFactory.createRaisedBevelBorder());
        
        P_right = new JPanel();
        P_right.setBorder(BorderFactory.createRaisedBevelBorder());
        
        P_left.setSize(500,600);
        P_right.setSize(500,600);
        
        P_left.setLayout(null);
        P_right.setLayout(null);
        
         
        add(P_left);
        add_Company();
        add(P_right);
        add_individial();
        setVisible(true);
        
        
    }
    
    //panel of left side
    void add_Company()
    {
        
        Label1_left = new JLabel();
        Label1_left.setText("COMPANY");
        Label1_left.setForeground(Color.BLUE);
        Label1_left.setFont(new java.awt.Font("Default", 1, 18));
        Label1_left.setBounds(190, 30, 120, 20);        
        P_left.add(Label1_left);       
        
        txtUsername = new JTextField();
        txtUsername.setText("Enter Username");
        txtUsername.setBounds(150,130,200,30);
        P_left.add(txtUsername);
        txtUsername.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                txtUsername.setText("");
            }
            
        });
                
                
        txtPass = new JPasswordField();
        txtPass.setText("Enter Password");
        txtPass.setBounds(150,170,200,30);
        P_left.add(txtPass);
        txtPass.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                txtPass.setText("");
            }
            
        });
        
        
        btnLogin = new JButton();
        btnLogin.setText("Login");
        btnLogin.setBounds(150,220,90,30);
        P_left.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                if(txtUsername.getText().trim().equals("") || txtPass.getText().trim().equals(""))
                {   
                    JOptionPane.showMessageDialog(rootPane,"Enter login/password fields !");
                    return;
                }
                try
                { 

                Connect.getConnection();
                String LoginQuery = "select username from company where username =  '"+txtUsername.getText().trim()+"' and password = '"+txtPass.getText()+"'" ;                              
                rs = Connect.st.executeQuery(LoginQuery);
                    if(rs.next())
                    { 
                       new CompanySearch();
                       setVisible(false);
                       JOptionPane.showMessageDialog(rootPane,"Welcome "+ rs.getString(1)+ "");   
 
                    }
                    else
                    {
                         JOptionPane.showMessageDialog(rootPane,"Invalid Username/Password");   
                                         
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                finally
                {
                    try
                    {    
                    rs.close();
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e);
                    }
                }

                
            }
        });
        
        //signUp button
        signUp = new JButton();
        signUp.setText("Sign Up");
        signUp.setBounds(260,220,90,30);
        P_left.add(signUp);        
        signUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                //shows panel of signup 
                add_signUp();
            }    
      
                     
        });         
        

     
    }
    
    //shows panel of sign botton left
    public void add_signUp()
    {   
        //sign up panel at bottom left side
        final JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("Sign Up"));
        p2.setVisible(sign_toggle);
        P_left.add(p2);
        
        // FlowLayout f1 = new FlowLayout();
       // f1.setAlignment(FlowLayout.LEFT);
        p2.setLayout(null);
        p2.setBounds(125, 290, 250, 160);
                     
           
            
            l_cname = new JLabel( "Username :");
            p2.add(l_cname);       
            l_cname.setBounds(5,25 , 105, 25);
            
            C_name = new JTextField("Company name ");
            p2.add(C_name);
            C_name.setBounds(120,25 , 105, 25);
            C_name.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                C_name.setText("");
            }
            
           });
        
          
         
            l_pass = new JLabel("Password :");
            l_pass.setBounds(5,60 , 105, 25);
            p2.add(l_pass);
                    
            C_pass = new JPasswordField("enter password");
            C_pass.setBounds(120,60 , 105, 25);
            p2.add(C_pass);
            C_pass.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                C_pass.setText("");
            }
            
        });
            
            
            l_cpass = new JLabel("Confirm Password :");
            l_cpass.setBounds(5,95,110, 25);
            p2.add(l_cpass);       
        
            C_cpass = new JPasswordField("enter password");
            p2.add(C_cpass);
            C_cpass.setBounds(120,95,105, 25);
            
            C_cpass.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                C_cpass.setText("");
            }
            
        });
            
          
            
            sign_up= new JButton("Sign up");
            p2.add(sign_up);
            sign_up.setBounds(50,130,120, 20);
            
            
            sign_up.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!C_cpass.getText().equals(C_pass.getText()))
                {
                    JOptionPane.showMessageDialog(rootPane,"Passwords Don't match !");
                    return;
                }
                
                if(C_name.getText().trim().equals("") || C_pass.getText().trim().equals("") || C_cpass.getText().trim().equals(""))
                {   
                    JOptionPane.showMessageDialog(rootPane,"Enter name/password fields !");
                    return;
                }
                
                if(!C_pass.getText().equals(C_cpass.getText()))
                {
                    JOptionPane.showMessageDialog(rootPane,"Passwords dont match");
                }

                
                //preparing id to the comapny in database
                int counter;
                
                //if table is empty insert 1st id
                Connect.getConnection();                 
                String nullTable = "select count(*) from company";
                try
                {
                    rs = Connect.st.executeQuery(nullTable);
                    rs.first();
                    counter = rs.getInt(1);

                    if(counter == 0)        //if table is empty insert 1st id
                    {
                      C_id = "10000";
                    }
                    else                    // next id if table has id
                    {   rs.close();
                        String nextId = "select id from company ";
                        rs = Connect.st.executeQuery(nextId);
                        rs.last();
                        String st = rs.getString(1);
                        counter = Integer.parseInt(st);
                        counter =  counter +1 ;
                        C_id = String.valueOf(counter);
                    }
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }

    
                try
                { 
                    
                    Connect.getConnection();
                    String companyEntry = "insert into company (id,username,password) values('"+C_id+"','"+C_name.getText().trim()+"','"+C_pass.getText()+"')";                                 

                    int row = Connect.st.executeUpdate(companyEntry);
                    if(row>0)
                    {
                        JOptionPane.showMessageDialog(rootPane, "Thanks for signing up!");
                        p2.setVisible(false);

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
        });
            
         
            
            
             
      sign_toggle = !sign_toggle;  
    }
    
    //shows panel of forgot pass in botton left
//    void add_ForgotPass()
//    {
//        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        p1.setBorder(BorderFactory.createTitledBorder("Enter e-mail ID "));
//        P_left.add(p1);
//        p1.setBounds(125, 290, 250, 160);
//        
//        JTextField email = new JTextField("     Email to send password    ");
//        p1.add(email);
//        JButton send = new JButton(" Send ");
//        
//        p1.add(send);
//    }
    
    //panel of right side
    public void add_individial()
    {
         Label2_right = new JLabel();
         Label2_right.setText("INDIVIDUAL");
         Label2_right.setForeground(Color.BLUE);
         Label2_right.setFont(new Font("Default", 1, 18));        
         Label2_right.setBounds(190, 30, 120, 20);         
         P_right.add(Label2_right);
         
         createResume = new JButton();
         createResume.setText("CREATE NEW RESUME");
         createResume.setBounds(125, 130,250, 60); 
         P_right.add(createResume);
         createResume.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
             
                 try
    {
        Connect.getConnection();
        String query = "select count(*) from person";
        ResultSet rs = Connect.st.executeQuery(query);
        rs.first();
        int count = rs.getInt(1);
        rs.close();
        if(count==0)
        {
            count=100;
            Resume_Builder.id=( String.valueOf(count));
        }
        else
        {
            String query1 = "select id from person";
            rs = Connect.st.executeQuery(query1);
            rs.last();
            Resume_Builder.id = (String.valueOf((Integer.parseInt(rs.getString(1)))+1));
            
        }
        }
    catch(Exception e)
    {
        System.out.println(e);
    }
              setVisible(false);
              base = new BasicDetail();
              base.setBounds(200,50,1000,600);
              base.setVisible(true);
              //dispose();
                
                
                
            }
        });
         
         Label3_right = new JLabel();
         Label3_right.setText("OR");
         Label3_right.setBounds(240, 230, 20, 20);
         P_right.add(Label3_right);
         
         
             JPanel p1 = new JPanel();
             p1.setLayout(null);
             p1.setBounds(125, 290, 250, 160);
             p1.setBorder(BorderFactory.createTitledBorder("View Saved Resume Or Change Format"));
             
             P_right.add(p1);
             
             txtId = new JTextField();
             txtId.setText("Enter Resume ID");
             txtId.setBounds(75,50,100,20);
             p1.add(txtId);
             txtId.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                txtId.setText("");
              

            }
            });
       

             open = new JButton();
             open.setText("Open");
             open.setBounds(75,80,100,20);
             p1.add(open);
             open.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtId.getText().trim().equals("") || txtId.getText().trim().equals("Enter Resume ID") )
                {   
                    JOptionPane.showMessageDialog(rootPane,"Enter Resume ID");
                    return;
                }
                  
                Resume_Builder.id = txtId.getText();
                
                Connect.getConnection();                 
                String personID = "select id from person where id = '"+id+"'";
                try
                {
                    rs = Connect.st.executeQuery(personID);
                   

                    if(rs.next())        //if table person has id in it
                    {
                        
                        System.out.println("id is valid1");                        
                        Last last0 = new Last();
                        last0.setBounds(0,0,1000,600);
                        setLayout(null);
                        setBounds(200,50,1000,600);
                        add(last0);
                        //System.out.println("id is valid2");                        
                        
                                               
                        P_left.setVisible(false);
                        //System.out.println("id is valid3");                        
                        P_right.setVisible(false);
                        
                       // System.out.println("id is valid4"); 
                        last0.setVisible(true);
                        //System.out.println("id is valid5"); 
                      
                    }
                    else                    //if id is not there
                    { 
                        JOptionPane.showInternalMessageDialog(rootPane ,"No such ID found , please enter a valid ID");
                    }
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }
                     
                    
                        
            }
      
        });
         
         
         
    }
    public static void main(String args[]){
          resume = new Resume_Builder();
    }
    
}
