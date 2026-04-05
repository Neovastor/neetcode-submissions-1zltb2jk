class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair<Integer, Integer>> arr = new ArrayList<>();
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < position.length; i++){
            arr.add(new Pair(position[i], speed[i]));
        }
        int result = 0;
        arr.sort(Comparator.comparing(tuple -> tuple.getKey()));
        
        for (int i = arr.size() - 1; i >= 0; i--){
            Double temp =  (target - arr.get(i).getKey()) / (1.0 *arr.get(i).getValue());
            // if time <= head time become 1 group
            // if time > head time different group
            if (stack.isEmpty()){
                stack.add(temp);
                result++;

            } else if (temp.compareTo(stack.peek()) > 0) {
                stack.poll();
                stack.add(temp);
                result++;
            }            
        }
        return result;
    }

    
}
