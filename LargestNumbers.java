import java.util.ArrayList;
import java.util.Collections;

public class LargestNumbers {

    public static int[] findLargestNumbers(int[] arr, int m) {
        ArrayList<Integer> largestNumbers = new ArrayList<>(m);

        for (int num : arr) {
            if (largestNumbers.size() < m) {
                largestNumbers.add(num);
                Collections.sort(largestNumbers);
            } else if (num > largestNumbers.get(0)) {
                largestNumbers.set(0, num);
                Collections.sort(largestNumbers);
            }
        }

        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = largestNumbers.get(m - 1 - i);
        }

        return result;
    }

    public static void Demo(String[] args) {
        int[] arr = {7, 1, 2099, 45, 87, 25, 55, 79, 785, 810};
        int m = 3;

        int[] result = findLargestNumbers(arr, m);

        System.out.println("Los " + m + " números más grandes son:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Demo(args);
    }
}
