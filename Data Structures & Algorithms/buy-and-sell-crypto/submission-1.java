class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = prices[0];
        for (int price: prices){
            int current = price - min;
            min = Math.min(min, price);
            if (current > result){
                result = current; 
            }
        }
        return result;
    }
}
