//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> op = new Stack<>();

        int i = 0;
        while(i < post_exp.length()){
            char ch = post_exp.charAt(i);
            
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                
                    String s2 = op.pop();
                    String s1 = op.pop();
                    String temp = ch+s1+s2;
                    
                    op.push(temp);
                     
                
            }
            else{
                op.push(ch+"");
            }
            
            i++;
        }
        
        return op.pop();
    }
}
