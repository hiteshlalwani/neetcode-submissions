class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Set<String> ops = Set.of("+", "-", "/", "*");
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (ops.contains(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(eval(op1, op2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int eval(int op1, int op2, String op) {
        return switch(op) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "/" -> op1 / op2;
            case "*" -> op1 * op2;
            default -> 0;
        };
    }
}
