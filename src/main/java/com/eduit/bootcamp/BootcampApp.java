package com.eduit.bootcamp;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.eduit.bootcamp.jdbc.ClientesDAOImpl;

public class BootcampApp implements ServletContextListener {


    public void contextInitialized(ServletContextEvent servletContextEvent)  {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	Properties appProperties = null;
    	ClientesDAOImpl clientesDAOImpl;
    	try {
			appProperties = PropertiesManager.buildProperties("./src/main/resources/application.properties");
			clientesDAOImpl = new ClientesDAOImpl(appProperties);
	    	ctx.setAttribute("appProperties", appProperties);
	    	ctx.setAttribute("clientesDAOImpl", clientesDAOImpl);
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
