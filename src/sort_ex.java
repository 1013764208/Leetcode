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


    // 直接插入
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

    public void binsertSort(int[] arr) {
        for (int i = 2; i < arr.length; i++) {

        }
    }

    @Test
    public void search_test() {
        int[] nums = {-1, 1, 3, 5, 7, 8, 9, 11};
        System.out.println(search(nums, 9));
    }

    // 二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;   // 默认除法向下取整

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }
        return -1;
    }

    @Test
    public void find_test() {
        int nums[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(Find(7, nums));
    }


    // 暴力循环
//    public boolean Find(int target, int[][] array) {
//
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                if (target == array[i][j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // 二分查找，对每行数据进行二分查找
    public boolean Find(int target, int[][] array) {
        for (int[] ints : array) {
            if (search(ints,target)!=-1){
                return true;
            }
        }
        return false;
    }
}
