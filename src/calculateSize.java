public class calculateSize extends Main {

    // Calculating Size Of Compress File Version

    public static int calculateCompressVersionSize() {
        int size = 0;
        for (int i = 0; i < lengthOfHuffmanCode.size(); ) {
            for (int j = 0; j < frequency.length; j++) {
                if (frequency[j] != 0) {
                    size = (lengthOfHuffmanCode.get(i) * frequency[j]) + size;
                    i++;
                }
            }
        }
        return size;
    }

}
