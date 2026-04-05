class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++){
            List<Integer> temp = new ArrayList<>();
            adjList.add(temp);
        }

        for (int i = 0; i < edges.length; i++){
            int source = edges[i][0];
            int target = edges[i][1];
            adjList.get(source).add(target);
            adjList.get(target).add(source);

        }

        int count = 0;
        for (int i = 0; i < n; i++){
            if (!visited.contains(i)){
                count++;
                dfs(adjList, i, visited);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> list, int index, Set<Integer> visited) {
        if (visited.contains(index)){
            return;
        }

        visited.add(index);
        
        for (int i = 0; i < list.get(index).size(); i++){
            dfs(list, list.get(index).get(i), visited); 
        }
        return ;
    }
}
