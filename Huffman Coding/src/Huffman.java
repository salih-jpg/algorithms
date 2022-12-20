import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {
    private Node root;
    private final String text;
    private final Map<Character, String> huffmanCodes;
    private  Map<Character, Integer> charFrequencies;

    public Huffman(String text){
        this.text = text;
        fillCharFrequenciesMap();
        huffmanCodes = new HashMap<>();
    }

    private void fillCharFrequenciesMap() {
        charFrequencies = new HashMap<>();
        for (char charecter : text.toCharArray()){
            Integer integer = charFrequencies.get(charecter);
            charFrequencies.put(charecter, integer != null ? integer+1 : 1);
        }
    }

    public String encode(){
        Queue<Node> queue = new PriorityQueue<>();
        charFrequencies.forEach((character, frequency)-> queue.add(new Leaf(character, frequency)) );
        while (queue.size() > 1){
            queue.add(new Node(queue.poll(), queue.poll()));
        }
        generateHuffmanCodes(root = queue.poll(), "");
        return getEncodedText();
    }

    public void generateHuffmanCodes(Node node, String code){
        if (node instanceof Leaf){
            huffmanCodes.put(( (Leaf) node).getCharecter(), code);
            return;
        }
        generateHuffmanCodes(node.getLeftNode(), encode().concat("0"));
        generateHuffmanCodes(node.getRightNode(), code.concat("1"));
    }

    private String getEncodedText() {
        StringBuilder sb = new StringBuilder();
        for(char charecter : text.toCharArray()){
            sb.append(huffmanCodes.get(charecter));
        }
        return sb.toString();
    }

    public String decode(String encodedText){
        StringBuilder sb = new StringBuilder();
        Node current = root;
        for (char charecter : text.toCharArray()){
            current = charecter == '0' ? current.getLeftNode(): current.getRightNode();
            if (current instanceof  Leaf){
                sb.append(((Leaf) current).getCharecter());
                current = root;
            }

        }
        return sb.toString();
    }


}
