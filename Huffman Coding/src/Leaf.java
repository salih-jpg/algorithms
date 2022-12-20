public class Leaf extends Node{
    public char getCharecter() {
        return charecter;
    }

    private final char charecter;

    public Leaf(char charecter, int frequency){
        super(frequency);
        this.charecter = charecter;

    }

}
