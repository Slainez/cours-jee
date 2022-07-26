
package fr.m2i.webapplication;

import fr.m2i.webapplication.distributeur.Distributeur;
import fr.m2i.webapplication.distributeur.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moi
 */
public class DistributeurServlet extends HttpServlet {

    Distributeur distri = Distributeur.getInstance();
    int credit = distri.getCredit();
    List<Produit> productList = distri.getStock();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("credit",credit);
        request.setAttribute("stockList",productList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/distributeurWeb.jsp").forward(request,response);
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
        String acheterProduit = request.getParameter("acheterProduit");
        
        String addCredit = "";
        if(request.getParameter("increaseOne") != null){
        addCredit = request.getParameter("increaseOne");
        }
        if(request.getParameter("increaseTwo") != null){
        addCredit = request.getParameter("increaseTwo");
        }
        if(acheterProduit != null){
            distri.commanderProduit(Integer.getInteger(acheterProduit));
        }
        
            int montant = 0 ;
            switch(addCredit){
                case "increaseOne": 
                    montant = 1 ;
                    break;
                case "increaseTwo" :
                    montant = 2 ;
                    break;
                default :
                    montant = 0 ;                  
            }                    
            distri.insererArgent(montant);
            request.setAttribute("credit",credit);
            request.setAttribute("stockList",productList); 
            this.getServletContext().getRequestDispatcher("/WEB-INF/distributeurWeb.jsp").forward(request,response);
          
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
