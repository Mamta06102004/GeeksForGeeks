//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s1 = read.readLine();
            String s2 = read.readLine();
            String s3 = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(s1, s2, s3));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    int LCSof3(String s1, String s2, String s3) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        int[][][] dp = new int[n1][n2][n3];
        for(int[][] row :dp){
            for(int[] subrow :row){
                Arrays.fill(subrow, -1);
            }
        }
        
        return lcsdon(s1, n1-1, s2, n2-1, s3, n3-1, dp);
    }
    
    int lcsdon(String s1, int i, String s2, int j, String s3, int k, int[][][] dp){
        if(i == -1 || j == -1 || k == -1) return 0;
        
        if(dp[i][j][k] != -1) return dp[i][j][k];
        
        if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
            int x = lcsdon(s1, i-1, s2, j-1, s3, k-1, dp);
            dp[i][j][k] = x+1;
            return x+1;
        }
        else{
            int x = lcsdon(s1, i-1, s2, j, s3, k, dp);
            int y = lcsdon(s1, i, s2, j-1, s3, k, dp);
            int z = lcsdon(s1, i, s2, j, s3, k-1, dp);
            dp[i][j][k] = Math.max(Math.max(x,y), z);
            return Math.max(Math.max(x,y), z);
        }
    }
}