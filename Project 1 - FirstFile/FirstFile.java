import java.util.Scanner;

public class FirstFile {
    public static void main(String[] args) {
        double a = 0.0, b = 0.0, c = 0.0;
        Scanner input = new Scanner(System.in);
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        System.out.print(a + " " + b + " " + c);
    }
}