package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        try{
            MainParser parser = new MainParser();
            parser.parse(args);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}