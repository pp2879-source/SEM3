import java.util.Scanner;

public class PaymentSystemFeeCalculation {

    // Each payment type applies its own fee calculation; the main loop
    // processes every transaction the same way, regardless of type.
    static abstract class PaymentMethod {
        abstract double calculateFee(double amount);

        double calculateAdjustedAmount(double amount) {
            return amount + calculateFee(amount);
        }
    }

    static class CardPayment extends PaymentMethod {
        double calculateFee(double amount) {
            return amount * 0.02;
        }
    }

    static class WalletPayment extends PaymentMethod {
        double calculateFee(double amount) {
            return amount * 0.01;
        }
    }

    static class BankTransferPayment extends PaymentMethod {
        double calculateFee(double amount) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            PaymentMethod method;
            switch (type) {
                case "CARD":
                    method = new CardPayment();
                    break;
                case "WALLET":
                    method = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    method = new BankTransferPayment();
                    break;
                default:
                    System.out.println("Unknown payment type: " + type);
                    continue;
            }

            double adjusted = method.calculateAdjustedAmount(amount);
            grandTotal += adjusted;

            System.out.printf("%s: %.2f%n", type, adjusted);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
