//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node search(Node root, int x) {
        if (root == null || root.data == x) return root;
        if (root.data > x) return search(root.left, x);
        return search(root.right, x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine());
            Node kNode = search(root, k);

            Solution g = new Solution();
            System.out.println(g.inorderSuccessor(root, kNode));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        // add code here.
        if (root == null || x == null) {
            return -1;  // If root or target node is null, return -1
        }

        Node successor = null;

        // Step 1: Find the node x in the BST
        while (root != null) {
            if (x.data < root.data) {
                successor = root; // possible successor
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // If the node x is not present in the tree
        if (successor == null) {
            return -1;
        }

        // Step 2: If right subtree exists, find the leftmost node in the right subtree
        if (x.right != null) {
            Node temp = x.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp.data;
        }

        // Step 3: If no right subtree, return the saved successor or -1
        return successor != null ? successor.data : -1;
    }
}