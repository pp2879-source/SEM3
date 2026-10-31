import java.util.Scanner;

public class Problem02WordReversePalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.next();

        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println("Reversed: " + reversed);
        System.out.println(word.equalsIgnoreCase(reversed)
                ? word + " - palindrome"
                : word + " - not a palindrome");
        sc.close();
    }
}
