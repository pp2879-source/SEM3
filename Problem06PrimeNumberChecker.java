import java.util.Scanner;

public class Problem06PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer greater than 1: ");
        int number = sc.nextInt();

        boolean prime = number > 1;
        for (int i = 2; prime && i <= number / i; i++) {
            if (number % i == 0) prime = false;
        }

        System.out.println(number + (prime ? " is prime" : " is not prime"));
        sc.close();
    }
}
