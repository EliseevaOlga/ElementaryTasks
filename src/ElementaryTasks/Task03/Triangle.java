package ElementaryTasks.Task03;

public class Triangle  implements Comparable<Triangle> {
    private String name;
    private double sideA;
    private double sideB;
    private double sideC;
    private double area;

    public Triangle(String name, double sideA, double sideB, double sideC) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        calculateArea();
    }

    private void calculateArea() {
        double p;
        p = (sideA + sideB + sideC) / 2;
        area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public double getArea() {
        return area;
    }

    public int compareTo(Triangle triangle) {
        if (this.area == triangle.area) {
            return -(this.name.compareTo(triangle.name));
        } else {
            return -Double.compare(this.area, triangle.area);
        }
    }

    @Override
    public String toString() {
        return String.format("[Triangle %s]: %.2f cm", name, area);
    }

}

