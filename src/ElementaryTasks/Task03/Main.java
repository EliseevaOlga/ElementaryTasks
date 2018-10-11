package ElementaryTasks.Task03;

import ElementaryTasks.InputErrorsControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static TreeMap<Triangle, String> triangles = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String userAnswer = "y";

        do {
            //input and validation
            String[] validationResult = null;
            System.out.println("Enter triangle name and sides as <name>, <side1>, <side2>, <side3>: ");
            String triangleString = bufReader.readLine();
            try {
                validationResult = validateSidesAndName(triangleString);
            } catch (Exception e) {
                System.out.printf("Error. %s\n",e.getMessage());
            }
            if (validationResult != null) {
                //creation
                Triangle triangle = new Triangle(validationResult[0], Double.parseDouble(validationResult[1]),
                        Double.parseDouble(validationResult[2]), Double.parseDouble(validationResult[3]));
                triangles.put(triangle, validationResult[0]);
                System.out.println("Would you like to enter another triangle?");
                userAnswer = bufReader.readLine();
            }
        } while ((userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")));
        showList();
    }

    private static String[] validateSidesAndName(String sourceString) throws Exception {
        double[] dArgs = new double[3];
        String[] args = sourceString.split(",");
        args[0] = args[0].replaceAll(" ", "");
        args[0] = args[0].replaceAll("\t", "");
        if (args.length != 4) {
            throw new Exception("Number of arguments must be 4.");
        } else if (triangles.containsValue(args[0])) {
            throw new Exception("Name already exists.");
        } else {
            for (int i = 1; i < args.length; i++) {
                dArgs[i - 1] = InputErrorsControl.validateDouble(args[i], 0, Double.MAX_VALUE);
            }
        }
        if ((dArgs[0] + dArgs[1] <= dArgs[2]) ||
                (dArgs[0] + dArgs[2] <= dArgs[1]) ||
                (dArgs[1] + dArgs[2] <= dArgs[0])) {
            throw new Exception("It's not a triangle!");
        }
        return args;
    }

    private static void showList() {
        for (Map.Entry tr : triangles.entrySet()) {
            System.out.println(tr.getKey());
        }
    }
}

