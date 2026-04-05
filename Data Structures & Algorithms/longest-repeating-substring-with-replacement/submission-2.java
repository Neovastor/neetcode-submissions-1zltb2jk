class Solution {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        int maxRepeated = 0;
        while (right < s.length()){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxRepeated = Math.max(maxRepeated, map.get(s.charAt(right)));
            
            while ((right + 1 - left) - maxRepeated > k ){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right + 1 - left);
            right++;
        }
        return result;
    }
}
