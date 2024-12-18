import java.util.*;
import java.io.*;

public class JesseDance_ProblemNo1 {

    public static Map<String, List<String>> adjacencyList;

    public static class DirectedGraph {

        DirectedGraph() {
            adjacencyList = new HashMap<>();
        }

        public static void addVertex(String vertex) {
            if (!adjacencyList.containsKey(vertex)) {
                adjacencyList.put(vertex, new ArrayList<>());
                System.out.println("Vertex " + vertex + " added.");
            } else {
                System.out.println("Vertex " + vertex + " already exists.");
            }
        }

        public static void addEdge(String source, String destination) {
            if (adjacencyList.containsKey(source)) {
                adjacencyList.get(source).add(destination);
                System.out.println("Edge added from " + source + " to " + destination);
            } else {
                System.out.println("Source vertex " + source + " does not exist.");
            }
        }

        public static void printGraph() {
            for (String vertex : adjacencyList.keySet()) {
                System.out.print(vertex + " -> ");
                List<String> neighbors = adjacencyList.get(vertex);
                if (neighbors.isEmpty()) {
                    System.out.println("No outgoing edges");
                } else {
                    System.out.println(String.join(", ", neighbors));
                }
            }
        }

        public void bfs(String startVertex) {

            Set<String> visited = new HashSet<>();

            Queue<String> queue = new LinkedList<>();

            visited.add(startVertex);
            queue.offer(startVertex);

            System.out.println("BFS starting from " + startVertex + ":");

            while (!queue.isEmpty()) {
                String currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                List<String> neighbors = adjacencyList.get(currentVertex);
                if (neighbors != null) {
                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            System.out.println();
        }

        public void dfs(String startVertex) {

            Set<String> visited = new HashSet<>();

            System.out.println("DFS starting from " + startVertex + ":");

            dfsRecursive(startVertex, visited);
            
            System.out.println();
        }

        private void dfsRecursive(String currentVertex, Set<String> visited) {

            visited.add(currentVertex);

            System.out.print(currentVertex + " ");

            List<String> neighbors = adjacencyList.get(currentVertex);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        dfsRecursive(neighbor, visited);
                    }
                }
            }
        }
    }
 
    public static void readEdgesFromFile(String fileName, DirectedGraph graph) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String source = parts[0];
                    String destination = parts[1];

                    graph.addVertex(source);

                    graph.addEdge(source, destination);

                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        DirectedGraph graph = new DirectedGraph();

        System.out.println("Please enter the name of the file with the directed graph data: ");

        String fileName = in.nextLine().trim();

        readEdgesFromFile(fileName, graph);

        System.out.println("enter the starting location: ");
        
        String source = in.nextLine().trim();

        graph.printGraph();

        graph.bfs(source);

        graph.dfs(source);

        in.close();
    }
}
