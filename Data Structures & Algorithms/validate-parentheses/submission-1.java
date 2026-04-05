class Solution {
    //1. create map
    //2. create stack to check
    //3. iterate through s
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty()){
                    return false;
                }
                char lastCh = stack.pollLast();
                if (!map.get(ch).equals(lastCh)){
                    return false;
                }
            } else {
                stack.add(ch);
            }
        }
        
        return stack.isEmpty();

    }
}
