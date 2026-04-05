class Solution {
    public int largestRectangleArea(int[] heights) {
        // monotonic increasing stack
        Deque<List<Integer>> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            int height = heights[i];
            if (stack.isEmpty()){
                stack.add(List.of(i, height));
            } else {
                int leftIndex = i;
                while (!stack.isEmpty() && height < stack.peekLast().get(1)){
                    List<Integer> cur = stack.pollLast();
                    leftIndex = cur.get(0);
                    maxArea = Math.max(maxArea, (i - cur.get(0)) * cur.get(1));
                }
                stack.addLast(List.of(leftIndex, height) );
            }
        }

        while (!stack.isEmpty()){
            List<Integer> cur = stack.pollLast();
            maxArea = Math.max(maxArea, (heights.length - cur.get(0)) * cur.get(1));

        }
        return maxArea;
    }
}
