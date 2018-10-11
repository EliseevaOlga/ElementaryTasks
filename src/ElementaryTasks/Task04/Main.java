package ElementaryTasks.Task04;

import java.io.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        File file = null;
        //validation
        if ((args.length != 2) && (args.length != 3)) {
            System.out.println("You should enter program arguments:\n 1 - file name\n 2 - string to find\n 3 - string to replace if necessary");
        } else {
            file = new File(args[0]);
            if (file.exists()) {
                //Parsing and output
                FileParser fileParser = new FileParser(file);
                String errMessage = fileParser.readFile();
                if (errMessage == null) {
                    if (args.length == 2) {
                        System.out.printf("Number of occurrences of '%s' in file is %d", args[1], fileParser.findAndReplace(args[1]));
                    } else {
                        if (fileParser.findAndReplace(args[1],args[2]) > 0) {
                            System.out.println(fileParser.writeFile());
                        }
                    }
                } else {
                    System.out.println(errMessage);
                }
            } else {
                System.out.println("File doesn't exist");
            }
        }
    }
}


