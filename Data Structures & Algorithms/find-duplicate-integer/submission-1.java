class Solution {
    public int findDuplicate(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 0;

        while(true){
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];

            if (slowPointer == fastPointer){
                break;
            }
        }
        int slow2 = 0;
        while (nums[slowPointer] != nums[slow2]){
            slowPointer = nums[slowPointer];
            slow2 = nums[slow2];
        }
        return nums[slowPointer];
    }
}
