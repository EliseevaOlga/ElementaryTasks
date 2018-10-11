/*
 * 2018/10/04
 *
 * Copyright (c) Olga Eliseeva
 *
 * */

package ElementaryTasks;

/**
 * Class InputErrorsControl implements control of user data input
 *
 * @author Olga Eliseeva
 */

public class InputErrorsControl {
    public static int validateInteger(String arg, int lowerBound, int upperBound) throws Exception {
        int result = Integer.parseInt(arg);
        if ((result < lowerBound) || (result > upperBound)) {
            throw new Exception(String.format("Argument '%s' must be greater than %s and smaller then %s",
                    arg, lowerBound, upperBound));
        }
        return result;
    }

    public static double validateDouble(String arg, double lowerBound, double upperBound) throws Exception {
        double result = Double.parseDouble(arg);
        if ((result <= lowerBound) || (result > upperBound)) {
            throw new Exception(String.format("Argument '%s' must be greater than %s and smaller then %s",
                    arg, lowerBound, upperBound));
        }
        return result;
    }

    public static int[] validateArrayOfIntegers(String[] arg, int capacity, int lowerBound, int upperBound) throws Exception {
        if (arg.length != capacity) {
            throw new Exception(String.format("Number of arguments must be %d", capacity));
        }
        int[] resultArray = new int[capacity];
        for (int i = 0; i < arg.length; i++) {
            resultArray[i] = validateInteger(arg[i], lowerBound, upperBound);
        }
        return resultArray;
    }

    public static double[] validateArrayOfDoubles(String[] arg, int capacity, double lowerBound, double upperBound) throws Exception {
        if (arg.length != capacity) {
            throw new Exception(String.format("Number of arguments must be %d", capacity));
        }
        double[] resultArray = new double[capacity];
        for (int i = 0; i < arg.length; i++) {
            resultArray[i] = validateDouble(arg[i], lowerBound, upperBound);
        }
        return resultArray;
    }
}
