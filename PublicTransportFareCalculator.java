import java.util.Scanner;

public class PublicTransportFareCalculator {

    // Common operation (calculateFare) with distinct per-transport pricing logic.
    static abstract class Transport {
        abstract double calculateFare(double distance);
    }

    static class Bus extends Transport {
        double calculateFare(double distance) {
            double fare = 2 + 0.10 * distance;
            return Math.min(fare, 10);
        }
    }

    static class Train extends Transport {
        double calculateFare(double distance) {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        private double peakHourFactor;

        Metro(double peakHourFactor) {
            this.peakHourFactor = peakHourFactor;
        }

        double calculateFare(double distance) {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            Transport transport;
            switch (type) {
                case "BUS":
                    transport = new Bus();
                    break;
                case "TRAIN":
                    transport = new Train();
                    break;
                case "METRO":
                    double peakHourFactor = Double.parseDouble(parts[2]);
                    transport = new Metro(peakHourFactor);
                    break;
                default:
                    System.out.println("Unknown transport type: " + type);
                    continue;
            }

            double fare = transport.calculateFare(distance);
            grandTotal += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
