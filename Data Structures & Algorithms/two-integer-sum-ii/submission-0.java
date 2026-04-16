class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            int val = target - numbers[i];
            if (numMap.containsKey(val)) {
                res[0] = numMap.get(val) + 1;
                res[1] = i + 1;
                return res;
            }
            numMap.put(numbers[i], i);
        }
        return res;
    }
}
