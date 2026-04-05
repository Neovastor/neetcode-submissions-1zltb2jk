class Solution {
    // 30 38 30 36 35 40 28
    // 
    public int[] dailyTemperatures(int[] temperatures) {
       List<Integer> stack = new ArrayList<>();
       int[] result = new int[temperatures.length];
       for (int i = 0; i < temperatures.length; i++){
            for (int j = i+1; j < temperatures.length; j++){
                if (temperatures[j] > temperatures[i]){
                    result[i] = j - i;
                    break;
                }
            }      
       }
       return result; 
    }
}
