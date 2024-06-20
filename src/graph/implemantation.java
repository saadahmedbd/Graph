package graph;

import java.util.*;

public class implemantation {
    public static class Edge {
        int src;   // source
        int dest;   // destination

        int weight;

        public  Edge (int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0; i<graph.length;i++){     // create empty list
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge (0,2,10));
        graph[1].add(new Edge (1, 2, 12));
        graph[1].add(new Edge(1, 3,1));
    }
    public static void main(String[] args) {
        int V =4;
        ArrayList<Edge>  graph[] = new ArrayList[V];
        createGraph(graph);
        for(int i=0; i<graph[1].size();i++){
            Edge e = graph[1].get(i);
            System.out.println(e.dest+" "+e.weight);
        }
    }
}
