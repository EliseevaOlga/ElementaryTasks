package ElementaryTasks.Task06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.function.Predicate;

public class LuckyTicketsCounter {
    private Predicate<Integer> condition;
    private int lowerBound;
    private int upperBound;
    private int ticketsCount;


    public LuckyTicketsCounter(int lowerBound, int upperBound, Predicate condition){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.condition = condition;
    }

    private int returnNumberAtPosition(int number, int position) {
        return (int) (number % Math.pow(10, position + 1) - number % Math.pow(10, position)) / (int) Math.pow(10, position);
    }

    private boolean compareSum(int number) {
        int sum1 = 0;
        int sum2 = 0;
        int tempNum = 0;
        for (int j = 0; j < 6; j++) {
            tempNum = returnNumberAtPosition(number, j);
            if (condition.test(j)){
                sum1 += tempNum;
            } else {
                sum2 += tempNum;
            }
        }
        return (sum1 == sum2);
    }

    public void countTickets(){
        for (int i=lowerBound; i<=upperBound; i++){
            ticketsCount += compareSum(i) ? 1 : 0;
        }
    }

    @Override
    public String toString(){
        return String.format("Lucky tickets count is %s", ticketsCount);
    }
}