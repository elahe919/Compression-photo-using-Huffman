import java.util.HashMap;

class Encode_Decode {

    // Encoding Given Brightnesses => Generating Huffman Code

    public static void encode(Node root, String encode, HashMap<Integer, String> map) {
        if (root.left == null && root.right == null) {
            map.put(root.brightness, encode);
            return;
        }
        encode(root.left, encode + "0", map);
        encode(root.right, encode + "1", map);
    }

    // Decoding Generated Huffman Codes

    public static String decode(Node root, HashMap<Integer, String> map) {

        String decode = "";
        Node current = root;
        String[] values = map.values().toArray(new String[0]);

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < values[i].length(); j++) {
                if (values[i].charAt(j) == '0')
                    current = current.left;
                else
                    current = current.right;

                if (current.left == null && current.right == null) {
                    decode += current.brightness + " ";
                    current = root;
                }
            }
        }
        return decode;
    }


}