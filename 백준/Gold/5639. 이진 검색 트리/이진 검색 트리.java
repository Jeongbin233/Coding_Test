import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] tree;
    static class Node{
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n < this.num){
                if(this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            }
            else{
                if(this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }//insert
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true){
            String str = br.readLine();
            if(str == null || str.equals(""))
                break;
            int node = Integer.parseInt(str);
            root.insert(node);
        }
        postorder(root);
    }//main

    private static void postorder(Node node){
        if(node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.num);
    }//postorder
}
/*
           50
       30      98
     24  45  52  60
   5  28
 */