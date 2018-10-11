package ElementaryTasks.Task08;

public class FibonacciSequence{
    private int lowerBound;
    private int upperBound;
    private StringBuilder result;

    public FibonacciSequence(int lowerBound, int upperBound) {
       this.lowerBound = Math.min(lowerBound, upperBound);
       this.upperBound = Math.max(lowerBound, upperBound);
    }

    public void build() {
        int x = 0;
        int y = 1;
        int z = 0;

        if ((x >= lowerBound) && (x <= upperBound)) {
            result.append(x);
            result.append(", ");
        }
        if ((y >= lowerBound) && (y <= upperBound)) {
            result.append(y);
            result.append(", ");
        }
        do {
            z = x + y;
            if ((z >= lowerBound) && (z <= upperBound)) {
                result.append(z);
                result.append(", ");
            }
            x = y;
            y = z;

        } while (z <= upperBound);

    }

    @Override
    public String toString(){
        return result.toString();
    }
}

