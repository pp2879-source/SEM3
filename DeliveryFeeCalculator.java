import java.util.Scanner;

public class DeliveryFeeCalculator {

    // NOTE: implemented exactly per the stated Business Rules ($1.00/kg for Express,
    // $2.00/kg for International). With those rates, EXPRESS 5 20 computes to 24.00
    // and INTERNATIONAL 20 100 30 computes to 145.00 (Total 184.00) - not the 29.00 /
    // 155.00 / 199.00 shown in the assignment's sample output. The STANDARD line
    // (15.00) does match. That looks like a typo in the assignment's sample, since
    // the rates as written are internally consistent; this code follows the written
    // rates. If your grader expects the sample's numbers exactly, the per-kg rates
    // would need to be $2.00 for Express and $2.50 for International instead -
    // double-check against your course's official answer key before submitting.

    static abstract class Delivery {
        protected double weight;
        protected double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {
        private double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        double calculateFee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            Delivery delivery;
            switch (type) {
                case "STANDARD":
                    delivery = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customsFee = Double.parseDouble(parts[3]);
                    delivery = new InternationalDelivery(weight, distance, customsFee);
                    break;
                default:
                    System.out.println("Unknown delivery type: " + type);
                    continue;
            }

            double fee = delivery.calculateFee();
            grandTotal += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
