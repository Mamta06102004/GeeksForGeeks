//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // ITERATIVE APPROACH
        
        
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=W; j++){
                if(j == 0){
                    dp[i][j] = 0;
                }
                else if(i == 0){
                    if(j-wt[i] >= 0){
                        dp[i][j] = val[i];
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    if(j-wt[i]>=0){
                       dp[i][j] = Math.max(dp[i][j] ,dp[i-1][j-wt[i]] +val[i]);
                   }

                    // dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i]] + val[i]);
                }
            }
        }
        return dp[n-1][W];
        
        
        // RECURSIVE APPROACH
        
    //     int n = val.length;
    //     int[][] dp = new int[n][W+1];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j <= W; j++) {
    //             dp[i][j] = -1;
    //         }
    //     }
    //     return helperdon(val, wt, n-1, dp, W);
    // }
    // static int helperdon(int[] val, int[] wt, int i, int[][] dp, int k){
    //     if(i<0 || k==0) return 0;
    //     if(dp[i][k] != -1) return dp[i][k];
        
    //     int x = helperdon(val, wt, i-1, dp, k);         //exclude
    //     int y = 0;
    //     if(k >= wt[i]){
    //         y = helperdon(val, wt, i-1, dp, k-wt[i]) + val[i];      //include
    //     }
        
    //     dp[i][k] = Math.max(x, y);
    //     return Math.max(x, y);
    }
}
