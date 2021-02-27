package edu.eci;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

/**
 * Interface that represents the mapping of a request sent to a server
 */
public @interface RequestMapping {

    /**
     * Returns the value of the request
     * @return the value of the request
     */
    public String value();
}
