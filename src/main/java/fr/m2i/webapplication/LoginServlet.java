
package fr.m2i.webapplication;

import fr.m2i.webapplication.session.User;
import fr.m2i.webapplication.session.UserDb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

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
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
         // On recupere la connexion a la base de données crée dans le lifecycleListener   
        UserDb userDb =(UserDb) this.getServletContext().getAttribute("userDb");
            
        // On récupère les paramètres du formulaire
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDb.checkUser(email, password);

        // Si le user est null, les identifiants sont invalides
        // On set le message d'erreur et on affiche la page de login
        if (user == null) {
            request.setAttribute("error", "Veuillez vérifier vos identifiants !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return; // on arrête la méthode ici
        }

        // Si on arrive ici c'est que le user est différent de null -> on la trouver dans notre base de donnée
        
        // On créer une nouvelle session avec le paramètre true
        HttpSession session = request.getSession(true);
        // On stock le user connecter dans la session
        session.setAttribute("user", user);

        // On affiche la page welcome
        response.sendRedirect("/WebApplication/HomeServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}


