class Solution {
    /*
    zxyzxyz
    sliding window
    left = 0;
    right = 0;
    initial
    left = 0;
    right = 2;
    "zxy"

    loop while left <= right && right < s length;
        right++
        z already exist, get last z index value = 0;
        left = map.get(z) + 1;

    result = Max(right - left + 1)    
    */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length() && !map.containsKey(s.charAt(right))){
            result = (right - left ) + 1;
            map.put(s.charAt(right), right);
            right++;
        }
        while (left <= right && right < s.length()){


            char rightCh = s.charAt(right);
            if (map.containsKey(rightCh)){
                left = Math.max(map.get(rightCh) + 1, left) ;
                map.put(rightCh, right);
                System.out.println(map);
            }
            int cur = (right - left) + 1;
            result = Math.max(result, cur);


            right++;
        }

        return result;
    }
}
