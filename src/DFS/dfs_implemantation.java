package DFS;


import java.util.ArrayList;

public class dfs_implemantation {
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean vis[] = new boolean[v];
        for (int i=0; i<v;i++){
            if(vis[i]==false){
                create_dfs_traversal(graph, vis, i);
            }
        }
        System.out.println();
        int src =0; int target=5;
        search_all_path(graph, "0",src,new boolean[v], target);

    }
    public static  class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<dfs_implemantation.Edge> graph[]){
        // create empty arrayList
        for (int i =0; i<graph.length;i++){
            graph[i] = new ArrayList<Edge>(i);
        }
        graph[0].add(new dfs_implemantation.Edge(0,1));
        graph[0].add(new dfs_implemantation.Edge(0, 2));
        graph[1].add(new dfs_implemantation.Edge(1, 3));
        graph[1].add(new dfs_implemantation.Edge(1,3));
        graph[2].add(new dfs_implemantation.Edge(2,0));
        graph[2].add(new dfs_implemantation.Edge(2,4));
        graph[3].add(new dfs_implemantation.Edge(3,1));
        graph[3].add(new dfs_implemantation.Edge(3,4));
        graph[3].add(new dfs_implemantation.Edge(3,5));
        graph[4].add(new dfs_implemantation.Edge(4,2));
        graph[4].add(new dfs_implemantation.Edge(4,3));
        graph[4].add(new dfs_implemantation.Edge(4,5));
        graph[5].add(new dfs_implemantation.Edge(5,4));
        graph[5].add(new dfs_implemantation.Edge(5,3));
        graph[5].add(new dfs_implemantation.Edge(5,6));
        graph[6].add(new dfs_implemantation.Edge(6,5));

        /*

                (1) --(3)
            /           |    \
        (0)             |    (5) --(6)
            \           |    /
                (2) -- (4)

         */

    }
    public static  void create_dfs_traversal(ArrayList<Edge> graph[], boolean vis[], int curr){
        System.out.println(curr+" "); // first curr vertex print
        vis[curr] =true;  // curr of visitor make true
        for(int i=0;i<graph[curr].size();i++){ //traversal for get neighbours
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false){  // if distination haven't than call recursive function
                create_dfs_traversal(graph, vis, e.dest);
            }
        }
    }
    public static void search_all_path(ArrayList<Edge> graph[], String path, int curr, boolean vis[], int target) {
        // base case
        if (curr == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                vis[curr] = true;
                search_all_path(graph, path + e.dest, e.dest, vis, target);
                vis[curr] = false;
            }
        }
    }
}
