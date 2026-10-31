import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {

    private static final Pattern LINE_PATTERN =
            Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$");

    // Each question type grades itself; the grader loop never needs to know
    // the grading rule for a specific type.
    static abstract class ExamQuestion {
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;

        ExamQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double calculateScore();
    }

    static class McqQuestion extends ExamQuestion {
        McqQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class TrueFalseQuestion extends ExamQuestion {
        TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class EssayQuestion extends ExamQuestion {
        EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        double calculateScore() {
            String[] keywords = correctAnswer.split(",");
            String lowerStudentAnswer = studentAnswer.toLowerCase();

            int matchedCount = 0;
            for (String keyword : keywords) {
                if (lowerStudentAnswer.contains(keyword.trim().toLowerCase())) {
                    matchedCount++;
                }
            }

            if (matchedCount >= 2) {
                return points * 0.75;
            } else if (matchedCount == 1) {
                return points * 0.50;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher matcher = LINE_PATTERN.matcher(line);

            if (!matcher.matches()) {
                System.out.println("Could not parse question line: " + line);
                continue;
            }

            String type = matcher.group(1);
            String questionText = matcher.group(2);
            String correctAnswer = matcher.group(3);
            String studentAnswer = matcher.group(4);
            double points = Double.parseDouble(matcher.group(5));

            ExamQuestion question;
            switch (type) {
                case "MCQ":
                    question = new McqQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "TF":
                    question = new TrueFalseQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "ESSAY":
                    question = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                default:
                    System.out.println("Unknown question type: " + type);
                    continue;
            }

            double score = question.calculateScore();
            totalScore += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        sc.close();
    }
}
