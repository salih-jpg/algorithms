public class Main {
    public static void main(String[] args) {
        Huffman gustavo = new Huffman( "oh hello welcome to los pollos hermanos my name is gustavo but you can call me gus");
        String encodedText = gustavo.encode();
        System.out.println(encodedText);

        String originalText = gustavo.decode(encodedText);
        System.out.println(originalText);
    }
}