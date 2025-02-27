package org.example;

import java.util.Arrays;
import java.io.File;
import java.util.MissingFormatArgumentException;

public class MainParser {
    private String currentPath = new File("").getAbsolutePath();
    private String extra_path = "";
    private String prefix = "";
    private String stat_format = "none";
    boolean rewrite_result = false;
    String result_path = currentPath + File.separator + extra_path + File.separator;
    Filter filter = new Filter();
    Writer writer = new Writer(result_path, prefix, rewrite_result);

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
                this.result_path = currentPath + File.separator + extra_path + File.separator;
                this.writer = new Writer(result_path, prefix, rewrite_result);

            } else if (arg.equals("-p")) {
                if (++i < length) {
                    this.prefix = args[i];
                } else {
                    throw new MissingFormatArgumentException("-p requires an argument");
                }
                this.result_path = currentPath + File.separator + extra_path + File.separator;
                this.writer = new Writer(result_path, prefix, rewrite_result);

            } else if (arg.equals("-a")) {
                this.rewrite_result = true;

                this.result_path = currentPath + File.separator + extra_path + File.separator;
                this.writer = new Writer(result_path, prefix, rewrite_result);

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
                    if (extension.equals(".txt")) {
                        String file_path = currentPath + File.separator;
                        file_path = file_path + arg;

                        this.filter.filter(file_path, this.writer);

                        continue;
                    }
                }

                throw new UnsupportedOperationException("Unrecognized option: " + arg);
            }
        }

        System.out.println(Arrays.toString(args));
        System.out.println(currentPath);
    }

    private static String getFileExtension(String str) {
        int index = str.indexOf('.');
        return index == -1? null : str.substring(index);
    }
}
