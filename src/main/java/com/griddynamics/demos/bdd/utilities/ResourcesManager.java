package com.griddynamics.demos.bdd.utilities;

import java.io.File;

public class ResourcesManager {

    private static ClassLoader classLoader;

    public ResourcesManager(){
        classLoader = getClass().getClassLoader();
    }

    public File getFile(String fileName){

        return new File(classLoader.getResource(fileName).getFile());
    }

    public String getFilePath(String fileName){
        return classLoader.getResource(fileName).getPath();
    }
}
