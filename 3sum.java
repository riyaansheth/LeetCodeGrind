import java.util.*;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(a, nums[left], nums[right]));
                    int lv = nums[left];
                    int rv = nums[right];
                    while (left < right && nums[left] == lv) left++;
                    while (left < right && nums[right] == rv) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);
        for (List<Integer> t : triplets) {
            System.out.println(t);
        }
    }
}
