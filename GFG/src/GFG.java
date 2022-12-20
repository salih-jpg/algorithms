import java.util.Arrays;
import java.util.Map;


public class GFG {
    static class Box implements Comparable<Box> {

        int h, w, d, area;

        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }


        @Override
        public int compareTo(Box o) {
            return o.area - this.area;
        }
    }
    static int maxStackHeight(Box arr[], int n){
        Box[] rot = new Box[3*n];

        for(int i=0; i<n; i++){
            Box box = arr[i];

            rot[3*i] = new Box(box.h, Math.max(box.d, box.w),
                    Math.min(box.d, box.w));

            rot[(3*i) + 1] = new Box(box.d, Math.max((box.h), box.w),
                    Math.min(box.h, box.w));

            rot[(3*i) + 2] = new Box(box.w, Math.max(box.d, box.h),
                    Math.min(box.d, box.h));
        }

        for(int i=0; i< rot.length; i++)
            rot[i].area = rot[i].d*rot[i].w;

        //sorting respect to area in compareTo method
        Arrays.sort(rot);
        int count = 3*n;

        int[] msh = new int[count];
        for(int i=0; i<count; i++){
            msh[i] = rot[i].h;
        }

        for (int i=0; i< count; i++){
            msh[i] = 0;
            Box box = rot[i];
            int val = 0;
            for (int j=0; j< i; j++){
                Box prevBox = rot[j];
                if(box.w < prevBox.w && box.d < prevBox.d){
                    val = Math.max(val, msh[j]);
                }
            }
            msh[i] = val + box.h;
        }

        int max = -1;
        for (int i=0; i< count; i++){
            max = Math.max(max, msh[i]);
        }
        return max;
    }

    public static void main(String[] args) {

        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);

        System.out.println("The maximum possible "+
                "height of stack is " +
                maxStackHeight(arr,4));
    }
}


