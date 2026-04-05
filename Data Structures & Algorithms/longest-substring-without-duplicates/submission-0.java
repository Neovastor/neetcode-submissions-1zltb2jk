class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> temp = new HashSet<>();


        while (right < s.length()){            
            if (temp.contains(s.charAt(right))){
                while(left < right && temp.contains(s.charAt(right))){
                    temp.remove(s.charAt(left));
                
                    left++;
                }
            } else {
                temp.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - left);            

        }
        return max;
    }
}
