import org.junit.Test;

import java.util.List;

public class sort_ex {
    public static void main(String[] args) {

    }

    @Test
    public void testInsertSort() {
        int[] arr = {-1, 49, 38, 65, 97, 76, 13};   // arr[0]为哨兵
        insertSort(arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public void insertSort(int[] arr) {
        int i, j;
        for (i = 2; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                arr[0] = arr[i];
                for (j = i - 1; arr[0] < arr[j]; --j) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = arr[0];
            }
        }
    }
}
