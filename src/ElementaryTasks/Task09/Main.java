package ElementaryTasks.Task09;

import ElementaryTasks.InputErrorsControl;

public class Main {
    public static void main(String[] args) {
        int numberOfArgumentsForControl = 2;
        int[] resArgsArray = null;

        //validation
        try {
            resArgsArray = InputErrorsControl.validateArrayOfIntegers(args, numberOfArgumentsForControl, 1, Integer.MAX_VALUE);
        } catch (Exception e) {
            System.out.printf("Program arguments error. %s\n", e.getMessage());
        }
        if (resArgsArray != null) {
            //creation and exponentiation
            QuickPow quickPow = new QuickPow(resArgsArray[0],resArgsArray[1]);
            quickPow.makeExponentiation();
            //output
            System.out.print(quickPow);
        }
    }
}

