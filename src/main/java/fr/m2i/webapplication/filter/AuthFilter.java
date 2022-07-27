
package fr.m2i.webapplication.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AuthFilter implements Filter {
    
    private ServletContext context ;
    
    public void init(FilterConfig filterConfig){
        this.context = filterConfig.getServletContext();
        this.context.log("AuthFilter init");
    }
    
        
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        
        HttpServletRequest httpRequest = (HttpServletRequest) request ;
        HttpSession session = httpRequest.getSession(false);
        
        
        boolean isLoggedIn = session != null && session.getAttribute("user") != null ;
        
        if(!isLoggedIn) {
            this.context.log("User not connected");
            request.getRequestDispatcher("/WEB-INF/notWelcome.jsp").forward(request,response);
        }
        chain.doFilter(request, response);
    } 
    
    
    @Override
    public void destroy(){
        
    }

   

    
    
}
