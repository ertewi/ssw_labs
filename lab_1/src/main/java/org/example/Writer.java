package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final String prefix;
    private final String path;

    Writer(String raw_path, String raw_prefix) {
        prefix = raw_prefix;
        path = raw_path;
    }

    public void writeInt(String entity) {
        try {
            File file = new File(path + prefix + "integers.txt");
            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fwInt = new FileWriter(file, true);

            fwInt.write(entity);
            fwInt.close();
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }

    public void writeFloat(String entity) {
        try {
            File file = new File(path + prefix + "floats.txt");
            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fwFloat = new FileWriter(file, true);

            fwFloat.write(entity);
            fwFloat.close();
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }

    public void writeString(String entity) {
        try {
            File file = new File(path + prefix + "strings.txt");
            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fwString = new FileWriter(file, true);

            fwString.write(entity);
            fwString.close();
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }
}
