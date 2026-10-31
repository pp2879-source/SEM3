import java.util.Scanner;

public class Problem10StudentResultCard {
    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int total = 0;
            for (int mark : marks) total += mark;
            return (double) total / marks.length;
        }

        char grade() {
            double avg = average();
            if (avg >= 90) return 'A';
            if (avg >= 75) return 'B';
            if (avg >= 60) return 'C';
            if (avg >= 40) return 'D';
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students: ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Student name: ");
            String name = sc.next();

            int[] marks = new int[3];
            System.out.println("Enter 3 marks (0-100):");
            for (int j = 0; j < marks.length; j++) {
                int mark = sc.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.print("Invalid mark. Enter again: ");
                    j--;
                } else {
                    marks[j] = mark;
                }
            }

            Student student = new Student(name, marks);
            System.out.printf("%s: Average %.1f, Grade %c%n",
                    student.name.toUpperCase(), student.average(), student.grade());
        }
        sc.close();
    }
}
