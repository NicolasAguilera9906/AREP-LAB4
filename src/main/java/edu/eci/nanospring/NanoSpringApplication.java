package edu.eci.nanospring;


import edu.eci.RequestMapping;
import edu.eci.httpserver.HttpServer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class representing a spring nano server
 */
public class NanoSpringApplication {

    private static NanoSpringApplication _instance = new NanoSpringApplication();
    private static boolean componentsLoaded = false;
    private Map<String,Method> componentsRoutes = new HashMap();

    /**
     * Class default constructor
     */
    private NanoSpringApplication(){
    }


    /**
     * Method that is responsible for running the servers
     * @param args parameters needed to run the server
     */
    public static void run(String[] args) {
        if(!_instance.componentsLoaded){
            try {
                _instance.loadComponents(args);
                _instance.componentsLoaded=true;
                _instance.startServer();
            } catch (ClassNotFoundException e) {
                Logger.getLogger(NanoSpringApplication.class.getName()).log(Level.SEVERE,null,e);
            }
        }

    }

    /**
     * Method that starts the http server
     */
    private void startServer() {
        HttpServer hserver = new HttpServer(componentsRoutes);
        try {
            hserver.startServer();
        } catch (IOException e) {
            Logger.getLogger(NanoSpringApplication.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    /**
     * Method that loads the components that have the server functionalities
     * @param components components that have the server functionalities
     * @throws ClassNotFoundException when a class doesn't exists on Java
     */
    private void loadComponents(String[] components) throws ClassNotFoundException {
        for(String cp : components) {
            for (Method m : Class.forName(cp).getMethods()) {
                if (m.isAnnotationPresent(RequestMapping.class)) {
                    System.out.println(m.getDeclaredAnnotations().getClass().getName());

                    componentsRoutes.put(m.getAnnotation(RequestMapping.class).value(), m);
                }
            }
        }
    }

    /**
     * Method that invokes the functionality of a static server method
     * @param staticMethod to be invoked
     * @param args that could be executed with the method
     * @return result of the invocation
     * @throws Exception when there is an error in the execution
     */
    public static String invoke(Method staticMethod, String... args) throws Exception {
        String result; String value = null;
        for (Parameter parameter : staticMethod.getParameters()) {
            if (parameter.isAnnotationPresent(PathVariable.class)) {
                value = args[0];
            }
        }
        if (value != null) {
            result = staticMethod.invoke(null, value).toString();
        } else {
            result = staticMethod.invoke(null).toString();
        }
        return result;
    }
}
