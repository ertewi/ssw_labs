package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final String prefix;
    private final String path;
    private FileWriter fwInt;
    private FileWriter fwFloat;
    private FileWriter fwString;

    Writer(String raw_path, String raw_prefix) {
        prefix = raw_prefix;
        path = raw_path;
    }

    public void writeInt(String entity) {
        try {
            if (fwInt == null) {
                File file = new File(path + prefix + "integers.txt");
                file.createNewFile();

                fwInt = new FileWriter(file);
            }
            fwInt.write(entity);
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }

    public void writeFloat(String entity) {
        try {
            if (fwInt == null) {
                File file = new File(path + prefix + "floats.txt");
                file.createNewFile();

                fwInt = new FileWriter(file);
            }
            fwInt.write(entity);
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }

    public void writeString(String entity) {
        try {
            if (fwInt == null) {
                File file = new File(path + prefix + "strings.txt");
                file.createNewFile();

                fwInt = new FileWriter(file);
            }
            fwInt.write(entity);
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }

    protected void finalize() throws Throwable {
        fwInt.close();
        fwFloat.close();
        fwString.close();
    }
}
