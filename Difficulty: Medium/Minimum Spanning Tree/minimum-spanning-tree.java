//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair implements Comparable <Pair> {
    int vtx, wt;
        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }
        public int compareTo(Pair O){
            return this.wt- O.wt;
        }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            int u = rem.vtx;
            
            if(vis[u] == true) continue;
            vis[u] = true;
            for (int[] nbr : adj.get(u)) {
                int v = nbr[0];
                int weight = nbr[1];

                if (!vis[v] && weight < ans[v]) {
                    ans[v] = weight;
                    pq.add(new Pair(v, weight));
                }
            }
            
        }
        int sum = 0;
        for(int weight : ans){
            sum += weight;
        }
        return sum;

        
    }
}