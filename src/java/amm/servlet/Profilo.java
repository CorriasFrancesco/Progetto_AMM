/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.servlet;

import amm.UserFactory;
import amm.User;
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
public class Profilo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session= request.getSession();
        
        if (session==null || session.getAttribute("loggedIn") == null ||
            !session.getAttribute("loggedIn").equals(true)){
            
            //Se l'utente entra nel profilo senza aver effettuato l'accesso viene reindirizzato
            request.setAttribute("accessDenieded", true);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else{
            if (session!=null && session.getAttribute("loggedIn") != null &&
                session.getAttribute("loggedIn").equals(true)){
                
                if(session.getAttribute("elimina")!=null){
                    if(Integer.parseInt(request.getParameter("elimina"))==1){
                    request.setAttribute("confirm", true);
                    }
                    else{
                        UserFactory.getInstance().deleteUser((int)(session.getAttribute("loggedUserID")));
                        request.getRequestDispatcher("Login").forward(request, response);
                    }
                
                }
                else{
                    User user=UserFactory.getInstance().getUserById((int)session.getAttribute("loggedUserID"));

                    if(request.getMethod().equals("submit")){
                        request.setAttribute("update", true);

                        user.setNome((String)request.getAttribute("nome"));
                        user.setCognome((String)request.getAttribute("cognome"));
                        user.setUrlFotoProfilo((String)request.getAttribute("img_profilo"));
                        user.setFrasePresentazione((String)request.getAttribute("presentazione"));
                        user.setDataDiNascita((String)request.getAttribute("data"));
                        user.setPassword((String)request.getAttribute("pwd")); 
                    }

                    request.setAttribute("userNome", user.getNome());
                    request.setAttribute("userCognome", user.getCognome());
                    request.setAttribute("userUrlFotoProfilo", user.getUrlFotoProfilo());
                    request.setAttribute("userFrasePresentazione", user.getFrasePresentazione());
                    request.setAttribute("userDataDiNascita", user.getDataDiNascita());
                    request.setAttribute("userPassword", user.getPassword());

                    request.getRequestDispatcher("profilo.jsp").forward(request, response);
                    return;     
                }
            }
              
        }
        
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
