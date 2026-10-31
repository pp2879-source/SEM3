import java.util.Scanner;

public class TravelBookingWithCommonFee {

    // Abstract base class handles the shared booking fee in one place.
    // If the fee changes, only this one line needs to change.
    static abstract class Booking {
        private static final double BOOKING_FEE = 50;

        abstract double calculateFare(double distanceKm);

        double calculateTotal(double distanceKm) {
            return calculateFare(distanceKm) + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        double calculateFare(double distanceKm) {
            return 2 * distanceKm;
        }
    }

    static class TrainBooking extends Booking {
        double calculateFare(double distanceKm) {
            return 1.5 * distanceKm;
        }
    }

    static class FlightBooking extends Booking {
        double calculateFare(double distanceKm) {
            return 2500 + 4 * distanceKm;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String mode = parts[0];
            double distanceKm = Double.parseDouble(parts[1]);

            Booking booking;
            switch (mode) {
                case "BUS":
                    booking = new BusBooking();
                    break;
                case "TRAIN":
                    booking = new TrainBooking();
                    break;
                case "FLIGHT":
                    booking = new FlightBooking();
                    break;
                default:
                    System.out.println("Unknown travel mode: " + mode);
                    continue;
            }

            double total = booking.calculateTotal(distanceKm);
            System.out.printf("%s: %.2f%n", mode, total);
        }

        sc.close();
    }
}
