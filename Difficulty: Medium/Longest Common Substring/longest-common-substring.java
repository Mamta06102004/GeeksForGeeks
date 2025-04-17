//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        int maxlen = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }
        return maxlen;
    }
}