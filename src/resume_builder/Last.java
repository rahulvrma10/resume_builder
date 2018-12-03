/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resume_builder;

import com.itextpdf.text.DocumentException;


import email.SendMail;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import pdf.Format1;
import pdf.Format2;

public class Last extends JPanel {

    String path;
    Path src, dest;
    
    JPanel p_left;
    
    JScrollPane s_pane;
    
    JLabel pdf_image;
    JLabel l_theme;
    JLabel l_email;
    JLabel l_save;
    JLabel page;
    
    JButton b_email;
    JButton b_save;
    JButton b_next_page;
    JButton b_prev_page;
    JButton b_continue;
    JButton b_exit;
    
    
    JComboBox<String> c_theme;
    
    
    Last()
    {
        setLayout(null);
        //setBounds(200, 100, 1000, 600);
        //setVisible(true);
        p_left = new JPanel();
        p_left.setBounds(0,0,300,600);
        p_left.setLayout(null);
        add(p_left);
        
        
        page = new JLabel("7/7");
        page.setBounds(270,520,50,25);
        add(page);
        
        s_pane = new JScrollPane();
        s_pane.setBounds(410,2,575,560);
        pdf_image = new JLabel();
        
        
        add(s_pane);
        
        
        l_theme = new JLabel("Select Theme for resume :");
        l_theme.setBounds(60,100,200,25);
        l_theme.setFont(new java.awt.Font("Default", 1, 15));
        p_left.add(l_theme);

       
        l_email = new JLabel("E-mail your resume :");
        l_email.setBounds(60,300,150,25);
        l_email.setFont(new java.awt.Font("Default", 1, 15));
        p_left.add(l_email);
        

        b_email = new JButton("Send");
        b_email.setBounds(230,300,70,27);
        p_left.add(b_email);
        b_email.addActionListener(new ActionListener() {
            private Component rootPane;
            private String[] args;

            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                     if(c_theme.getSelectedItem().equals("Format 2"))
                {
                    Format2 f2 = new Format2();
                    try
                    {
                        f2.createPdf();
                        System.out.println("pdf created");
                    }
                    catch(DocumentException e)
                    {
                        System.out.println(e.getStackTrace()+"DocumentException");
                    }
                    catch(IOException e)
                    {
                        System.out.println(e.getStackTrace() + "IOException");

                    }
                    
                    SendMail sf2 = new SendMail();
                    sf2.mailpdf();


                   
                }//---end of if for format 2
                
                //--start of format 1
                if(c_theme.getSelectedItem().equals("Format 1"))
                {
                    Format1 f1 = new Format1();
                    try
                    {
                        f1.createPdf();
                        System.out.println("pdf created");
                    }
                    catch(DocumentException e)
                    {
                        System.out.println(e.getStackTrace()+"DocumentException");
                    }
                    catch(IOException e)
                    {
                        System.out.println(e.getStackTrace() + "IOException");

                    }
                    
                     SendMail sf1 = new SendMail();
                     sf1.mailpdf();
                 
                
                }//---end of if for format 1 
                
                if(c_theme.getSelectedItem().equals("--Select--"))
                {
                    JOptionPane.showMessageDialog(null,"Please Select a Format");
                }
        
                
            }
        });
        
        l_save = new JLabel("Save resume as pdf :");
        l_save.setBounds(60,400,150,25);
        l_save.setFont(new java.awt.Font("Default", 1, 15));
        p_left.add(l_save);

        b_save = new JButton("Save");
        b_save.setBounds(230,400,70,27);
        p_left.add(b_save);
        b_save.addActionListener(new ActionListener() {
            private Component rootPane;

            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                if(c_theme.getSelectedItem().equals("Format 2"))
                {
                    Format2 f2 = new Format2();
                    try
                    {
                        f2.createPdf();
                        System.out.println("pdf created");
                    }
                    catch(DocumentException e)
                    {
                        System.out.println(e.getStackTrace()+"DocumentException");
                    }
                    catch(IOException e)
                    {
                        System.out.println(e.getStackTrace() + "IOException");

                    }


                    JFileChooser saveFile = new JFileChooser();
                    saveFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int returnName = saveFile.showSaveDialog(null);


                    if (returnName == JFileChooser.APPROVE_OPTION) 
                    {
                        File f = saveFile.getSelectedFile();
                        if (f != null) 
                        { // Make sure the user didn't choose a directory.

                            path = f.getAbsolutePath();//get the absolute path to selected file
                            //below line to test the file saveFile
                            System.out.println(path);

                            dest =  Paths.get(path+".pdf");//converts the path string to path understandable by java
                            src = Paths.get(Format2.temp);

                            try
                            {
                                Files.copy(src,dest);
                                JOptionPane.showMessageDialog(null,"File saved successfully");

                            }
                            catch(IOException ex)
                            {
                                System.out.println(ex +" files not copy");
                                JOptionPane.showMessageDialog(rootPane,"could not create pdf as file name not entered / file already exists !");
                            }

                            System.out.print(dest);

                        }
                    }
                
                }//---end of if for format 2
                
                //--start of format 1
                if(c_theme.getSelectedItem().equals("Format 1"))
                {
                    Format1 f1 = new Format1();
                    try
                    {
                        f1.createPdf();
                        System.out.println("pdf created");
                    }
                    catch(DocumentException e)
                    {
                        System.out.println(e.getStackTrace()+"DocumentException");
                    }
                    catch(IOException e)
                    {
                        System.out.println(e.getStackTrace() + "IOException");

                    }


                    JFileChooser saveFile = new JFileChooser();
                    saveFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int returnName = saveFile.showSaveDialog(null);


                    if (returnName == JFileChooser.APPROVE_OPTION) 
                    {
                        File f = saveFile.getSelectedFile();
                        if (f != null) 
                        { // Make sure the user didn't choose a directory.

                            path = f.getAbsolutePath();//get the absolute path to selected file
                            //below line to test the file saveFile
                            System.out.println(path);

                            dest =  Paths.get(path+".pdf");//converts the path string to path understandable by java
                            src = Paths.get(Format1.temp);

                            try
                            {
                                Files.copy(src,dest);
                                JOptionPane.showMessageDialog(null,"File save successfully");

                            }
                            catch(IOException ex)
                            {
                                System.out.println(ex +" files not copy");
                                JOptionPane.showMessageDialog(rootPane,"could not create pdf as file name not entered / file already exists !");
                            }

                            System.out.print(dest);

                        }
                    }
                
                }//---end of if for format 1 
                
                if(c_theme.getSelectedItem().equals("--Select--"))
                {
                    JOptionPane.showMessageDialog(null,"Please Select a Format");
                }
                
            }
        });
        //----end of save button that generates a pdf
        
    
        c_theme = new JComboBox<String>();
        System.out.println("combo");
        c_theme.addItem("--Select--");
        c_theme.addItem("Format 1");
        c_theme.addItem("Format 2");
        p_left.add(c_theme);
        c_theme.setBounds(60,160,150,25);
        c_theme.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                selectFormatImage();
            }
        });
        
         
        b_prev_page = new JButton("Prev Page");
        b_prev_page.setBounds(60,210,100,27);
        p_left.add(b_prev_page);
        b_prev_page.setEnabled(false);
        b_prev_page.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                 if(c_theme.getSelectedItem().equals("Format 1"))
                 {
                    pdf_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/format1_1.jpg")));
                 }
                 
                 if(c_theme.getSelectedItem().equals("Format 2"))
                 {
                      pdf_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/format2_1.png")));
                 }
            }
        });
       
        
        b_next_page = new JButton("Next Page") ;
        b_next_page.setBounds(190,210,100,27);
        p_left.add(b_next_page);
        b_next_page.setEnabled(false);
        b_next_page.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                 if(c_theme.getSelectedItem().equals("Format 1"))
                 {
                    pdf_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/format1_2.jpg")));
                 }
                 
                 if(c_theme.getSelectedItem().equals("Format 2"))
                 {
                      pdf_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/format2_2.png")));
                 }
            }
        });
         
        b_continue = new JButton("Continue");
        b_continue.setBounds(60,480,100,27);
        p_left.add(b_continue);
        b_continue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                Resume_Builder.resume.setVisible(true);
                Resume_Builder.resume.base.dispose();
             
            
            }
        });
                
        
     
        b_exit = new JButton("Exit!");
        b_exit.setBounds(190,480,100,27);
        p_left.add(b_exit);
        b_exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure ?");
                
                if(confirm == 0)
                {
                    System.exit(0);
                    
                }

                if(confirm == 1)
                {
                    return;
                 
                }
                
                
            }
        });
                
        
        
        
       
    }
    
//    public static void main(String args[])
//    {
//        JFrame j1 = new JFrame();
//        j1.setVisible(true);
//        j1.setBounds(200, 100, 1000, 600);
//        j1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        j1.add(new Last());
//    }
    
    void selectFormatImage() //-----puts image in scrol pane
    {
        
        if(c_theme.getSelectedItem().equals("Format 1"))
        {
            pdf_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/format1_1.jpg")));
            s_pane.setViewportView(pdf_image);   
            b_prev_page.setEnabled(true);
            b_next_page.setEnabled(true);
            s_pane.setBounds(430,2,545,560);
        }
        
        else if(c_theme.getSelectedItem().equals("Format 2"))
        {
            System.out.println("jio");
            pdf_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/format2_1.png")));
            s_pane.setViewportView(pdf_image);  
            b_prev_page.setEnabled(true);
            b_next_page.setEnabled(true);
            s_pane.setBounds(410,2,575,560);
        }
        else
        {
            System.out.println("nothing selected");
            
            s_pane.setViewportView(null);
            b_prev_page.setEnabled(false);
            b_next_page.setEnabled(false);
        }
        
    }
    
}
