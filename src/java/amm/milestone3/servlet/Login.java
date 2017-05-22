/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3.servlet;

import amm.milestone3.UserFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author francesco
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession session = request.getSession();
        
        //Se è impostato il parametro GET logout, distrugge la sessione
        if(request.getParameter("logout")!=null){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        //Se esiste un attributo di sessione loggedIn e questo vale true l' utente è già loggato
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {
                if(UserFactory.getInstance().completeData((int)session.getAttribute("loggedUserID"))){
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                    return;
                }
                else{
                    request.getRequestDispatcher("Profilo").forward(request, response);
                    return;
                }
        }
        else{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            if(username!=null && password!=null){
                int loggedUserID=UserFactory.getInstance().getIdByUserAndPass(username, password);
                
                if(loggedUserID!=-1){
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    
                if(UserFactory.getInstance().completeData((int)session.getAttribute("loggedUserID"))){
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                    return;
                }
                else{
                    request.getRequestDispatcher("Profilo").forward(request, response);
                    return;
                }
                }
                else{
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
