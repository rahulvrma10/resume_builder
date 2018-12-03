
package resume_builder;

import connection.Connect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CompanySearch extends JFrame{
    
   
    JComboBox<String> combo1;
    JComboBox<String> combo2;
    JComboBox<String> combo3;
    JCheckBox check1;
    JCheckBox check2;
    JCheckBox check3;
    JPanel filter1;
    JPanel filter2;
    JPanel filter3;
    JSeparator separator1;
    JSeparator separator2;
    JButton search;
    JTable table;
    JScrollPane scroll;
    
    String s1;
    
    
    CompanySearch()
    {
        setBounds(200,50,1000,600);
        setVisible(true);
        setTitle("Resume Search");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
        public void windowOpened(ActionEvent ae)
        {
            
        }
        });
        
        
        filter1 = new JPanel();
        filter1.setBorder(BorderFactory.createTitledBorder("Job Type"));
        filter1.setBounds(50,50,200,100);
        filter1.setVisible(true);
        add(filter1);
        
        filter2 = new JPanel();
        filter2.setBorder(BorderFactory.createTitledBorder("Qualifacation     "));
        filter2.setBounds(400,50,200,100);
        filter2.setVisible(true);
        add(filter2);
        
        filter3 = new JPanel();
        filter3.setBorder(BorderFactory.createTitledBorder("City       "));
        filter3.setBounds(750,50,200,100);
        filter3.setVisible(true);
        add(filter3);
        
        check1 = new JCheckBox("Job Type                        ");
        filter1.add(check1);
        
        combo1 = new JComboBox<String>();
        combo1.addItem("Software Developer");
        combo1.addItem("Team Leader");
        combo1.addItem("HR Manager");
        combo1.addItem("Consultant");
        combo1.addItem("Teacher");
        filter1.add(combo1); 
        combo1.setEditable(true);
       
        
        check2 = new JCheckBox("Qualification             ");
        filter2.add(check2);
        
        combo2 = new JComboBox<String>();
        combo2.addItem("B.Tech");
        combo2.addItem("BCA");
        combo2.addItem("BSc");
        combo2.addItem("BA");
        combo2.addItem("MBA");
        filter2.add(combo2);
        combo2.setEditable(true);
        
        check3 = new JCheckBox("City                             ");
        filter3.add(check3);
        
        combo3 = new JComboBox<String>();
        combo3.addItem("Chandigarh");
        combo3.addItem("Dehradun");
        combo3.addItem("Mumbai");
        combo3.addItem("Banglore");
        combo3.addItem("Delhi");
        filter3.add(combo3);
        combo3.setEditable(true);
        
        search = new JButton();
        search.setText("      Search     ");
        search.setBounds(400,180,200,25);
        add(search);
        search.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ae)
           {
                while(table.getRowCount()>0)
                {
            ((DefaultTableModel)table.getModel()).removeRow(0);
        }
                if(check1.isSelected()&&check2.isSelected()&&check3.isSelected())
                {
                    
                  s1="select distinct name,email,degree,state,job_type from person  join education on person.id=education.id where state='"+combo3.getSelectedItem()+"' and education.degree='"+combo2.getSelectedItem()+"' and job_type='"+combo1.getSelectedItem()+"'"; 
                  insert(s1);  
                }
                else if(check1.isSelected()&&check2.isSelected())
                {
                   s1=" select distinct name,email,degree,state,job_type from person  join education on person.id=education.id where job_type='"+combo1.getSelectedItem()+"' and education.degree='"+combo2.getSelectedItem()+"'";
                   insert(s1); 
                }
                else if(check1.isSelected()&&check3.isSelected())
                {
                   s1=" select distinct name,email,degree,state,job_type from person  join education on person.id=education.id where job_type='"+combo1.getSelectedItem()+"' and state='"+combo3.getSelectedItem()+"'";
                   insert(s1); 
                }
                else if(check2.isSelected()&&check3.isSelected())
                {
                   s1="select distinct name,email,degree,state,job_type from person  join education on person.id=education.id where state='"+combo3.getSelectedItem()+"' and education.degree='"+combo2.getSelectedItem()+"'";
                   insert(s1); 
                }
                else if(check1.isSelected())
                {
                     s1="select distinct name,email,degree,state,job_type from person  join education on person.id=education.id where job_type='"+combo1.getSelectedItem()+"'";
                     insert(s1); 
                }
                else if(check2.isSelected())
                {
                 s1 = "select distinct name,email,degree,state,job_type from person  join education on person.id=education.id where education.degree='"+combo2.getSelectedItem()+"' ";
                 insert(s1); 
                }
                else if(check3.isSelected())
                {
                s1 =" select distinct name,email,degree,state,job_type from person  join education on person.id=education.id where state='"+combo3.getSelectedItem()+"' ";
                insert(s1); 
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane,"check atleast one checkbox");
                }
            }
        });
        
       
         table = new JTable();
         table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "    Email Id   ", "Qualification", "City", "Job Type"
            }
        ));
//         table.setBounds(50,250,600,300);
         //add(table);
         scroll = new JScrollPane();
         scroll.setViewportView(table);
         scroll.setBounds(50,250,900,300);
         add(scroll); 
        
        
    }
    
    
    void insert(String query)
    {
        try
        {
        Connect.getConnection();
        ResultSet rs = Connect.st.executeQuery(s1);
       int col = rs.getMetaData().getColumnCount();
      while(rs.next())
      {
          
            Object []row = new Object[col];
            for(int i=1;i<=col;i++)
            {
                row[i-1]=rs.getObject(i);
            }
            ((DefaultTableModel)table.getModel()).insertRow(rs.getRow()-1,row);
        }
      if(!rs.first())
      {
          JOptionPane.showMessageDialog(rootPane,"No data found");
          dispose();
      }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
 
//    public static void main(String args[])
//    {
//        new CompanySearch();
//    }
}
