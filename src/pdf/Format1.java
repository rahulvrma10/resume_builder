
package pdf;

import resume_builder.Resume_Builder;
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
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Format1 {
    
  public static String temp;
  public static FileOutputStream fo;
  public static PdfWriter writer;
  String query;
  public void createPdf() throws DocumentException,IOException 
  {        
      
      temp = System.getProperty("java.io.tmpdir")+"0011223344.pdf";
   // step 1
        Document document = new Document();
        // step 2
        fo= new FileOutputStream(temp);
        writer=PdfWriter.getInstance(document,fo );
        document.setPageSize(PageSize.LETTER);
        document.setMargins(36, 36, 36, 36);
        document.setMarginMirroring(false);
        // step 3
        document.open();
        // step 4
        
        Rectangle rect= new Rectangle(28, 20, 580, 770);    //Page Border
        rect.setBorder(Rectangle.BOX);
        rect.setBorderWidth(2);
        rect.setBorderColor(BaseColor.BLACK);
        document.add(rect);
        
        try
        {
            Connect.getConnection();
            String place;
            query = "select name,email,contact,address,state,objective from person where id='"+Resume_Builder.id+"'";
            ResultSet rs = Connect.st.executeQuery(query);
            if(rs.first())
            {
            place = rs.getString("state");
            Font tableHead= new Font (Font.FontFamily.UNDEFINED, 12, Font.BOLD, BaseColor.BLACK);
                //Name heading
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK);
        Paragraph title= new Paragraph(rs.getString("name"),font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        
                //contact, address, email, city
        Font content= new Font (Font.FontFamily.UNDEFINED, 12, Font.NORMAL, BaseColor.BLACK);
        Paragraph info= new Paragraph(rs.getString("contact"),content);
        info.setSpacingAfter(0.5f);
        info.setAlignment(Element.ALIGN_CENTER);
        document.add(info);
        
        info= new Paragraph(rs.getString("email"),content);
        info.setSpacingAfter(0.5f);
        info.setAlignment(Element.ALIGN_CENTER);
        document.add(info);
        
        info= new Paragraph(rs.getString("address"),content);
        info.setSpacingAfter(0.5f);
        info.setAlignment(Element.ALIGN_CENTER);
        document.add(info);
        
        info= new Paragraph(rs.getString("state"),content);
        info.setSpacingAfter(2.0f);
        info.setAlignment(Element.ALIGN_CENTER);
        document.add(info);
        
               //
        Font heading= new Font (Font.FontFamily.TIMES_ROMAN, 16, Font.BOLDITALIC, BaseColor.BLACK);
        PdfPTable table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        PdfPCell cell = new PdfPCell(new Paragraph("CAREER OBJECTIVE",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        //cell.setExtraParagraphSpace(1.5f);
        table.addCell(cell);
        document.add(table);
        
        info = new Paragraph(rs.getString("objective"),content);
        info.setAlignment(Element.ALIGN_LEFT);
        document.add(info);
        
        
        table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        cell = new PdfPCell(new Paragraph("ACADEMICS",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        table.addCell(cell);
        document.add(table);
        
        query = "select * from education where id = '"+Resume_Builder.id+"'";
        rs = Connect.st.executeQuery(query);
        Chunk c;
        List unorderedList = new List(List.UNORDERED);
        while(rs.next())
        {
            c= new Chunk(rs.getString("degree")+" from "+rs.getString("institute")+" ("+rs.getString("university")+") with an aggregate of "+rs.getString("marks")+" (Year "+rs.getString("year")+")",content);
            unorderedList.add(new ListItem(c));
        
        }
         document.add(unorderedList);
         
         //skills
         query = "select * from skills where id = '"+Resume_Builder.id+"'";
        rs = Connect.st.executeQuery(query);
        if(rs.first())
        {
          table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        cell = new PdfPCell(new Paragraph("TECHNICAL & NON-TECHNICAL SKILLS",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        table.addCell(cell);
        document.add(table);
        unorderedList = new List(List.UNORDERED);
        //
        boolean b=rs.first();
        while(b)
        {
            c= new Chunk(rs.getString("skill"),content);;
            unorderedList.add(new ListItem(c));
            b=rs.next();
        
        }
         document.add(unorderedList);
         
        }
        
        //experience
         query = "select * from experience where id = '"+Resume_Builder.id+"'";
        rs = Connect.st.executeQuery(query);
        if(rs.first())
        {
          table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        cell = new PdfPCell(new Paragraph("RECENT EMPLOYERS",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        table.addCell(cell);
        document.add(table);
        table=new PdfPTable(4);
        table.setWidthPercentage(90);
        table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in 
        table.setSpacingAfter(30.0f);
        cell = new PdfPCell(new Paragraph("Employer Name",tableHead));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("Job Description",tableHead));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("From",tableHead));;
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("To",tableHead));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        boolean b=rs.first();
        while(b)
        {		               
 
				      table.addCell(rs.getString("employer"));
				      table.addCell(rs.getString("job"));
				      table.addCell(rs.getString("f_date"));
                                      table.addCell(rs.getString("t_date"));
         b = rs.next();
				    
        
        }
         document.add(table);
         
        }
        
        
        //projects
        
         query = "select * from project where id = '"+Resume_Builder.id+"'";
        rs = Connect.st.executeQuery(query);
        if(rs.first())
        {
          table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        cell = new PdfPCell(new Paragraph("PROJECTS",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        table.addCell(cell);
        document.add(table);
        
        boolean b=rs.first();
        while(b)
        {		               
 
            
            unorderedList = new List(List.UNORDERED);
            c= new Chunk(rs.getString("name"),tableHead);;
            unorderedList.add(new ListItem(c));
            document.add(unorderedList);
            info = new Paragraph("   "+rs.getString("details"),content);
            //info.setKeepTogether(true);
            document.add(info);
            
         b = rs.next();
				    
        
        }
         
        }
        //Strengths
        query = "select * from strengths where id = '"+Resume_Builder.id+"'";
        rs = Connect.st.executeQuery(query);
        if(rs.first())
        {
          table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        cell = new PdfPCell(new Paragraph("STRENGTHS",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        table.addCell(cell);
        document.add(table);
        unorderedList = new List(List.UNORDERED);
        //
        boolean b=rs.first();
        while(b)
        {
            c= new Chunk(rs.getString("strength"),content);
            unorderedList.add(new ListItem(c));
            b=rs.next();
        
        }
         document.add(unorderedList);
         
        }
        
        //References
        query = "select * from reference where id = '"+Resume_Builder.id+"'";
        rs = Connect.st.executeQuery(query);
        if(rs.first())
        {
          table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        cell = new PdfPCell(new Paragraph("REFERENCES",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        table.addCell(cell);
        document.add(table);
        unorderedList = new List(List.UNORDERED);
        //
        boolean b=rs.first();
        while(b)
        {
            c= new Chunk(rs.getString("reference"),content);
            unorderedList.add(new ListItem(c));
            b=rs.next();
        
        }
         document.add(unorderedList);
         
        }
        
        table = new PdfPTable(1);     //to left align info and right align addr
        table.setWidthPercentage(100);
        table.setSpacingAfter(2.0f);
        table.setSpacingBefore(30.0f);
        cell = new PdfPCell(new Paragraph("DECLARATION",heading));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.disableBorderSide(Rectangle.BOX);
        cell.setBackgroundColor (new BaseColor (221,243,249));
        table.addCell(cell);
        document.add(table);
        
        SimpleDateFormat st = new SimpleDateFormat("dd-MM-yyyy"); //sets Format of date - make sure MM is in capital
        info =new Paragraph("I hereby declare that the above-mentioned information is correct up to my knowledge and I bear the responsibility for the correctness of the above-mentioned particulars."
                + "\nDate   :   "+st.format(new Date())+""
                + "\nPlace    :   "+place,content);
        document.add(info);
        //document.add(rect);
       }
        }
        catch(Exception e)
        {
           System.out.println("problem in createPdcontent"); 
        }
        
         document.add(rect);
        document.close();
  
    
  }
  
  public static void main(String args[])
  {
      Format1 for1 = new Format1();
      try
      {
      for1.createPdf();
      System.out.println("Pdf created successfully");
      }
      catch(DocumentException e1)
      {
          System.out.println(e1 + "doc exception");
      }
      catch(IOException e1)
      {
          System.out.println(e1 + " io exeption");
      }
  }
    
    
}
