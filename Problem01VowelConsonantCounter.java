import java.util.Scanner;

public class Problem01VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter one word: ");
        String word = sc.next();

        int vowels = 0, consonants = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else if (Character.isLetter(ch)) consonants++;
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        sc.close();
    }
}
