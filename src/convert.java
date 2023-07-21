import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;

public class convert extends Main {

    // Load Array From txt File Into an Array

    public static void convertFileToArray(int[][] myArray, int columns, int rows) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("./arrayFile.txt")));
        while (sc.hasNextLine()) {
            for (int i = 0; i < myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    myArray[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
    }

    // Load Brightnesses and Frequencies From The Array Then Just Print Them :)

    public static void getArrays(int[][] myArray, int columns, int rows) {
        int temporary = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                temporary = myArray[i][j];
                if (!brightness.contains(temporary)) {
                    brightness.add(temporary);
                } else if (brightness.contains(temporary)) {
                    continue;
                }
            }
        }
        Collections.sort(brightness);
        System.out.println("--------------------------------------");
        System.out.print("Brightnesses : ");
        for (int i = 0; i < brightness.size(); i++) {
            System.out.print(brightness.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                frequency[myArray[i][j]] += 1;
            }
        }
        System.out.print("Frequency : ");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                System.out.print(frequency[i] + " ");
            }
        }
        System.out.println();
        System.out.print("--------------------------------------");
    }






}
