package ElementaryTasks.Task07;

public class NumberSequence {
    private int upperBound;
    private StringBuilder result;

    public NumberSequence(int upperBound) {
        this.upperBound = upperBound;
    }

    public void build() {
        result = new StringBuilder();
        for (int i = 0; i < upperBound; i++) {
            if (Math.pow(i, 2) < upperBound) {
                result.append(String.format("%s",i));
                result.append(", ");
            } else {
                break;
            }
        }
    }

    @Override
    public String toString(){
        return result.toString();
    }
}


