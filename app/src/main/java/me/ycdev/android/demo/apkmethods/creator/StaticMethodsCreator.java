package me.ycdev.android.demo.apkmethods.creator;

import java.io.BufferedWriter;
import java.io.IOException;

public class StaticMethodsCreator extends ClassCreator {
    public StaticMethodsCreator(String classFilePath, String packageName, int memberCount) {
        super(classFilePath, packageName, memberCount);
    }

    @Override
    protected void createClassBody(BufferedWriter writer) throws IOException {
        for (int i = 0; i < mMemberCount; i++) {
            String methodName = "method" + i;
            writer.write("    public static void " + methodName + "() {\n");
            writer.write("        System.out.print(\"hello: " + methodName + "\");\n");
            writer.write("    }\n\n");
        }
    }
}
