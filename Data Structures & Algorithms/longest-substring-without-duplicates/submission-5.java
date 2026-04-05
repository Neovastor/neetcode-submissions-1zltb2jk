class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()){            
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            right++;
            result = Math.max(result, right - left);
        }
        
        return result;
    }
}
