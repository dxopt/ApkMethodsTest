package me.ycdev.android.demo.apkmethods.creator;

import java.io.File;

public class TestClassCreatorExecutor {
    public static void main(String[] args) {
        String moduleRootDir = args[0];
        System.out.println("Modufle dir: " + moduleRootDir);

        // create classes for the flavor "normalMethods"
        createNormalMethodsClass(moduleRootDir);

        // create classes for the flavor "staticMethods"
        createStaticMethodsClass(moduleRootDir);

        // create classes for the flavor "abstractMethods"
        createAbstractMethodsClass(moduleRootDir);
    }

    private static void createNormalMethodsClass(String moduleRootDir) {
        String packageName = "me.ycdev.android.demo.apkmethods.impl";
        String folderPath = moduleRootDir + "/src/normalMethods/java/me/ycdev/android/demo" +
                "/apkmethods/impl/";
        removeFolderFiles(folderPath);

        for (int i = 0; i < 10; i++) {
            String classPath = folderPath + "NormalMethods" + i + ".java";
            ClassCreator creator = new NormalMethodsCreator(classPath, packageName, 10000);
            creator.createClass();
        }

        for (int i = 0; i < 10; i++) {
            String classPath = folderPath + "StaticFields" + i + ".java";
            ClassCreator creator = new NormalFieldsCreator(classPath, packageName, 10000);
            creator.createClass();
        }
    }

    private static void createStaticMethodsClass(String moduleRootDir) {
        String packageName = "me.ycdev.android.demo.apkmethods.impl";
        String folderPath = moduleRootDir + "/src/staticMethods/java/me/ycdev/android/demo" +
                "/apkmethods/impl/";
        removeFolderFiles(folderPath);

        for (int i = 0; i < 5; i++) {
            String classPath = folderPath + "StaticMethods" + i + ".java";
            ClassCreator creator = new StaticMethodsCreator(classPath, packageName, 10000);
            creator.createClass();
        }

        for (int i = 0; i < 5; i++) {
            String classPath = folderPath + "StaticFields" + i + ".java";
            ClassCreator creator = new StaticFieldsCreator(classPath, packageName, 10000);
            creator.createClass();
        }
    }

    private static void createAbstractMethodsClass(String moduleRootDir) {
        String packageName = "me.ycdev.android.demo.apkmethods.impl";
        String folderPath = moduleRootDir + "/src/abstractMethods/java/me/ycdev/android/demo" +
                "/apkmethods/impl/";
        removeFolderFiles(folderPath);

        for (int i = 0; i < 5; i++) {
            String classPath = folderPath + "AbstractMethods" + i + ".java";
            ClassCreator creator = new AbstractMethodsCreator(classPath, packageName, 10000);
            creator.createClass();
        }

        for (int i = 0; i < 5; i++) {
            String classPath = folderPath + "StaticFields" + i + ".java";
            ClassCreator creator = new StaticFieldsCreator(classPath, packageName, 10000);
            creator.createClass();
        }
    }

    private static void removeFolderFiles(String folderPath) {
        File folderFile = new File(folderPath);
        File[] filesList = folderFile.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                file.delete();
            }
        }
    }
}
