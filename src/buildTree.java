import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class buildTree extends Main {

    // Create MinHeap Then Build The tree

    public static void buildTree(int n, ArrayList<Integer> brightness) throws FileNotFoundException {

        class MyComparator implements Comparator<Node> {
            public int compare(Node firstMin, Node secondMin) {

                return firstMin.frequency - secondMin.frequency;
            }
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>(n, new MyComparator());

        // Create Node Then Add To MinHeap

        for (int i = 0; i < brightness.size(); i++) {
            Node node = new Node();
            node.brightness = brightness.get(i);
            node.frequency = frequency[brightness.get(i)];
            node.left = null;
            node.right = null;
            minHeap.add(node);
        }

        // 1. Sum Up Smallest And The Second Smallest's Frequencies Then Add It To The Frequency Of a New Node
        // 2. Put The Smallest As Left And The Second Smallest As Right child Of New Node
        // 3. Add New Node To The MinHeap

        while (minHeap.size() > 1) {
            Node firstMin = minHeap.peek();
            minHeap.poll();
            Node secondMin = minHeap.peek();
            minHeap.poll();
            Node internalNode = new Node();
            internalNode.frequency = firstMin.frequency + secondMin.frequency;
            internalNode.brightness = '-';
            internalNode.left = firstMin;
            internalNode.right = secondMin;
            root = internalNode;
            minHeap.add(internalNode);
        }
    }
}
