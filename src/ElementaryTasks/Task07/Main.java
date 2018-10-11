package ElementaryTasks.Task07;

import ElementaryTasks.InputErrorsControl;

public class Main{
    public static void main(String[] args) {
        int numberOfArgumentsForControl = 1;
        int[] resArgsArray = null;
        //validation
        try {
            resArgsArray = InputErrorsControl.validateArrayOfIntegers(args, numberOfArgumentsForControl, 0, Integer.MAX_VALUE);
        } catch (Exception e) {
            System.out.printf("Program arguments error. %s\n", e.getMessage());
        }
        if (resArgsArray != null) {
            //creation and filling
            NumberSequence numberSequence = new NumberSequence(resArgsArray[0]);
            numberSequence.build();
            //output
            System.out.print(numberSequence);
        }
    }
}
