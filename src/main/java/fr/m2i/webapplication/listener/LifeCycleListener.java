
package fr.m2i.webapplication.listener;


import fr.m2i.webapplication.session.UserDb;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class LifeCycleListener implements ServletContextListener {
    private static Logger logger = Logger.getLogger(LifeCycleListener.class.getName());
    
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Logs de démarrage
        
        logger.info("---- App started ----");
        logger.info(dtf.format(LocalDateTime.now()));
        logger.info("---- App started ----");
        
        // on recupere le contexte via le sce passé en parametre de la methode
       ServletContext contexte = sce.getServletContext();
       
       // on recupere les identifiants de la base de donnes present dans le web.xml
      
       String dbUser = contexte.getInitParameter("dbUser");
       String dbPass = contexte.getInitParameter("dbPass");
       UserDb userDb = UserDb.getInstance(dbUser,dbPass);
       
       // Si elle est null la connexion c'est mal passée
       if (userDb == null){
           logger.severe("/!\\ Impossible de se connecter a la abse de donnes /!\\");
           return ;
       }
       
       // si on arrive ici la connexion s'est bien passée 
       
       // On garde dans les attributs du servlet context l'instance de notre base de donnée
       contexte.setAttribute("userDb",userDb);
       logger.info("---- Init done ----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("---- App stopped ----");
        logger.info(dtf.format(LocalDateTime.now()));
        logger.info("---- App stopped ----");
    }
}
