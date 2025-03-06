//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    // Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        if(head.next == null) return head;
        
        Node m = mid(head);
        Node h2 = m.next;
        m.next = null;
        
        Node t1 = mergeSort(head);
        Node t2 = mergeSort(h2);
        Node t3 = merge(t1, t2);
        return t3;
        
    }
    
    static Node mid(Node h){
        Node s = h, f = h;
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        
        return s;
    }
    
    static Node merge(Node head1, Node head2) {
        Node ans = null, t = null;
        if(head1.data < head2.data){
            ans = head1;
            t = head1;
            head1 = head1.next;
        }
        else{
            ans = head2;
            t = head2;
            head2 = head2.next;
        }
        
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                t.next = head1;
                t = t.next;
                head1 = head1.next;
            }
            else{
                t.next = head2;
                t = t.next;
                head2 = head2.next;
            }
        }
        
        if(head1 != null){
            t.next = head1;
        }
        if(head2 != null){
            t.next = head2;
        }
        
        return ans;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends