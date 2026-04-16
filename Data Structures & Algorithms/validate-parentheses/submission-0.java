class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenMap = new HashMap<>();
        parenMap.put('{', '}');
        parenMap.put('[', ']');
        parenMap.put('(', ')');

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (parenMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || parenMap.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
