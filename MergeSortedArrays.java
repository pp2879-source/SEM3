import java.util.Arrays;

public class MergeSortedArrays {

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1a = {1, 3, 5};
        int[] arr2a = {2, 4, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1a, arr2a)));

        int[] arr1b = {};
        int[] arr2b = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1b, arr2b)));
    }
}
