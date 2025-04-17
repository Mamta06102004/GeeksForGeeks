//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		
System.out.println("~");
}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        long ea = 0, eb = 0, ec = 0;
        long mod = 1000000007;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                ea = (ea * 2 + 1)% mod;
            }
            else if(s.charAt(i) == 'b'){
                eb = (eb * 2 + ea)% mod;
            }
            else{
                ec = (ec * 2 + eb)% mod;
            }
        }
        return (int)ec;
    }
}