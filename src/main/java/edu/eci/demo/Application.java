package edu.eci.demo;

import edu.eci.nanospring.NanoSpringApplication;

/**
 * Application that is responsible for running a server that simulates Spring
 */
public class Application {

    /**
     * Main class of the application
     * @param args arguments needed to run the application
     */
    public static void main (String[] args){
        if (args.length == 0) {
            String[] path = {"edu.eci.demo.HelloWebService"};
            NanoSpringApplication.run(path);
        } else {
            NanoSpringApplication.run(args);
        }
    }
}
