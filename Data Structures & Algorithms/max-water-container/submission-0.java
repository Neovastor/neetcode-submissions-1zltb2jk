class Solution {
    public int maxArea(int[] heights) {
       int left = 0;
       int right = heights.length - 1;

       int max = 0;
       while (left < right){
            int cur = Math.min(heights[right] , heights[left]) * (right - left);
            max = Math.max(max, cur);
            if (heights[right] > heights[left]){
                left++;
            } else {
                right--;
            }
       } 
       return max;
    }
}
