import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class testfile {

    static int[] numbers = new int[]{0, 50, 100, 150, 200, 250};

    public static void main(String[] args) throws IOException {

        int rows = 8;
        int columns = 8;
        int[][] array = new int[rows][columns];
        int randomNumber;
        int choice;

        // Generate a Random 8*8 Array For test File

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                randomNumber = new Random().nextInt(numbers.length);
                choice = numbers[randomNumber];
                array[i][j] = choice;
            }
        }

        // Print the Array

        for (int k = 0; k < rows; k++) {
            for (int p = 0; p < columns; p++) {
                System.out.print(array[k][p] + "   ");
            }
            System.out.println();
        }

        // Write The Array InTo a txt File

        BufferedWriter writer = new BufferedWriter(new FileWriter("arrayFile.txt"));
        for (int k = 0; k < rows; k++) {
            for (int p = 0; p < columns; p++) {
                writer.write(array[k][p] + " ");
            }
            writer.newLine();
        }
        writer.flush();

    }

    // Get Size Of The txt File

    static int n;

    static {
        try {
            n = (int) Files.size(Path.of("./arrayFile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



