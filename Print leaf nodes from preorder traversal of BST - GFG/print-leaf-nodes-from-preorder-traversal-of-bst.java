//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Node
{
    int data; 
    Node left, right;
    Node (int key)
    {
        data= key; left= right=null;
    }
}
//User function Template for Java
class Solution
{
    ArrayList<Integer> al = new ArrayList<>();
    
    public int[] leafNodes(int arr[], int N)
    {
        // code here
        //1
        int in[] = new int[N];
        for(int i=0;i<N; i++)
        in[i] = arr[i];
        
        Arrays.sort(in);
        
        //2
        Node root =  helper(0,0,N-1,arr, in);// make a tree from in and pre order
        
        //3
        printLeafNode(root);
        
        
        int ans[] = new int[al.size()];
        for(int i=0; i<al.size(); i++)
        {
            ans[i] = al.get(i);
        }
        
        return ans;
        
        
        
    }
   Node helper(int preStart, int inStart, int inEnd,  int[] preorder, int[] inorder)
    {
         if(preStart > preorder.length-1 || inStart > inEnd) return null; 
        
        Node root = new Node(preorder[preStart]);
        
        int inIndex =0;
        for(int i=inStart; i<=inEnd ;i++)
        {
            if(root.data == inorder[i])
            inIndex = i;
        }
        
        root.left =  helper(preStart+1, inStart, inIndex-1 , preorder, inorder);
        root.right =  helper(preStart+1 +inIndex -inStart , inIndex+1, inEnd, preorder, inorder);
        
        return root;
    }
     void printLeafNode(Node root)
        {
              
            // If node is null, return
            if (root == null)
                return;
              
            // If node is leaf node, print its data    
            if (root.left == null &&
                root.right == null)
            {
                al.add(root.data);
                return;
            }
              
           
            if (root.left != null)
                printLeafNode(root.left);
                  
           
            if (root.right != null)
                printLeafNode(root.right);
        }
}