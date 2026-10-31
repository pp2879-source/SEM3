import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {

    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    // Common attributes/operation (getDueDate); each item type only needs
    // to know its own borrowing period.
    static abstract class LibraryItem {
        protected String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowingDays();

        LocalDate getDueDate() {
            return CURRENT_DATE.plusDays(getBorrowingDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 14;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String rest = line.substring(firstSpace + 1).trim();
            String title = rest.substring(1, rest.length() - 1); // strip surrounding quotes

            LibraryItem item;
            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new Dvd(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    System.out.println("Unknown item type: " + type);
                    continue;
            }

            System.out.println(item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}
