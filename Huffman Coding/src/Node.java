public class Node {
    private final int frequency;

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    private Node leftNode;
    private Node rightNode;

    public Node(Node leftNode, Node rightNode){
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }



    public int getFrequency() {
        return frequency;
    }

    public int compareTo(Node node){
        return Integer.compare(frequency, node.frequency);
    }
}


