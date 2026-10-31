import java.util.Scanner;

public class Problem05DigitSumNumberReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        long number = sc.nextLong();

        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
            sc.close();
            return;
        }

        long temp = number, sum = 0, reversed = 0;
        do {
            long digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        } while (temp > 0);

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
        sc.close();
    }
}
