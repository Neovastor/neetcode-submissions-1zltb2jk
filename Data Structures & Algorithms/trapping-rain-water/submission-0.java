class Solution {
    public int trap(int[] height) {
        int[] maxFromLeft = new int[height.length];
        int[] maxFromRight = new int[height.length];
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < height.length; i++){
            maxLeft = Math.max(maxLeft, height[i]);
            maxRight = Math.max(maxRight, height[height.length - i - 1]);
            maxFromLeft[i] = maxLeft;
            maxFromRight[height.length - i - 1] = maxRight;
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++){
            int val = Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
            sum += val;
            
        }
        return sum;
    }
}
