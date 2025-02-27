package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Writer {
    private final String prefix;
    private final String path;
    private final boolean append;
    private boolean intwritted = false;
    private boolean floatwritted = false;
    private boolean stringwritted = false;

    Writer(String raw_path, String raw_prefix, boolean append) {
        prefix = raw_prefix;
        path = raw_path;
        this.append = append;
    }

    public void writeInt(String entity) {
        try {
            File file = new File(path + prefix + "integers.txt");
            if(!file.exists()) {
                Files.createDirectories(Paths.get(path));
                file.createNewFile();
            } else if (!append && !intwritted) {
                FileWriter fwInt = new FileWriter(file, false);
                fwInt.write("");
                fwInt.close();
            }

            FileWriter fwInt = new FileWriter(file, true);

            fwInt.write(entity + "\n");
            fwInt.close();
            this.intwritted = true;
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }

    public void writeFloat(String entity) {
        try {
            File file = new File(path + prefix + "floats.txt");
            if(!file.exists()) {
                Files.createDirectories(Paths.get(path));
                file.createNewFile();
            } else if (!append && !floatwritted) {
                FileWriter fwInt = new FileWriter(file, false);
                fwInt.write("");
                fwInt.close();
            }

            FileWriter fwFloat = new FileWriter(file, true);

            fwFloat.write(entity + "\n");
            fwFloat.close();
            floatwritted = true;
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }

    public void writeString(String entity) {
        try {
            File file = new File(path + prefix + "strings.txt");
            if(!file.exists()) {
                Files.createDirectories(Paths.get(path));
                file.createNewFile();
            } else if (!append && !stringwritted) {
                FileWriter fwInt = new FileWriter(file, false);
                fwInt.write("");
                fwInt.close();
            }

            FileWriter fwString = new FileWriter(file, true);

            fwString.write(entity + "\n");
            fwString.close();
            stringwritted = true;
        } catch (IOException ex) {
            System.out.println("Ошибка при создании файла");
            ex.printStackTrace();
        }
    }
}
