import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class read {
    public static void main(String[] args) {
        try {
            // Replace "path/to/genome.fna" with the actual path to your FASTA file
            String filePath = "C:\\Users\\haani\\Desktop\\MPG\\GCA_000027325.1_ASM2732v1_genomic.fna";

            // Read the FASTA file
            String genomeSequence = readFastaFile(filePath);

            // Now you can use the genomeSequence string in your algorithm
            System.out.println(genomeSequence);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFastaFile(String filePath) throws IOException {
        StringBuilder sequenceBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                // Skip header line starting with '>'
                if (isFirstLine && line.startsWith(">")) {
                    isFirstLine = false;
                    continue;
                }

                // Append sequence lines
                sequenceBuilder.append(line.trim());
            }
        }

        return sequenceBuilder.toString();
    }
}
