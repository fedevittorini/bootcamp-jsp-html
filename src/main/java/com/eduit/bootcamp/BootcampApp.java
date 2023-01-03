package com.eduit.bootcamp;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.eduit.bootcamp.jdbc.ClientesDAOImpl;

public class BootcampApp implements ServletContextListener {

	public static void main(String[] arg) throws Exception {
		BootcampApp app = new BootcampApp();
	}
	
	public static Properties appProperties;
	public static ClientesDAOImpl clientesDAOImpl;


    public void contextInitialized(ServletContextEvent servletContextEvent)  {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	try {
			appProperties = PropertiesManager.buildProperties("./src/main/resources/application.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	clientesDAOImpl = new ClientesDAOImpl(appProperties);
    	ctx.setAttribute("appProperties", appProperties);
    	ctx.setAttribute("clientesDAOImpl", clientesDAOImpl);
    	System.out.println("Database connection initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	System.out.println("Database connection closed for Application.");
    	
    }
}
