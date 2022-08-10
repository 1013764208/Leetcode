import org.junit.Test;

public class int_ex {

    public static void main(String[] args) {

    }

    @Test
    public void compare_test() {
        int[] arr = {-5, 3, 2, 3};
        System.out.println(compare(arr));
    }

    /**
     * 未出现最小正整数 {-5,3,2,3} res:1
     */
    public int compare(int[] arrs) {

        int[] compare = new int[arrs.length];
        int max = 100;

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 1; j < max; j++) {
                if (arrs[i] != j) {
                    return j;
                }
            }
        }
        return -1;
    }
}
