class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> curmap = new HashMap<>();
        
        int right = 0;
        int left = 0;

        int resultLeft = 0;
        int resultRight = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);            
        }

        int targetSize = map.size();
        int curTarget = 0;
        while (right < s.length()){

            char ch = s.charAt(right);
            curmap.put(ch, curmap.getOrDefault(ch, 0) + 1);            
            if (curmap.get(ch) == map.get(ch)){
                curTarget++;
            }
            
            while (left <= right && curTarget == targetSize){
                if (right - left < min){
                    min = right - left;
                    resultLeft = left;
                    resultRight = right + 1;
                }
                
                char leftCh = s.charAt(left);
                
                curmap.put(leftCh, curmap.getOrDefault(leftCh, 0) - 1);
                                        
                if (curmap.get(leftCh) < map.getOrDefault(leftCh, 0)) {
                    curTarget--;
                }
                left++;
            }    
            right++;
        }

        return s.substring(resultLeft, resultRight);
    }
}
