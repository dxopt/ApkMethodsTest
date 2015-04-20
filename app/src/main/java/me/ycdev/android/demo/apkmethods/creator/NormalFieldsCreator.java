package me.ycdev.android.demo.apkmethods.creator;

import java.io.BufferedWriter;
import java.io.IOException;

public class NormalFieldsCreator extends ClassCreator {
    public NormalFieldsCreator(String classFilePath, String packageName, int memberCount) {
        super(classFilePath, packageName, memberCount);
    }

    @Override
    protected void createClassBody(BufferedWriter writer) throws IOException {
        for (int i = 0; i < mMemberCount; i++) {
            String fieldName = "field" + i;
            writer.write("    public String " + fieldName + ";\n\n");
        }
    }
}
