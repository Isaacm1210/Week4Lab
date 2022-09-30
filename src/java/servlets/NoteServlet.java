package servlets;

import models.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mhame
 */
public class NoteServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String edit = request.getParameter("edit");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        try{
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title = br.readLine();
        String content = br.readLine();
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        br.close();
        }catch(FileNotFoundException e){
       
        }
            
        if(edit == null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
    }

    
    /* 
    * Method is called when "Save" button is pressed
    * Saves form from editnote to note.txt
    * Displays saved content to viewnote
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String savedTitle = request.getParameter("title");
        String savedContent = request.getParameter("content");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        Note savedNote = new Note(savedTitle, savedContent);
        
        try{
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        pw.println(savedNote.getTitle());
        pw.println(savedNote.getContent());
        pw.close();
        }catch(FileNotFoundException e){
            
        }
        request.setAttribute("note", savedNote);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    
   

}
