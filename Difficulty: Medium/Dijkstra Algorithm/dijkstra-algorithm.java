//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public class Pair implements Comparable <Pair> {
        int vtx, wsf;
        Pair(int vtx, int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }
        public int compareTo(Pair O){
            return this.wsf- O.wsf;
        }
    }
    public class Pair1{
        int v, wt;
        Pair1(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        int E = edges.length;
        List<List<Pair1>> ans = construction(edges, V, E);
        int[] myans = dijkstraDon(ans, src);
        return myans;
        
    }
    
    public int[] dijkstraDon(List<List<Pair1>> graph, int src){
        int V = graph.size();
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            if(ans[rem.vtx] != Integer.MAX_VALUE) continue;
            
            ans[rem.vtx] = rem.wsf;
            List<Pair1> nbrs = graph.get(rem.vtx);
            
            
            for(Pair1 n : nbrs){
                if(ans[n.v] != Integer.MAX_VALUE) continue;
                pq.add(new Pair(n.v, rem.wsf+n.wt));
            }
        }
        return ans;
    }
    
    public List<List<Pair1>> construction(int[][] edges, int V, int E){
        List<List<Pair1>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            graph.get(u).add(new Pair1(v, wt));
            graph.get(v).add(new Pair1(u, wt));
        }
        
        return graph;
    }
} 