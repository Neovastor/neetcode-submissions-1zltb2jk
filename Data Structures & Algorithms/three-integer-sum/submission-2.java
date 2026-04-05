class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
    
        for (int i = 0; i < nums.length; i++){
            if (i >0 && nums[i-1] == nums[i]){
                continue;
            }
            //a + b + c = 0 
            int left = i + 1;
            int right = nums.length - 1;
            
 
            while (left < right && right < nums.length){
                
                int sum = nums[i] + nums[left] + nums[right]; 
                
                if (sum == 0){
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    do{ 
                        left++;
                    } while(left < right && nums[left-1] == nums[left]);
                                            
                    
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
       
        }
        return result;
    }

}
