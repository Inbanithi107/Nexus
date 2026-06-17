package io.github.inbanithi.nexus.dependency;

public class MissingModuleDependencyException extends RuntimeException{
    public MissingModuleDependencyException(String dependency) {
        super("Module: "+dependency+" is missing");
    }
}
