
package pdf;

import java.sql.ResultSet;


import connection.Connect;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import resume_builder.Resume_Builder;
public class Format2 {
    
    public static String temp = null;
    public static FileOutputStream fo;
    public static PdfWriter writer;
    Paragraph title;
    Font font;
    Chunk chunk;
    PdfPTable table;
    String city ;
    
    public void createPdf()throws DocumentException,IOException
    {
        
     temp= System.getProperty("java.io.tmpdir")+"0011223344.pdf"; // gets to location of temporary location in c drive
        
     // step 1
     Document document = new Document();
        
     // step 2
     fo= new FileOutputStream(temp);
     writer=PdfWriter.getInstance(document,fo);
     document.setPageSize(PageSize.LETTER);
     document.setMargins(47, 36, 44, 36);
     document.setMarginMirroring(false);
    
     // step 3
     document.open();
   
     // step 4
     Rectangle rect= new Rectangle(33, 40, 580, 750);    //Page Border
     rect.setBorder(Rectangle.BOX);
     rect.setBorderWidth(2);
     rect.setBorderColor(BaseColor.BLACK);
     document.add(rect);
      
        
     try     
     {
         Connect.getConnection();
         Connect.getConnection();
         String basic = "select name,address,state,contact,email , objective from person where id = '"+Resume_Builder.id+"'" ;  //"+resume_builder.Resume_Builder.id+"                            
         ResultSet person = Connect.st.executeQuery(basic);
         if(person.next())
         { 
             //name
             font= new Font(Font.FontFamily.TIMES_ROMAN,20, Font.BOLD, BaseColor.BLACK);
             title = new Paragraph(""+person.getString("name")+"\n",font);
             title.setAlignment(Element.ALIGN_LEFT);
             document.add(title);

             //address and city 
             city = person.getString("state");
             font= new Font(Font.FontFamily.TIMES_ROMAN,10, Font.NORMAL, BaseColor.BLACK);
             title = new Paragraph(""+person.getString("address")+" ,"+person.getString("state")+"\n",font);
             title.setAlignment(Element.ALIGN_LEFT);
             document.add(title);

             //contact
             font= new Font(Font.FontFamily.TIMES_ROMAN,10, Font.NORMAL, BaseColor.BLACK);
             title = new Paragraph(""+person.getString("contact")+"\n",font);
             title.setAlignment(Element.ALIGN_LEFT);
             document.add(title);

             //email
             font= new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
             title = new Paragraph(""+person.getString("email")+"\n\n\n",font);             
             title.setAlignment(Element.ALIGN_LEFT);
             document.add(title);
             
             //objective heading
             font= new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
             chunk= new Chunk("CAREER OBJECTIVE"+"\n",font);
             document.add(new Paragraph("\n"));
             chunk.setUnderline(+1.4f,-4f);
             document.add(chunk);
             
             //objective
             font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
             title = new Paragraph(""+person.getString("objective")+" \n\n",font);             
             title.setAlignment(Element.ALIGN_LEFT);
             document.add(title);
           }
         else
         {
             System.out.println("query wrong");
         }
     }
     catch(Exception e)
     {
        System.out.println(e + "PERSON");
     } 
     //------ end of person table ----------
     
     
                //----START OF EDUCATION TABLE -----
   font= new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
   chunk= new Chunk("EDUCATION"+"\n",font);
   document.add(new Paragraph("\n"));
   chunk.setUnderline(+1.4f,-4f);
   document.add(chunk);    
     
         
     try     
     {
         Connect.getConnection();
         Connect.getConnection();
         String edu = "select degree,institute,university,year,marks from education where id = '"+Resume_Builder.id+"'" ;  //"+resume_builder.Resume_Builder.id+"                            
         ResultSet education = Connect.st.executeQuery(edu);
         
         //create a tabkle with 5 columns
         table=new PdfPTable(5);
         table.setWidthPercentage(95);
         font= new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
         
         //cell Accomplishment
         PdfPCell accomplish = new PdfPCell (new Paragraph ("Accomplishment",font));
         accomplish.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         accomplish.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(accomplish);	
         
         //cell institute
         PdfPCell institute = new PdfPCell (new Paragraph ("Name of Institute ",font));
         institute.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         institute.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(institute);	
         
         //cell board
         PdfPCell board = new PdfPCell (new Paragraph ("Board/University",font));
         board.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         board.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(board);	
         
         //cell year of passing
         PdfPCell yop = new PdfPCell (new Paragraph ("Year of passing",font));
         yop.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         yop.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(yop);	
         
         //cell marks
         PdfPCell marks = new PdfPCell (new Paragraph ("Marks",font));
         marks.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         marks.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(marks);	
         
         
         
         while(education.next())
         {  
                    font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
         
                    table.addCell(new Paragraph(""+education.getString("degree") +"",font));
                    table.addCell(new Paragraph(""+education.getString("institute") +"",font));
                    table.addCell(new Paragraph(""+education.getString("university") +"",font));
                    table.addCell(new Paragraph(""+education.getString("year") +"",font));
                    table.addCell(new Paragraph(""+education.getString("marks") +"",font));
                    
            
				      
                    table.setSpacingBefore(10.0f);       // Space Before table starts, like margin-top in CSS
                    table.setSpacingAfter(15.0f);        // Space After table starts, like margin-Bottom in CSS		
 
                    
         }
         document.add(table);
    }
     catch(Exception e)
     {
         
     }
     
   
 
    
   //Technical and non technical skills
    
    try     
    {
     Connect.getConnection();
     Connect.getConnection();
     String skill = "select skill from skills where id = '"+Resume_Builder.id+"'" ;  //"+resume_builder.Resume_Builder.id+"                            
     ResultSet skills = Connect.st.executeQuery(skill);
     
     if(skills.first())
     {
        //Technical and non technical skills heading 
        font= new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
        chunk= new Chunk("TECHNICAL AND NON TECHNICAL SKILLS"+"\n",font);
        document.add(new Paragraph("\n"));
        chunk.setUnderline(+1.4f,-4f);
        document.add(chunk);  

        font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);

        List list=new List(List.UNORDERED);
        skills.previous();
        
         while(skills.next())
         {
             list.add(new ListItem(new Paragraph(""+skills.getString("skill") +"",font)));

         }
         
        document.add(list);
        document.add(new Paragraph("\n"));
     }


    }
    catch(Exception e)
    {

    }

    // ----END of Technical and non technical skills-----
    
    
                                //--- Experience---
    
    //----- recent employeee ----
    
    try     
    {
     Connect.getConnection();
     Connect.getConnection();
     String emp = "select employer,job,f_date,t_date from experience where id = '"+Resume_Builder.id+"'" ;  //"+resume_builder.Resume_Builder.id+"                            
     ResultSet employer = Connect.st.executeQuery(emp);
     
     if(employer.first())
     {
        //EXperience heading-------------
        font= new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
        chunk= new Chunk("EXPERIENCE"+"\n",font);
        document.add(new Paragraph("\n"));
        chunk.setUnderline(+1.4f,-4f);
        document.add(chunk);  
        
        //recenr project sub-heading-------
        font= new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
        chunk= new Chunk("- Recent Employers"+"\n",font);        
        document.add(new Paragraph("\n"));
        chunk.setUnderline(+1f,-2.5f);
        document.add(chunk);  
        
        

        font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);

       
        employer.previous();
        
        
        //create a tabkle with 4 columns
         table=new PdfPTable(4);
         table.setWidthPercentage(91);
         font= new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
         
         //cell employers
         PdfPCell projects = new PdfPCell (new Paragraph ("Employer(s)",font));
         projects.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         projects.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(projects);	
         
         //cell job_desc
         PdfPCell job_desc = new PdfPCell (new Paragraph ("Job Description",font));
         job_desc.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         job_desc.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(job_desc);	
         
         //cell f_date
         PdfPCell f_date = new PdfPCell (new Paragraph ("Joining Date",font));
         f_date.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         f_date.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(f_date);	
        
         //cell t_date
         PdfPCell t_date = new PdfPCell (new Paragraph ("Ending Date",font));
         t_date.setHorizontalAlignment (Element.ALIGN_CENTER);
         //headCell.setPadding (10.0f);
         t_date.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(t_date);	
        
         //take values from table experience table 
         while(employer.next())
         {
                    font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
         
                    table.addCell(new Paragraph(""+employer.getString("employer") +"",font));
                    table.addCell(new Paragraph(""+employer.getString("job") +"",font));
                    table.addCell(new Paragraph(""+employer.getString("f_date") +"",font));
                    table.addCell(new Paragraph(""+employer.getString("t_date") +"",font));
                   
        				      
                    table.setSpacingBefore(10.0f);       // Space Before table starts, like margin-top in CSS
                    table.setSpacingAfter(15.0f);        // Space After table starts, like margin-Bottom in CSS	

         }
         
     document.add(table);
     }


    }
    catch(Exception e)
    {

    }
    //---- end of  experience ----------
                     //--- end of employer
    
                                //------start of project---------
    
     
    try     
    {
     Connect.getConnection();
     Connect.getConnection();
     String pr = "select name,details from project where id = '"+Resume_Builder.id+"'" ;  //"+resume_builder.Resume_Builder.id+"                            
     ResultSet project = Connect.st.executeQuery(pr);
     
     if(project.first())
     {
        
    
        ////Project sub-heading-------------
        font= new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
        chunk= new Chunk("- Recent Project"+"\n",font);        
        document.add(new Paragraph("\n"));
        chunk.setUnderline(+1f,-2.5f);
        document.add(chunk);
        

        font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);

       
        project.previous();
        
        
        //create a tabkle with 2 columns
         table=new PdfPTable(2);
         table.setWidthPercentage(91);
         font= new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
         
         //name project
         PdfPCell projects = new PdfPCell (new Paragraph ("Project(s)",font));
         projects.setHorizontalAlignment (Element.ALIGN_CENTER);
         projects.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(projects);	
         
         //details project
         PdfPCell job_desc = new PdfPCell (new Paragraph ("Project Description",font));
         job_desc.setHorizontalAlignment (Element.ALIGN_CENTER);
         job_desc.setBackgroundColor (new BaseColor (219, 227, 238));					               
         table.addCell(job_desc);	
         
         //take values from table Project table 
         while(project.next())
         {
                    font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
         
                    table.addCell(new Paragraph(""+project.getString("name") +"",font));
                    table.addCell(new Paragraph(""+project.getString("details") +"",font));
                    
                   
        				      
                    table.setSpacingBefore(10.0f);       // Space Before table starts, like margin-top in CSS
                    table.setSpacingAfter(15.0f);        // Space After table starts, like margin-Bottom in CSS	

         }
         
     document.add(table);
     }
     project.close();
   }
    catch(Exception e)
    {

    }
    
    //----end of project table-----
    
    
                                    //---start of STRENGTHS------
    
     try     
    {
     Connect.getConnection();
     Connect.getConnection();
     String st = "select strength from strengths where id = '"+Resume_Builder.id+"'" ;  //"+resume_builder.Resume_Builder.id+"                            
     ResultSet strength = Connect.st.executeQuery(st);
     
     if(strength.first())
     {
        //strength heading 
        font= new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
        chunk= new Chunk("STRENGTHS"+"\n",font);
        document.add(new Paragraph("\n"));
        chunk.setUnderline(+1.4f,-4f);
        document.add(chunk);  

        font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);

        List s_list=new List(List.UNORDERED);
        strength.previous();
        
         while(strength.next())
         {
             s_list.add(new ListItem(new Paragraph(""+strength.getString("strength") +"",font)));

         }
         
        document.add(s_list);
        document.add(new Paragraph("\n"));
     }


    }
    catch(Exception e)
    {
        System.out.println(e+" srtengths");
    }
    
     //------------end of strengths--------
     
                                //---------start of references--------

     try     
    {
     Connect.getConnection();
     Connect.getConnection();
     String ref = "select reference from reference where id = '"+Resume_Builder.id+"'" ;  //"+resume_builder.Resume_Builder.id+"                            
     ResultSet reference = Connect.st.executeQuery(ref);
     
     if(reference.first())
     {
        //strength heading 
        font= new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
        chunk= new Chunk("REFERENCES"+"\n",font);
        document.add(new Paragraph("\n"));
        chunk.setUnderline(+1.4f,-4f);
        document.add(chunk);  

        font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);

        List r_list=new List(List.UNORDERED);
        reference.previous();
        
         while(reference.next())
         {
             r_list.add(new ListItem(new Paragraph(""+reference.getString("REFERENCE") +"",font)));

         }
         
        document.add(r_list);
        document.add(new Paragraph("\n"));
     }


    }
    catch(Exception e)
    {
        System.out.println(e+" REFERENCE");

    }
     
     //---end of references--
     
                            //-----start of declaration------
     document.add(rect);
     //declaration heading 
        font= new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
        chunk= new Chunk("DECLARATION"+"\n",font);
        document.add(new Paragraph("\n"));
        chunk.setUnderline(+1.4f,-4f);
        document.add(chunk);
        
        SimpleDateFormat st = new SimpleDateFormat("dd-MM-yyyy"); //sets Format of date - make sure MM is in capital
        font= new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
    
        title = new Paragraph("I hereby declare that the above-mentioned information is correct up to my knowledge "
                + "and I bear the responsibility for the correctness of the above-mentioned particulars"
                + ".\nDate   :   "+st.format(new Date())+""
                + "\nPlace    :   "+city+"",font);
        
        document.add(title);
     
     document.close();
    }

public static void main(String args[])
    {
        Format2 f1 = new Format2();
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
    }
}
    
