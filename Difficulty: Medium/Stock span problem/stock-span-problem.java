//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(st.size()>0 && arr[i] > arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = idx-i;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            int idx = st.pop();
            ans[idx] = idx+1;
        }
        
        ArrayList<Integer> anslist = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            anslist.add(ans[i]);
        }
        return anslist;
        
    }
}