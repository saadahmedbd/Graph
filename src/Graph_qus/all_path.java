package Graph_qus;

import java.util.ArrayList;

public class all_path {
    public static void main(String[] args) {
        int v =7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        for (int i=0; i<graph[2].size();i++){
            Edge e= graph[2].get(i);
            System.out.println(e.dest+" ");
        }
        int src =0; int tar=5;
        allPath(graph, new boolean[v], src, tar, "0");
    }
    // create edge class

    static  class Edge {
        int src;
        int dest;

        // constructor
        Edge (int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    // create graph

    public static void createGraph(ArrayList<Edge> graph[]){
        // make null to empty list
        for(int i=0; i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // add graph vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
        graph[6].add(new Edge(6,5));

    }
    public static void allPath(ArrayList<Edge> graph[], boolean vis[], int curr, int tar, String path){
        // base case
        if(curr == tar){
            System.out.println(path);
            return;
        }
        for (int i =0; i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if (vis[curr]==false){
                vis[curr] =true;
                allPath(graph, vis, e.dest,tar, path+e.dest);
                vis[curr] =true;
            }
        }
    }
}
