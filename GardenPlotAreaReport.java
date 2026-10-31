import java.util.Scanner;

public class GardenPlotAreaReport {

    // Common base type for all plots. A new plot shape only needs its own
    // subclass - the reporting code below never changes.
    static abstract class Plot {
        protected String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double calculateArea();

        abstract String getShapeName();
    }

    static class CirclePlot extends Plot {
        private double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        double calculateArea() {
            return Math.PI * radius * radius;
        }

        String getShapeName() {
            return "CIRCLE";
        }
    }

    static class RectanglePlot extends Plot {
        private double length;
        private double width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        double calculateArea() {
            return length * width;
        }

        String getShapeName() {
            return "RECTANGLE";
        }
    }

    static class TrianglePlot extends Plot {
        private double base;
        private double height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        double calculateArea() {
            return 0.5 * base * height;
        }

        String getShapeName() {
            return "TRIANGLE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String shape = parts[0];
            String owner = parts[1];

            Plot plot;
            switch (shape) {
                case "CIRCLE":
                    plot = new CirclePlot(owner, Double.parseDouble(parts[2]));
                    break;
                case "RECTANGLE":
                    plot = new RectanglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                    break;
                case "TRIANGLE":
                    plot = new TrianglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                    break;
                default:
                    System.out.println("Unknown plot shape: " + shape);
                    continue;
            }

            double area = plot.calculateArea();
            totalArea += area;

            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.getShapeName(), area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}
