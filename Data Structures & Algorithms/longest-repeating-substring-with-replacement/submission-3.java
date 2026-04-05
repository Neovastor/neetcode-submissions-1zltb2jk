class Solution {
    public int characterReplacement(String s, int k) {
        int right = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int maxRepeatingChar = 0;
        while (right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1 );            
            maxRepeatingChar = findMaxRepeatingChar(map);

            while ((right + 1 - left) - maxRepeatingChar > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1 );    
                maxRepeatingChar = findMaxRepeatingChar(map);
                left++;
            }


            result = Math.max(result, right + 1 - left);

            right++;
        }

        return result;
    }
    private int findMaxRepeatingChar(Map<Character, Integer> map){
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
        return max;
    }
}
