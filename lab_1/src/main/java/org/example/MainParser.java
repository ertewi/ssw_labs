package org.example;

import java.util.Arrays;
import java.io.File;
import java.util.MissingFormatArgumentException;

public class MainParser {
    String extra_path = "";
    String prefix = "";
    String stat_format = "none";
    boolean rewrite_result = true;

    public void parse(String[] args) {
        int length = args.length;

        for (int i = 0; i < length; i++) {
            String arg = args[i];

            if (arg.equals("-o")) {
                if (++i < length) {
                    this.extra_path = args[i];
                } else {
                    throw new MissingFormatArgumentException("-o requires an argument");
                }

            } else if (arg.equals("-p")) {
                if (++i < length) {
                    this.prefix = args[i];
                } else {
                    throw new MissingFormatArgumentException("-o requires an argument");
                }

            } else if (arg.equals("-a")) {
                this.rewrite_result = false;

            } else if (arg.equals("-s")) {
                if (this.stat_format.equals("none")) {
                    this.stat_format = "short";
                } else {
                    throw new IllegalArgumentException("format argument is already set");
                }

            } else if (arg.equals("-f")) {
                if (this.stat_format.equals("none")) {
                    this.stat_format = "full";
                } else {
                    throw new IllegalArgumentException("format argument is already set");
                }

            } else {
                String extension = getFileExtension(arg);
                if (extension != null) {
                    if (extension.equals("txt")) {
                        // создать обьект для фильтрации содержимого, затем обьект по записи в файлы, предусмотреть возможность буфера

                        continue;
                    }
                }

                throw new UnsupportedOperationException("Unrecognized option: " + arg);
            }
        }

        String currentPath = new File(".").getAbsolutePath();

        System.out.println(Arrays.toString(args));
        System.out.println(currentPath);
    }

    private static String getFileExtension(String str) {
        int index = str.indexOf('.');
        return index == -1? null : str.substring(index);
    }
}
