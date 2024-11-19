import java.util.*;

public class JesseDance_ProblemNo2 {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the number of vertices: ");

		int numberOfVert = Integer.parseInt(in.nextLine().trim());

		int numberOfEdge = numberOfVert - 1;

		int[][] edges = new int[numberOfVert][2];

		System.out.println("Now you can enter the vertices for each edge");
		
		for(int i = 0; i < numberOfVert; i++) {
			System.out.println("Enter -1 to exit or enter the first vertex for this edge: ");
			int input = Integer.parseInt(in.nextLine().trim());
			if (input == -1) 
				break;
			else 
	            edges[i][0] = input;

	            System.out.println("Enter the second vertex for this edge: ");
	            edges[i][1] = Integer.parseInt(in.nextLine().trim());
        }

        System.out.println("Now, please enter the starting location: ");

		int start = Integer.parseInt(in.nextLine().trim());

		System.out.println("Now, please enter the destination: ");

		int destination = Integer.parseInt(in.nextLine().trim());

        checkForValidPaths(numberOfVert, edges, start, destination);
        
	}

	public static void checkForValidPaths(int n, int[][] edges, int start, int destination) {

		Map<Integer, List<Integer>> graph = new HashMap<>();


		for(int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}

		for(int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		List<Integer> path = new ArrayList<>();

		depthFirstSearch(graph, visited, start, destination, path);
		System.out.println("Process complete, if no path was printed, no valid path was found");

	}

	public static void depthFirstSearch(Map<Integer, List<Integer>> graph, boolean[] visited, int currentVertex, int destination, List<Integer> path) {

		path.add(currentVertex);

		if (currentVertex == destination) {
            printValidPath(path);
        } else {
            visited[currentVertex] = true;
            for (int vertex : graph.get(currentVertex)) {
                if (!visited[vertex]) {
                    depthFirstSearch(graph, visited, vertex, destination, path);
                }
            }
            visited[currentVertex] = false;
        }

        path.remove(path.size() - 1);

	}

	public static void printValidPath(List<Integer> path) {

		System.out.println("Valid path found: ");
		
        for (int i = 0; i < path.size(); i++) {
            if (i != 0) System.out.print(" -> ");
            System.out.print(path.get(i));
        }
        System.out.println();
    }
}