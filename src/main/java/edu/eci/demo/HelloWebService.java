package edu.eci.demo;

import edu.eci.RequestMapping;
import edu.eci.nanospring.PathVariable;

/**
 * Service offered by nano spring server
 */
public class HelloWebService {

    /**
     * Method that returns a greeting message when required
     * @param value that is passes as argument
     * @return a greeting message when required
     */
    @RequestMapping(value = "/hellomundo")
    public static String index(@PathVariable String value){
        return "Greetings " + value + "from Nano Spring boot";
    }


}
