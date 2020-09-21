import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

public class LinearBinary {
    public static void main(String[] args) {
        StringBuilder line1 = new StringBuilder();
        StringBuilder xaxis = new StringBuilder();

        int max = 100;
        for (int y = 1; y < max; y++) {
            int size = 1000 * y;

            int list[] = new int[size];
            for (int i = 0; i < size; i++) {
                list[i] = i;
            }
            int key = new Random().nextInt(size-1);
            long startTime = System.nanoTime();
            for (int z=0;z<10000;z++){
                int f = linearSearch(list, key);
            }
            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            line1.append(elapsedTime/10000).append(" ");
            xaxis.append(size).append(" ");

        }
        System.out.println(line1);

        System.out.println(xaxis);

    }


    public static int linearSearch(int arr[], int x) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
                // If x is smaller, ignore right half
            else
                r = m - 1;
        }
        // if we reach here, then element was
        // not present
        return -1;
    }
}
