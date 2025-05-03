//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // Step 1
        int V = adj.size();
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                dfs(adj, vis, st, i);
            }
        }
        
        // Step 2- Reverse graph
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph2.add(new ArrayList<>());
        }
        for(int u=0; u<V; u++){
            for(int v : adj.get(u)){
                graph2.get(v).add(u);
            }
        }
        
        // Step 3- DFS in order of stack
        int ans = 0;
        vis = new boolean[V];
        Stack<Integer> st2 = new Stack<>();
        while(st.size() > 0){
            int rem = st.pop();
            if(vis[rem] == false){
                dfs(graph2, vis, st2, rem);
                ans++;
            }
        }
        return ans;
        
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> st, int src){
        vis[src] = true;
        for(int nbr : graph.get(src)){
            if(vis[nbr] == false){
                dfs(graph, vis, st, nbr);
            }
        }
        st.push(src);                       //while returning
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends