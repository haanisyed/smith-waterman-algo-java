import java.io.IOException;

public class Main {

    public static int[][] main(String sequence1, String sequence2, int matchScore, int mismatchScore, int gapPenalty) {
        int m = sequence1.length();
        int n = sequence2.length();

        // Create and initialize the scoring matrix
        int[][] matrix = new int[m + 1][n + 1];
        int maxScore = 0;
        int maxI = 0, maxJ = 0;

        // Fill the scoring matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int match = matrix[i - 1][j - 1] + (sequence1.charAt(i - 1) == sequence2.charAt(j - 1) ? matchScore : mismatchScore);
                int delete = matrix[i - 1][j] - gapPenalty;
                int insert = matrix[i][j - 1] - gapPenalty;

                matrix[i][j] = Math.max(0, Math.max(match, Math.max(delete, insert)));

                // Update maximum score and its position
                if (matrix[i][j] > maxScore) {
                    maxScore = matrix[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        // Traceback to find the alignment
        int i = maxI;
        int j = maxJ;
        while (i > 0 && j > 0 && matrix[i][j] > 0) {
            int currentScore = matrix[i][j];
            int diagonalScore = matrix[i - 1][j - 1];
            int leftScore = matrix[i][j - 1];
            int upScore = matrix[i - 1][j];

            if (currentScore == diagonalScore + (sequence1.charAt(i - 1) == sequence2.charAt(j - 1) ? matchScore : mismatchScore)) {
                // Diagonal move
                i--;
                j--;
            } else if (currentScore == leftScore - gapPenalty) {
                // Left move
                j--;
            } else {
                // Up move
                i--;
            }
        }

        // Return the scoring matrix
        return matrix;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\haani\\Desktop\\MPG\\GCA_000027325.1_ASM2732v1_genomic.fna";
        String sequence1 = read.readFastaFile(filePath);
        String sequence2 = "AGT";

        int matchScore = 2;
        int mismatchScore = -1;
        int gapPenalty = 2;

        int[][] matrix = main(sequence1, sequence2, matchScore, mismatchScore, gapPenalty);

        // Print the scoring matrix
        for (int i = 0; i <= sequence1.length(); i++) {
            for (int j = 0; j <= sequence2.length(); j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
