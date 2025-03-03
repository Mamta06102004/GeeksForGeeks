//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == '('){
                op.push(ch);
            }
            else if(ch == ')'){
                while(!op.isEmpty() && op.peek() != '('){

                    char oper = op.pop();
                    String s2 = st.pop();
                    String s1 = st.pop();
                    
                    String temp = s1+s2+oper;
                    st.push(temp);
                }
                if (!op.isEmpty()){
                    op.pop();               // '(' is popped
                }
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
                while(op.size()>0 && prec(ch) <= prec(op.peek())){
                    char oper = op.pop();
                    String s2 = st.pop();
                    String s1 = st.pop();
                    
                    String temp = s1+s2+oper;
                    st.push(temp);
                }
                op.push(ch);
            }
            else{
                st.push(ch+"");
            }
            i++;
            
            
        }
        
        while(op.size()>0){
            char oper = op.pop();
            String s2 = st.pop();
            String s1 = st.pop();
            String temp = s1+s2+oper;
            st.push(temp);
        }
        
        return st.pop();
        
    }
    
    public static int prec(char ch){
        if(ch == '^') return 3;
        else if(ch =='*' || ch == '/') return 2;
        else if(ch =='+' || ch == '-') return 1;
        else return 0;
    
    }
    
}