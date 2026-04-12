class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //decreasing monotonic queue
        Deque<Integer> q = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++){
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(i);

            if (i >= k -1){
                while (!q.isEmpty() && q.peekFirst() <= i - k){
                    q.pollFirst();
                }
                result[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return result;
    }
}
