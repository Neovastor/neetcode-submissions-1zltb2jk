class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> sets = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()){
            while (sets.contains(s.charAt(right))){
                sets.remove(s.charAt(left));
                left++;
            }
            sets.add(s.charAt(right)); 
            right++;
            result = Math.max(result, right - left);
        }

        return result;
    }
}
