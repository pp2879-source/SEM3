public class ScorecardDemo {

    static class Scorecard {
        private final boolean[] results;
        private int answeredCount;

        public Scorecard(int totalQuestions) {
            this.results = new boolean[totalQuestions];
            this.answeredCount = 0;
        }

        public void recordAnswer(boolean isCorrect) {
            if (answeredCount >= results.length) {
                System.out.println("Recording rejected: all questions already answered");
                return;
            }
            results[answeredCount] = isCorrect;
            answeredCount++;
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < answeredCount; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
