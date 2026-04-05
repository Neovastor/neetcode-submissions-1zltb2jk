class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int curMax = 0;
        int min = prices[0];
        for (int price: prices){
            if (price < min){
                min = price;
            } 
            curMax = price - min;
            result = Math.max(result, curMax);
        }
        return result;
    }
}
