package edu.eci.nanospring;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)

/**
 * Annotation that represents a path value on a request
 */
public @interface PathVariable {
}