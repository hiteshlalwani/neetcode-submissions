class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        int left = 0, right = numbers.length-1;
        while (left < right) {
            long sum = (long)numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}
