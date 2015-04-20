package me.ycdev.android.demo.apkmethods.creator;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class ClassCreator {
    protected String mClassFilePath;
    protected String mPackageName;
    protected int mMemberCount;

    public ClassCreator(String classFilePath, String packageName, int memberCount) {
        mClassFilePath = classFilePath;
        mPackageName = packageName;
        mMemberCount = memberCount;
    }

    public void createClass() {
        BufferedWriter writer = null;
        try {
            File classFile = new File(mClassFilePath);
            classFile.getParentFile().mkdirs();

            String className = getClassNameFromPath(classFile.getName());
            writer = new BufferedWriter(new FileWriter(mClassFilePath));
            writer.write("package " + mPackageName + ";\n\n");
            if (isInterface()) {
                writer.write("public interface " + className + " {\n");
            } else if (isAbstract()) {
                writer.write("public abstract class " + className + " {\n");
            } else {
                writer.write("public class " + className + " {\n");
            }

            createClassBody(writer);

            writer.write("}\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(writer);
        }
    }

    private String getClassNameFromPath(String fileName) {
        int endIndex = fileName.lastIndexOf(".");
        return fileName.substring(0, endIndex);
    }

    private static void closeQuietly(Closeable target) {
        if (target != null) {
            try {
                target.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean isInterface() {
        return false;
    }

    protected boolean isAbstract() {
        return false;
    }

    protected abstract void createClassBody(BufferedWriter writer) throws IOException;
}
