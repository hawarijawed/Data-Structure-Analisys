/******************************************************************************

                            Graph Data Structures
lesson: 01 

*******************************************************************************/
import java.util.*;
class Graph{
    class Pair{
        int node;
        int weight; 
        Pair(int n, int w){
            node = n;
            weight = w;
        }
        
        @Override
        public String toString(){
            return "("+node+","+weight+")";
        }
    }
    int  adjMatrix[][];
    List<List<Integer>> adjList = new ArrayList<>();
    List<List<Pair>> adjListWithWeight;
    public Graph(int nodes){
        adjMatrix = new int[nodes][nodes];
        adjListWithWeight = new ArrayList<>();
        for(int i=0; i<nodes; i++){
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }
    
    public void addEdges(int [][]edges, boolean isDirected){
        for(int i=0; i<edges.length; i++){
            
                int u = edges[i][0];
                int v = edges[i][1];
                //Is it directed graph or not 
                if(isDirected){
                    adjMatrix[u][v] = 1;
                }
                else{
                    //undirected graph 
                    adjMatrix[u][v] = 1;
                    adjMatrix[v][u] = 1;
                }
            
        }
    }
    
    public void addWeightedEdges(int [][]edges, boolean isDirected){
        for(int i=0; i<edges.length; i++){
            
                int u = edges[i][0];
                int v = edges[i][1];
                //Is it directed graph or not 
                if(isDirected){
                    adjMatrix[u][v] = edges[i][2];//assigning the weights
                }
                else{
                    //undirected graph 
                    adjMatrix[u][v] = edges[i][2];//assigning the weights
                    adjMatrix[v][u] = edges[i][2];//assigning the weights
                }
            
        }
    }
    
    public void addEdgesList(int [][]edges, boolean isDirected){
        for(int i=0; i<edges.length; i++){
            
                int u = edges[i][0];
                int v = edges[i][1];
                //Is it directed graph or not 
                if(isDirected){
                    adjList.get(u).add(v);
                }
                else{
                    //undirected graph 
                    adjList.get(u).add(v);
                    adjList.get(v).add(u);
                }
            
        }
    }
    
    public void addEdgesWithWeightInList(int [][]edges, boolean isDirected){
        for(int i=0; i<edges.length; i++){
            
                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];
                //Is it directed graph or not 
                if(isDirected){
                    Pair p = new Pair(v, w);
                    adjListWithWeight.get(u).add(p);
                }
                else{
                    //undirected graph 
                    Pair p1 = new Pair(v, w);
                    Pair p2 = new Pair(u, w);
                    adjListWithWeight.get(u).add(p1);
                    adjListWithWeight.get(v).add(p2);
                }
            
        }
    }
    
    public void printList(){
        for(int i=0; i<adjList.size(); i++){
            System.out.print(i+ "->"+adjList.get(i));
            System.out.println();
        }
    }
    
    public void printWeightedList(){
        for(int i=0; i<adjListWithWeight.size(); i++){
            System.out.print(i+ "->"+adjListWithWeight.get(i));
            System.out.println();
        }
    }
    
    public void printMatrix(){
        System.out.println("Adjacency matrix");
        for(int i=0; i<adjMatrix.length; i++){
            System.out.print("row "+i+"-> ");
            for(int j=0; j<adjMatrix[0].length; j++){
                System.out.print(adjMatrix[i][j]+", ");
            }
            System.out.println();
        }
    }
}
public class Main
{   
	public static void main(String[] args) {
		System.out.println("Hello World");
		//Creatign graph adj list 
		//int [][] edges = {{0,2},{0,1},{1,3}};
		//weighted graph's edges (u, v, weight)
		int [][] edges = {{0,2,10},{0,1,20},{1,3,30}};
		Graph graph = new Graph(4);
		
		System.out.println("undirected graph");
		//graph.addWeightedEdges(edges, false);
		//graph.addEdgesList(edges, false);
		graph.addEdgesWithWeightInList(edges, false);
		//graph.printMatrix();
		//graph.printList();
		graph.printWeightedList();
		System.out.println();
		
		Graph graph1 = new Graph(4);
		System.out.println("Directed graph");
		//graph1.addWeightedEdges(edges, true);
		//graph1.addEdgesList(edges, true);
		graph1.addEdgesWithWeightInList(edges,true);
		graph1.printWeightedList();
		//graph1.printMatrix();
		//graph1.printList();
	}
}