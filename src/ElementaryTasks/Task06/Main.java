package ElementaryTasks.Task06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.function.Predicate;

public class Main {
    static Predicate<Integer> condition = null;
    static HashMap<String, Predicate<Integer>> algs = new HashMap<>(3);
    static {
        algs.put("MOSKOW", j -> j < 3);
        algs.put("PITER", j -> j % 2 == 0);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You should enter a file name as program argument");
        } else {
            String errMessage = readFile(args[0]);
            if (errMessage == null) {
                LuckyTicketsCounter luckyTicketsCounter = new LuckyTicketsCounter(0, 999999, condition);
                luckyTicketsCounter.countTickets();
                System.out.println(luckyTicketsCounter);
            } else {
                System.out.println(errMessage);
            }
        }
    }

    private static String readFile(String path) {
        String s = null;
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((s = br.readLine()) != null) {
                result.append(s);
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        s = result.toString();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\uFEFF", "");
        s = s.toUpperCase();
        condition = algs.get(s);
        if (condition == null) {
            return String.format("Unknown algorithm name %s", s);
        } else {
            return null;
        }

    }


}

