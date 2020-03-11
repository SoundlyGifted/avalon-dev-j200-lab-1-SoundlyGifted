/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SoundlyGifted
 */
public class WordInputServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param response servlet response
     * @param message message to be typed 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletResponse response, String message)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"ru\">");
            out.println("<head>");
            out.println("<title>Servlet Hello</title>");
            out.println("<meta charset=\"UTF-8\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + message + "</h1>");
            out.println(goBack());
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. 
    // Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String msg = request.getParameter("msg");

        if (msg.trim().isEmpty()) {
            response.sendRedirect("index_nomessage.html");
        } else {
            if (isInteger(msg)) {
                String msgChanged = Integer.toString(Integer.parseInt(msg) + 1);
                processRequest(response,
                        "You've entered a number: \'" + msg + 
                        "\', Changed message is: \'" + msgChanged + 
                        "\' (increased by 1)");
            } else {
                int wordNumber = numberOfWords(msg);
                processRequest(response, 
                        "You've entered a text: \'" + msg + 
                         "\', Number of words: \'" + wordNumber);
            }
        }
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    } 

    private int numberOfWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        boolean isWord = false; 
        int count = 0;  // word count 
        int i = 0; 
        // Scan all characters one by one 
        while (i < str.length()) { 
            // If next character is a separator, set the  
            // isWord as false 
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n'
                                     || str.charAt(i) == '\t'
                                     || str.charAt(i) == '\r'
                                     || str.charAt(i) == '\f')
                isWord = false; 
            // If next character is not a word separator 
            // and isWord is false 
            // (means fist word character after a separator has been found), 
            // then set the isWord as true and increment word count
            else if (isWord == false) 
            { 
                isWord = true; 
                ++count; 
            } 
            // Move to next character 
            ++i; 
        } 
        return count; 
    }

    private String goBack() {
        return "<form action=\"index.html\">\n"
                + "            <input type=\"submit\" value=\"Back\"/>\n"
                + "        </form>";
    }    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(response, "some message on doPost method.");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold> 
}
