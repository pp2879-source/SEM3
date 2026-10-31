import java.util.Scanner;

public class ElectricityConnectionBilling {

    // Base type defines the common units property and an abstract calculateBill().
    static abstract class Connection {
        protected double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(double units) {
            super(units);
        }

        double calculateBill() {
            if (units <= 100) {
                return units * 5;
            }
            return 100 * 5 + (units - 100) * 7;
        }
    }

    static class ShopConnection extends Connection {
        ShopConnection(double units) {
            super(units);
        }

        double calculateBill() {
            return units * 8 + 100;
        }
    }

    static class FactoryConnection extends Connection {
        FactoryConnection(double units) {
            super(units);
        }

        double calculateBill() {
            return Math.max(units * 6, 1000);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double units = Double.parseDouble(parts[1]);

            Connection connection;
            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;
                case "SHOP":
                    connection = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;
                default:
                    System.out.println("Unknown connection type: " + type);
                    continue;
            }

            double bill = connection.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
