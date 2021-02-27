package edu.eci.nanospring;

import java.util.ArrayList;

/**
 * Class representing my own http request
 */
public class MyCustomRequest {
    private ArrayList<String> values = null;
    private boolean hasValues = false;
    private String endpoint = null;

    /**
     * Constructor of the class, add the values ​​included as parameters in the request url in case of containing them
     * @param path path of the request made
     */
    public MyCustomRequest(String path) {
        addValues(path);
    }

    /**
     * Add the values ​​included as parameters in the request url to an arraylist
     * @param path path in which the values ​​are included
     */
    private void addValues(String path) {
        values = new ArrayList();
        if(path.indexOf("?") > 0 ) {
            hasValues = true;
            String[] words = path.substring(path.indexOf("=")+1,path.length()).split(",");
            for(String word : words){
                values.add(word);
            }
        }
        if(hasValues){
            this.endpoint = path.substring(0, path.indexOf("?"));
        }
        else{
            this.endpoint = path;
        }
    }

    /**
     * Gets the values that come as parameters in the url of this request
     * @return the values that come as parameters in the url of this request
     */
    public String getValues() {
        if (hasValues) {
            String valuesResponse = "";
            for(String x : values){
                valuesResponse = valuesResponse + x + " ,";
            }
            return valuesResponse.substring(0,valuesResponse.length()-1);
        }
        return "";
    }

    /**
     * Returns the endpoint of the request
     * @return the endpoint of the request
     */
    public String getEndpoint() {
        return endpoint;
    }

}
