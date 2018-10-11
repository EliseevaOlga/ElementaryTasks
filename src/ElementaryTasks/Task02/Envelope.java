package ElementaryTasks.Task02;

public class Envelope{
    private String name;
    private double sideA;
    private double sideB;

    public Envelope(String name, double sideA, double sideB) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public String toString() {
        return name;
    }

// source of formula: https://www.jstor.org/stable/2691523?seq=1#page_scan_tab_contents
    public boolean canInclude(Envelope envelope) {
        if ((envelope.sideA >= this.sideA) && (envelope.sideB >= this.sideB)) {
            return false;
        } else if (((envelope.sideA < this.sideA) && (envelope.sideB < this.sideB))
                || ((envelope.sideB < this.sideA) && (envelope.sideA < this.sideB))) {
            return true;
        } else {
            double p = Math.max(envelope.sideA, envelope.sideB);
            double q = Math.min(envelope.sideA, envelope.sideB);
            double a = Math.max(this.sideA, this.sideB);
            double b = Math.min(this.sideA, this.sideB);
            if ((p > a) &&
                    (2 * p * q * a + (Math.pow(p, 2) - Math.pow(q, 2)) * Math.sqrt(Math.pow(p, 2) + Math.pow(q, 2) - Math.pow(a, 2)))
                            / (Math.pow(p, 2) + Math.pow(q, 2)) < b) {
                return true;
            } else {
                return false;
            }

        }
    }

}
