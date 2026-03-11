import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ComputeStatistics
 * -----------------
 * Reads integers from a file and computes basic statistics:
 * - Total numbers
 * - Summation
 * - Average (rounded)
 * - Minimum
 * - Maximum
 */
public class ComputeStatistics {

    /**
     * Computes and prints statistics for numbers in a file.
     *
     * @param filePath Path to the input file containing integers (one per line)
     */
    public static void computeStats(String filePath) {
        int total = 0;
        int sum = 0;
        Integer min = null;  // Use Integer to allow null initialization
        Integer max = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                int num;
                try {
                    num = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid number: " + line);
                    continue;
                }

                // Update statistics
                total++;
                sum += num;

                if (min == null || num < min) {
                    min = num;
                }
                if (max == null || num > max) {
                    max = num;
                }
            }

            // Handle empty file
            if (total == 0) {
                System.out.println("File is empty or contains no valid numbers.");
                return;
            }

            int average = Math.round((float) sum / total);

            // Print statistics
            System.out.println("----- Statistics -----");
            System.out.println("Total numbers : " + total);
            System.out.println("Summation     : " + sum);
            System.out.println("Average       : " + average);
            System.out.println("Minimum       : " + min);
            System.out.println("Maximum       : " + max);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // You can replace this with args[0] to accept command-line input
        String fileName = "random_nums.txt";

        computeStats(fileName);
    }
}