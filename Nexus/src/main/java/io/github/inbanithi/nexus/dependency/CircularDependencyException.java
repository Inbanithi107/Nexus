package io.github.inbanithi.nexus.dependency;

public class CircularDependencyException extends RuntimeException{

    public CircularDependencyException(String message){
        super(message);
    }

}
