class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n-1; i >= 0; --i) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = (!stack.isEmpty()) ? stack.peek() - i : 0;
            stack.push(i);
        }
        return res;
    }
}
