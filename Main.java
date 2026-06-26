import java.util.*;
class Main {
  public static void main(String[] args) {
    // 1. Define the vertices (buildings) based on the campus map
    List<String> vertices = new ArrayList<>();

    vertices.add("Liberal Arts");                
    vertices.add("Student Services");             
    vertices.add("Health Careers & Sciences");   
    vertices.add("Health Technologies Center");   
    vertices.add("Recreation Center");           
    vertices.add("Technology Learning Center");   
    vertices.add("Business & Technology");        
    vertices.add("Theatre"); 

    // 2-Define Edges
    List<Edge> edges = new ArrayList<>();
 
    edges.add(new Edge(0, 1));
    edges.add(new Edge(1, 0));
 
    edges.add(new Edge(0, 7));
    edges.add(new Edge(7, 0));
 
    edges.add(new Edge(0, 6));
    edges.add(new Edge(6, 0));
 
    edges.add(new Edge(7, 6));
    edges.add(new Edge(6, 7));
 
    edges.add(new Edge(6, 1));
    edges.add(new Edge(1, 6));
 
    edges.add(new Edge(1, 5));
    edges.add(new Edge(5, 1));
 
    edges.add(new Edge(1, 2));
    edges.add(new Edge(2, 1));
 
    edges.add(new Edge(2, 3));
    edges.add(new Edge(3, 2));
 
    edges.add(new Edge(2, 4));
    edges.add(new Edge(4, 2));
  
    // 3. Create the graph (name "graph") using the vertices and edges
    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);
 
    System.out.println("Graph edges:");
    graph.printEdges();
    System.out.println();
    
    // 4. Perform a depth-first search (name "dfs")(DFS) starting from the "Business & Technology" building
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(6);
    
    
    // 5. Retrieve and print the search order of the DFS traversal
    List<Integer> searchOrder = dfs.getSearchOrder();
    System.out.print("DFS search order starting from Business & Technology: ");
    for (int i = 0; i < searchOrder.size(); i++) 
    {
      int v = searchOrder.get(i);
      System.out.print(graph.getVertex(v) + " ");
    }

    System.out.println();
    System.out.println();
   
    // 6. Print the parent-child relationships for each vertex during the DFS traversal
    System.out.println("Parent-child relationships in the DFS tree:");
    for (int i = 0; i < searchOrder.size(); i++) 
    {
      int v = searchOrder.get(i);
      int parent = dfs.getParent(v);
      if (parent != -1) {
        System.out.println(graph.getVertex(parent) + " -> " + graph.getVertex(v));
      }
      else {
        System.out.println(graph.getVertex(v) + " is the root");
      }
    }
    System.out.println();
    
    // 7. Call the printPath method (assuming this method exists in the UnweightedGraph class)
    dfs.printPath(3); // Health Technologies Center
    System.out.println();
    dfs.printPath(1); // Student Services
    System.out.println();
    dfs.printPath(4); // Recreation Center
    System.out.println();
    System.out.println();
    
    // 8. Call printTree() to print the entire DFS tree (assuming this method exists in the UnweightedGraph class)
    System.out.println("Full DFS tree:");
    dfs.printTree();
  }
}