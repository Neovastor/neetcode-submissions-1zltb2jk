class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        int result = n;
        for (int i = 0; i < edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            result -= union(node1 , node2, parent, rank);
        }
        return result;
    }

    private int union(int node1, int node2, int[] parent, int[] rank){        
        int root1 = findParent(node1, parent);
        int root2 = findParent(node2, parent);
        if (root1 != root2){
            if (rank[root1] > rank[root2]){
                parent[root2] = root1;
                rank[root1] += rank[root2];
            } else {
                parent[root1] = root2; 
                rank[root2] += rank[root1];

            }

            return 1;
        }
        return 0;
    }

    private int findParent(int node, int[] parent){
        if (parent[node] != node){
            parent[node] = findParent(parent[node], parent);
        }
        return parent[node];        
    }
}

