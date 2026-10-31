import java.util.Scanner;

public class Problem07FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer (0-20): ");
        int n = sc.nextInt();

        if (n < 0 || n > 20) {
            System.out.println("Enter a value from 0 to 20.");
        } else {
            long factorial = 1;
            for (int i = 1; i <= n; i++) factorial *= i;
            System.out.println(factorial);
        }
        sc.close();
    }
}
