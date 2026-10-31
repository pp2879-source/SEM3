import java.util.Scanner;

public class LibraryLateFineCounter {

    // Common base type that mandates a fine calculation method.
    static abstract class LibraryItem {
        protected String title;
        protected int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double calculateFine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return 2 * daysLate;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return Math.min(5 * daysLate, 50);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return 1 * daysLate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);

            LibraryItem item;
            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;
                case "DVD":
                    item = new Dvd(title, daysLate);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;
                default:
                    System.out.println("Unknown item type: " + type);
                    continue;
            }

            double fine = item.calculateFine();
            totalFines += fine;

            System.out.printf("%s: %.2f%n", title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}
