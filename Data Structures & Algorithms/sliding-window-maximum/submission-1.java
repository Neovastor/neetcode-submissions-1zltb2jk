class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Monotonic decreasing queue
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
                
        while (right < k){
            while (q.peekLast() != null && nums[right] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.add(right);

            right++;
        }

        result[left] = nums[q.peekFirst()]; 
        while (right < nums.length){
            //remove left
            if (nums[left] == nums[q.peekFirst()]){
                q.pollFirst();
            }
            while (q.peekLast() != null && nums[right] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.add(right);

            left++;
            result[left] = nums[q.peekFirst()]; 
            right++;
        }

        return result;
    }
}
