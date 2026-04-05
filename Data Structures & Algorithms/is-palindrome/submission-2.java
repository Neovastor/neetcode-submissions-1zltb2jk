class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length() / 2;
        List<Character> chars = new ArrayList<>();
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if ((cur -'a' >= 0 && cur -'a' < 26) || (cur -'0' >= 0 && cur -'0' <= 9)){
                chars.add(cur);
            } 
             
        }

        for (int i = 0; i < (chars.size() / 2); i++){
            if (!chars.get(i).equals(chars.get(chars.size() -i - 1)) ){
                return false;
            } 
             
        }
        return true;
    }
}
