import java.io.*;
import java.util.*;
import java.util.HashMap;

public class Main {

    static Node root;
    static ArrayList<Integer> brightness = new ArrayList<>();
    static int frequency[] = new int[256];
    static HashMap<Integer, String> map = new HashMap<>();
    static ArrayList<Integer> lengthOfHuffmanCode = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        int rows = 8;
        int columns = 8;
        int[][] testArray = new int[rows][columns];

        convert.convertFileToArray(testArray, columns, rows);

        // Printing The Array

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(testArray[i][j] + "  ");
            }
            System.out.println();
        }


        convert.getArrays(testArray, columns, rows);

        // Calculating Time Of buildTree and Generating Huffman Code (Encoding)

        long startTime = System.currentTimeMillis();

        buildTree.buildTree(brightness.size(), brightness);
        Encode_Decode.encode(root, "", map);

        long finishTime = System.currentTimeMillis();

        System.out.println("\nHuffman build time: " + (int) (finishTime - startTime) + "s");
        System.out.println("--------------------------------------");


        // Printing Huffman codes Of Brightnesses

        System.out.println("encode : " + map);
        System.out.println("--------------------------------------");

        // Printing Brightness's Value Of Huffman codes

        System.out.println("decode : " + Encode_Decode.decode(root, map));
        System.out.println("--------------------------------------");


        // Calculating Length Of Huffman Codes

        String[] values = map.values().toArray(new String[0]);

        for (int i = 0; i < values.length; i++) {
            lengthOfHuffmanCode.add(values[i].length());
        }

        // Calculating Rate of Compression

        int primarysize = testfile.n;
        int compressSize = calculateSize.calculateCompressVersionSize();

        System.out.println("Primary Size : " + primarysize);
        System.out.println("Compress Size : " + compressSize);

        float Difference = ((float) (primarysize - compressSize) / primarysize) * 100;
        System.out.printf("Rate Of Compression :  %.3f", Difference);

    }
}

