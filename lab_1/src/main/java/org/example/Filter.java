package org.example;

import java.io.FileReader;
import java.io.IOException;

public class Filter {
    public void filter(String fileName, Writer writer) {
        try(FileReader reader = new FileReader(fileName))
        {
            int ch;
            String entity = "";
            while((ch=reader.read())!=-1){
                if(ch=='\n') {
                    String str = entity;
                    boolean isFloat = entity.matches("[0-9]*\\.[0-9]+");
                    if(isFloat) {
                        writer.writeFloat(str);
                        entity = "";
                        continue;
                    }

                    boolean isInt = entity.matches("[0-9]+");
                    if(isInt) {
                        writer.writeInt(str);
                        entity = "";
                        continue;
                    }

                    writer.writeString(entity);
                    entity = "";
                } else {
                    if(ch=='\r') {
                        continue;
                    }
                    entity += String.valueOf((char) ch);
                }
            }
            String str = entity;
            boolean isFloat = entity.matches("[0-9]*\\.[0-9]+");
            if(isFloat) {
                writer.writeFloat(str);
                entity = "";
                return;
            }

            boolean isInt = entity.matches("[0-9]+");
            if(isInt) {
                writer.writeInt(str);
                entity = "";
                return;
            }

            writer.writeString(entity);
            entity = "";
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
