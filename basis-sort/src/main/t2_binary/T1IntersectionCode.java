package t2_binary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cmz
 * @date 2021-06-05 22:14
 */

public class T1IntersectionCode {

    public static int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int[] nums = nums1.length > nums2.length ? nums2 : nums1;

        int[] numl = nums == nums1 ? nums2 : nums1;

        HashSet<Integer> set = new HashSet<>(numl.length);
        for (int i : numl) {
            set.add(i);
        }
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        Iterator<Integer> iterator = result.stream().iterator();
        int cur = 0;
        while (iterator.hasNext()) {
            ans[cur] = iterator.next();
            cur++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
