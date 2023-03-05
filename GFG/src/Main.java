public class Main {
    public static void main(String[] args) {

        GFG.Box[] arr = new GFG.Box[4];
        arr[0] = new GFG.Box(4, 6, 7);
        arr[1] = new GFG.Box(1, 2, 3);
        arr[2] = new GFG.Box(4, 5, 6);
        arr[3] = new GFG.Box(10, 12, 32);

        System.out.println("The maximum possible "+
                "height of stack is " +
               GFG.maxStackHeight(arr,4));
    }
}