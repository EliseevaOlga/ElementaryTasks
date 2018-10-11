package ElementaryTasks.Task01;

import ElementaryTasks.InputErrorsControl;

public class Main {
    public static void main(String[] args) {
        int numberOfArgumentsForControl = 2;
        int[] resArgsArray = null;
        //validation
        try {
            resArgsArray = InputErrorsControl.validateArrayOfIntegers(args, numberOfArgumentsForControl,1, Integer.MAX_VALUE);
        }catch (Exception e){
            System.out.printf("Program arguments error. %s\n", e.getMessage());
        }
        if (resArgsArray!=null) {
            //creation and filling
            Chessboard chessboard = new Chessboard(resArgsArray[0], resArgsArray[1]);
            chessboard.fillChessboard();
            //output
            System.out.print(chessboard);
        }
    }

}
