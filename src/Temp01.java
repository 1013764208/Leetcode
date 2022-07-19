import java.awt.image.BandedSampleModel;
import java.sql.Array;
import java.util.*;
import java.util.List;

/**
 * @author HXS.NN
 */
public class Temp01 {
    public static void main(String[] args) {

        Temp01 temp01 = new Temp01();
        int[] number = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = temp01.threeSum(number);
        System.out.println(lists);


    }


    // 使用 HashMap (双列)，需要使用Map，Key 存储值，value 存储位置
    // 优点：直接定位，无需遍历，如何做到：使用HashCode
//    public int[] twoSum(int[] numbers, int target) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (in   t i = 0; i < numbers.length; i++) {
//            if (hashMap.containsKey(target - numbers[i])) {
//                return new int[]{i, hashMap.get(target - numbers[i])};
//            }
//            hashMap.put(numbers[i], i);
//        }
//        return new int[0];
//    }


//    public int maxProduct(String[] words) {
//
//        int ans = 0;
//        for (int i = 0; i < words.length; i++) {
//            String w1 = words[i];
//            for (int j = 0; j < words.length; j++) {
//                String w2 = words[j];
//                if (!hashSameChar(w1, w2)) {
//                    ans = Math.max(ans, w1.length() * w2.length());
//                }
//            }
//        }
//        return ans;
//    }

//    // word1, word2 间比较
//    private boolean hashSameChar(String word1, String word2) {
//        for (char c : word1.toCharArray()) {
//            if (word2.indexOf(c) != -1) {
//                return true;
//            }
//        }
//        return false;
//    }


    //    public int singleNumber(int[] nums) {
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int ans = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int num = entry.getKey();
//            int occ = entry.getValue();
//            if (occ == 1) {
//                ans = num;
//                break;
//
//            }
//        }
//        return ans;
//    }

    /**
     * 题目：只出现一次的数字
     * 思路：使用hashmap双列，(元素，出现次数)
     */
    public int singleNumber(int[] nums) {

        // 创建Hashmap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 将数组元素放到map中
        for (int num : nums) {
            // (如果map没有包含这个元素，则用默认值；如果包含则num)+1
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // 遍历map
        // entrySet:返回所有key-value对构成的Set集合
        // for 遍历entrySet
        // 返回值 ans
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer num = entry.getKey();
            Integer occ = entry.getValue();
            // 如果map.value==1，则取值
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }


    /**
     * 题目：排序数组中两个数组之和
     * 方法：使用HashMap双列存储(元素，Index)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int number : numbers) {
            map.put(number, i);
            i++;
        }

        int[] ans = new int[2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int key = entry.getKey();
            int ins = entry.getValue();
            if (map.containsKey(target - key)) {
                ans[0] = ins;
                ans[1] = map.get(target - key);
                break;
            }
        }
        return ans;
    }


    /**
     * 数组中和为0的三个数
     * a+c=-c
     */
    public List<List<Integer>> threeSum(int[] nums) {

        // 此处用Hashset的原因，可以快速查找数列是否包含（a+c）
        HashSet<Integer> set = new HashSet<>();

        // 此HashSet用于去重
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-1 * (nums[i] + nums[j]))) {
                    ArrayList<Integer> son = new ArrayList<>();
                    son.add(nums[i]);
                    son.add(nums[j]);
                    son.add(-1 * (nums[i] + nums[j]));
                    // 此时对数列进行排序，如果不排序，[0,1,-1],[-1,0,1] 无法去重
                    son.sort(Integer::compareTo);
                    ans.add(son);
                } else {
                    set.add(nums[i]);
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList(ans);
    }


    /**
     * 单词长度的最大乘积
     */
    public int maxProduct(String[] words) {

        int ans = 0;

        // 取数列中第一个字符
        for (int i = 0; i < words.length; i++) {
            String w1 = words[i];


            // 取数列中第二个字符
            for (int j = 0; j < words.length; j++) {
                String w2 = words[j];

                // w1,w2 比较
                if (!hashSameChar(w1, w2)) {
                    ans = Math.max(ans, w1.length() * w2.length());
                }
            }
        }
        return ans;
    }

    // word1, word2 间比较，若包含则turn，否则false
    private boolean hashSameChar(String word1, String word2) {

        // toCharArray: String转换为字符序列后返回字符的Array
        for (char c : word1.toCharArray()) {
            // indexOf: 方法可返回某个指定的字符串值在字符串中首次出现的位置
            if (word2.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

}