class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();        
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++){
            int source = edges[i][0];
            int target = edges[i][1];
            adjList.get(source).add(target);
            adjList.get(target).add(source);
        }
        
        if (!recursive(0, -1, adjList, visited)){
            return false;
        }

        return visited.size() == n;
    }

    public boolean recursive(int current, int previous, List<List<Integer>> adjList, Set<Integer> visited){
        if (visited.contains(current)){
            return false;
        }
        visited.add(current);
        List<Integer> neighbors = adjList.get(current);

        for (int i = 0; i < neighbors.size(); i++){
            Integer nei = neighbors.get(i);
            if (nei == previous){
                continue;
            }
            
            boolean temp = recursive(nei, current, adjList, visited);
            if (!temp){
                return false;
            }
            
        }
        return true;
    }


}
