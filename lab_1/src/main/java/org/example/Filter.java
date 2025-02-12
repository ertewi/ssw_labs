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
                    System.out.println(isInt);
                    if(isInt) {
                        writer.writeInt(str);
                        entity = "";
                        continue;
                    }

                    writer.writeString(str);
                    entity = "";
                } else {
                    entity += String.valueOf((char) ch);
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
