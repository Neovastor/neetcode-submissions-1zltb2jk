class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = 0;
        for (int i: piles){
            max = Math.max(i, max);
        }

        int right =  max;
        int current = 0;
        int result = max;
        while (left <= right){
            int middle = (left + right) / 2;
            current = 0;
            for (int j  = 0; j < piles.length; j++){
                current += (int) Math.ceil((double) piles[j] / middle);
            }


            if (current <= h){
                result = Math.min(result, middle);
                right = middle - 1;
            } else { // current > h
                left = middle + 1;
            }
        }
        return result;
    }
}
