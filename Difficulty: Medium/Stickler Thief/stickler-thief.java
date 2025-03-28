//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        
        return helperdon(arr, arr.length-1, dp);
    }
    public int helperdon(int[] arr, int i, int[] dp){
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        
        int x = helperdon(arr, i-1, dp);    
        int y = helperdon(arr, i-2, dp) + arr[i];
        
        dp[i] = Math.max(x, y);
        return Math.max(x, y);
    }
}