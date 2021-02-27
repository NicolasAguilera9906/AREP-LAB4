package edu.eci.nanospring;

/**
 * Class representing my own http request
 */
public class MyCustomResponse {

    private String path;
    private int responseStatus;

    /**
     * Class constructor, initialize the response path
     * @param path response path
     */
    public MyCustomResponse(String path) {
        this.path = path;
    }

    /**
     * Get the path of the response
     * @return the path of the response
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path of the response
     * @param path the path of the response
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the response status of the response
     * @return the response status of the response
     */
    public int getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the response status of the response
     * @param responseStatus the response status of the response
     */
    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }
}
