package ElementaryTasks.Task09;

public class QuickPow{
    private int basis;
    private int power;
    private long result;
    private StringBuilder log;

    public QuickPow(int basis, int pow) {
        this.basis = basis;
        this.power = pow;
    }


     private long pow (int a, int b) {
        long temp;
            if (b == 0){
                return 1;
            }
            else if (b % 2 == 1) {
                temp = pow(a, b - 1);
                log.append(String.format("%s * %s\n",temp,a));
                return temp * a;
            }
            else {
                temp = pow (a, b/2);
                log.append(String.format("%s * %s\n",temp,temp));
                return temp * temp;
            }
        }

    public void makeExponentiation() {
        log = new StringBuilder();
        result = pow(basis, power);
    }

    @Override
    public String toString(){
        return String.format("Result is %s.\nLog:\n%s",result, log.toString());
    }
}
