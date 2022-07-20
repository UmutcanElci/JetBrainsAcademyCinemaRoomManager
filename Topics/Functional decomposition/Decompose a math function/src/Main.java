import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        //call your implemented methods here.
        double va = 0;
        if(x<= 0){
            va = f1(x);
        }

        if(0<x && x<1) {
            va = f2(x);
        }

        if(x>=1){
            va = f3(x);
        }
        return va;

    }

    //implement your methods here
    public static double f1(double x){
        double value = 0;
            value = (x*x) +1;
        return value;
    }

    public static double f2(double x){
        double value = 0;
            value = (1/(x*x));
        return value;
    }

    public static double f3(double x){
        double value = 0;
            value = (x*x) -1;
        return value;
    }
}