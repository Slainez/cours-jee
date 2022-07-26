package fr.m2i.webapplication;


import fr.m2i.webapplication.distributeur.Distributeur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DistributeurServlet extends HttpServlet {
    int messageId = 0 ;
    String message = "";

    private final Distributeur distributeur = Distributeur.getInstance();

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
        setDistributorAttribute(request);
        this.getServletContext().getRequestDispatcher("/WEB-INF/distributeurWeb.jsp").forward(request, response);
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
        
        addCredit(request);
        buyProduct(request);
        setDistributorAttribute(request);

        this.getServletContext().getRequestDispatcher("/WEB-INF/distributeurWeb.jsp").forward(request, response);
    }

    private void addCredit(HttpServletRequest request) {
        
        
        int montant = 0 ;
        if(request.getParameter("inputAddCredit") != null){
           montant = Integer.parseInt(request.getParameter("inputAddCredit"));  
        }      
        if (montant <= 0 ) {
            messageId = 1 ;
           message = "Vous devez saisir un montant superieur a 0";
        }else{
           distributeur.insererArgent(montant); 
        }

        request.setAttribute("messageId", messageId);
        request.setAttribute("message", message);
        
        // distributeur.setCredit(distributeur.getCredit() + amount);
    }
    
    private void buyProduct(HttpServletRequest request) {        
        
        String productId = request.getParameter("productId");
        int idProduct = 0 ;
        if(productId != null){
            idProduct = Integer.parseInt(productId);
        }
        int maxId = distributeur.getStock().size() ;

        if (idProduct <= 0 || idProduct > maxId ) {
            messageId = 2 ;
           message = "Vous devez choisir un produit existant"; 
        }else if (!distributeur.stockSuffisant((idProduct))){
             message = "Nous n'avons plus ce produit en stock, veuillez en choisir un autre";
             messageId = 2 ;
        }else if(!distributeur.creditSuffisant((idProduct))){
            messageId = 2 ;
            message = "Credit insuffisant , veuillez rajouter du credit ";
        }else{
          distributeur.commanderProduit(idProduct);  
        }
         request.setAttribute("messageId", messageId); 
         request.setAttribute("message", message);
    }

    private void setDistributorAttribute(HttpServletRequest request) {
        request.setAttribute("credit", distributeur.getCredit());
        request.setAttribute("stock", distributeur.getStock());
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
