import java.util.Scanner;

public class WeeklyStaffPay {

    // Abstract: a generic "staff member" with no pay rule can never be created.
    static abstract class Staff {
        protected String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double calculatePay();
    }

    static class FullTimeStaff extends Staff {
        private double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        double calculatePay() {
            return weeklySalary;
        }
    }

    static class HourlyStaff extends Staff {
        private double hours;
        private double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double calculatePay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        private double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];

            Staff staff;
            switch (type) {
                case "FULLTIME":
                    staff = new FullTimeStaff(name, Double.parseDouble(parts[2]));
                    break;
                case "HOURLY":
                    staff = new HourlyStaff(name, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                    break;
                case "INTERN":
                    staff = new Intern(name, Double.parseDouble(parts[2]));
                    break;
                default:
                    System.out.println("Unknown staff type: " + type);
                    continue;
            }

            double pay = staff.calculatePay();
            totalPayroll += pay;

            System.out.printf("%s: %.2f%n", name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
