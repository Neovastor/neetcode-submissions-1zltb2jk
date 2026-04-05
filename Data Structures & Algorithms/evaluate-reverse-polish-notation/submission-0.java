class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++){
            String token = tokens[i];
            
            if (stack.isEmpty()){
                stack.add(Integer.valueOf(token));
            } else if (token.equals("+")){
                int second = stack.pollLast();
                int first = stack.pollLast();
                
                stack.add(first + second);
            } else if (token.equals("-")){
                int second = stack.pollLast();
                int first = stack.pollLast();
                stack.add(first - second);

            } else if (token.equals("*")){
                int second = stack.pollLast();
                int first = stack.pollLast();
                stack.add(first * second);

            } else if (token.equals("/")){
                int second = stack.pollLast();
                int first = stack.pollLast();
                stack.add(first / second);

            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pollLast();
    }
}
