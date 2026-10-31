import java.util.Scanner;

public class Problem03EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many integers? ");
        int n = sc.nextInt();

        int even = 0, odd = 0;
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            if (value % 2 == 0) even++;
            else odd++;
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
