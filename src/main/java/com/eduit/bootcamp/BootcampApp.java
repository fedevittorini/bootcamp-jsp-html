package com.eduit.bootcamp;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.eduit.bootcamp.jdbc.ClientesDAOImpl;
import com.eduit.bootcamp.jdbc.UsuariosDAOImpl;

public class BootcampApp implements ServletContextListener {

	public static final String APP_PROPS_NAME = "appProperties";

    public void contextInitialized(ServletContextEvent servletContextEvent)  {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	try {
        	Properties appProperties = PropertiesManager.buildProperties("./src/main/resources/application.properties");
	    	ctx.setAttribute(APP_PROPS_NAME, appProperties);
	    	ctx.setAttribute(ClientesDAOImpl.CTX_NAME, new ClientesDAOImpl(appProperties));
	    	ctx.setAttribute(UsuariosDAOImpl.CTX_NAME, new UsuariosDAOImpl(appProperties));
	    	System.out.println("Database connection initialized for Application.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
    	
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	System.out.println("Database connection closed for Application.");
    	
    }
}
