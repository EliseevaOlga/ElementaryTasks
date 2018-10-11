package ElementaryTasks.Task02;

import ElementaryTasks.InputErrorsControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        double[] sidesArray = new double[4];
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String userAnswer = null;
        do {
            //input and validation
            for (int i = 0; i < 4; i++) {
                System.out.printf("Enter the %d side of %d envelope: ", (i%2 + 1)  , (i / 2 + 1));
                try {
                    sidesArray[i] = InputErrorsControl.validateDouble(bufReader.readLine(), 0, Double.MAX_VALUE);
                } catch (Exception e) {
                    System.out.printf("Error. %s. Let's try again!\n", e.getMessage());
                    i--;
                }
            }
            //creation and comparing
            Envelope envelope1 = new Envelope("First", sidesArray[0], sidesArray[1]);
            Envelope envelope2 = new Envelope("Second", sidesArray[2], sidesArray[3]);
            printResultOfComparison(envelope1, envelope2);

            //going to next cycle if necessary
            System.out.println("Would you like to continue?");
            userAnswer = bufReader.readLine();
        } while ((userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")));
    }



    private static void printResultOfComparison(Envelope e1, Envelope e2) {
        if (e1.canInclude(e2)) {
            System.out.printf("%s envelope can be placed in %s \n", e2, e1);
        } else if (e2.canInclude(e1)) {
            System.out.printf("%s envelope can be placed in %s \n", e1, e2);
        } else {
            System.out.println("Envelopes can't be placed into each other");
        }
    }




}
