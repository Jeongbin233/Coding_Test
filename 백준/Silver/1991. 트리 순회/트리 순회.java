import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new int[n+1][2];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A' + 1;
            int left = st.nextToken().charAt(0) - 'A' + 1;
            int right = st.nextToken().charAt(0) - 'A' + 1;


            tree[root][0] = left;
            tree[root][1] = right;
        }

        boolean[] visited = new boolean[n+1];
        preorder(1, visited);
        System.out.println();
        visited = new boolean[n+1];
        inorder(1, visited);
        System.out.println();
        visited = new boolean[n+1];
        postorder(1, visited);
    }//main
    private static void preorder(int node, boolean[] visited){
        visited[node] = true;
        System.out.print((char) (node-1+'A'));

        if(tree[node][0]>0 && !visited[tree[node][0]])
            preorder(tree[node][0], visited);

        if(tree[node][1]>0 &&!visited[tree[node][1]])
            preorder(tree[node][1], visited);
    }//preorder
    private static void inorder(int node, boolean[] visited){
        visited[node] = true;

        if(tree[node][0]>0 && !visited[tree[node][0]])
            inorder(tree[node][0], visited);

        System.out.print((char) (node-1+'A'));

        if(tree[node][1]>0 &&!visited[tree[node][1]])
            inorder(tree[node][1], visited);
    }//inorder
    private static void postorder(int node, boolean[] visited){
        visited[node] = true;

        if(tree[node][0]>0 && !visited[tree[node][0]])
            postorder(tree[node][0], visited);

        if(tree[node][1]>0 &&!visited[tree[node][1]])
            postorder(tree[node][1], visited);

        System.out.print((char) (node-1+'A'));
    }//postorder
}
