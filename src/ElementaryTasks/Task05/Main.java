package ElementaryTasks.Task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws IOException {
        String regex = "\\d+";
        StringBuilder sourceString = new StringBuilder();
        //validation
        args[0] = args[0].replaceAll(" ", "");
        if ((args.length != 1) || (!args[0].matches(regex))) {
            System.out.println("You should enter a number as program argument");
        } else {
            sourceString.append(args[0]);
            for (int i = 0; i < sourceString.length() % 3; i++) {
                sourceString.insert(0, "0");
            }
            //Output
            NumberToStringConverter converter = new NumberToStringConverter(sourceString);
            System.out.println(converter.convertNumberToString());
        }
    }
}
