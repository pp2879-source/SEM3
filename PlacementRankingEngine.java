import java.util.Arrays;

public class PlacementRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double compositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }
    }

    // Quick filter: strong CGPA alone is enough
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Combined filter: borderline CGPA can still qualify with a good coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && cgpa < 7.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count] = c;
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);
        Arrays.sort(finalList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            sb.append(i + 1).append(". ").append(finalList[i].name)
              .append(" (").append(String.format("%.1f", finalList[i].compositeScore())).append(")");

            if (i < finalList.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
