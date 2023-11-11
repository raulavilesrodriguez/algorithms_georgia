import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various different graph algorithms.
 *
 * @author RAUL AVILES
 * @version 1.5
 * @userid bravilesr 
 * @GTID 66666
 *
 * Collaborators: NONE
 *
 * Resources: NONE
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you may use is the
     * adjacency list from graph. DO NOT create new instances of Map
     * for BFS (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the bfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     * @throws IllegalArgumentException if any input
     *                                  is null, or if start doesn't exist in
     *                                  the graph
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Cannot search null graph.");
        } else if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException(
                    "Graph does not contain start vertex");
        }
        List<Vertex<T>> list = new ArrayList<>();
        Set<Vertex<T>> VisitedSet = new HashSet<>();
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        VisitedSet.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex<T> v = queue.remove();
            list.add(v);
            for(VertexDistance<T> verticeDistancia : graph.getAdjList().get(v)){
                Vertex<T> w = verticeDistancia.getVertex();
                if(!VisitedSet.contains(w)){
                    queue.add(w);
                    VisitedSet.add(w); // Add w to VisitedSet
                }
            }
        }
        
        return list;
    }


    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * *NOTE* You MUST implement this method recursively, or else you will lose
     * all points for this method.
     *
     * You may import/use java.util.Set, java.util.List, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you may use is the
     * adjacency list from graph. DO NOT create new instances of Map
     * for DFS (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the dfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     * @throws IllegalArgumentException if any input
     *                                  is null, or if start doesn't exist in
     *                                  the graph
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Cannot search null graph.");
        } else if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException(
                    "Graph does not contain start vertex");
        }
        List<Vertex<T>> list = new ArrayList<>();
        Set<Vertex<T>> VisitedSet = new HashSet<>();
        List<Vertex<T>> listaResultado = helper(start, graph, VisitedSet, list);
        return listaResultado;
    }

    private static <T> List<Vertex<T>> 
    helper(Vertex<T> s, Graph<T> G, Set<Vertex<T>> VS, List<Vertex<T>> L){
        VS.add(s);
        L.add(s);
        for(VertexDistance<T> verticeDistancia : G.getAdjList().get(s)){
            Vertex<T> w = verticeDistancia.getVertex();
            if(!VS.contains(w)){
                helper(w, G, VS, L);
            }
        }
        return L;
    }


    /**
     * Finds the single-source shortest distance between the start vertex and
     * all vertices given a weighted graph (you may assume non-negative edge
     * weights).
     *
     * Return a map of the shortest distances such that the key of each entry
     * is a node in the graph and the value for the key is the shortest distance
     * to that node from start, or Integer.MAX_VALUE (representing
     * infinity) if no path exists.
     *
     * You may import/use java.util.PriorityQueue,
     * java.util.Map, and java.util.Set and any class that
     * implements the aforementioned interfaces, as long as your use of it
     * is efficient as possible.
     *
     * You should implement the version of Dijkstra's where you use two
     * termination conditions in conjunction.
     *
     * 1) Check if all of the vertices have been visited.
     * 2) Check if the PQ is empty yet.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the Dijkstra's on (source)
     * @param graph the graph we are applying Dijkstra's to
     * @return a map of the shortest distances from start to every
     * other node in the graph
     * @throws IllegalArgumentException if any input is null, or if start
     *                                  doesn't exist in the graph.
     */
    public static <T> Map<Vertex<T>, Integer> dijkstras(Vertex<T> start,
                                                        Graph<T> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Cannot search null graph.");
        } else if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException(
                    "Graph does not contain start vertex");
        }
        Map<Vertex<T>, Integer> map = new HashMap<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();
        Queue<VertexDistance<T>> pqueue = new PriorityQueue<>();
        List<Vertex<T>> vlist = new ArrayList<>();
        for (Vertex<T> vertex : adjList.keySet()) {
            if (vertex.equals(start)) {
                map.put(vertex, 0);
            } else {
                map.put(vertex, Integer.MAX_VALUE);
            }
        }
        pqueue.add(new VertexDistance<>(start, 0));
        while (vlist.size() < adjList.size() && !(pqueue.isEmpty())) {
            VertexDistance<T> curr = pqueue.remove();
            vlist.add(curr.getVertex());
            for (VertexDistance<T> v : adjList.get(curr.getVertex())) {
                int newDistance = curr.getDistance() + v.getDistance();
                if (!vlist.contains(v.getVertex()) &&  map.get(v.getVertex()) > newDistance) {
                    map.put(v.getVertex(), newDistance);
                    pqueue.add(new VertexDistance<>(v.getVertex(),
                            newDistance));
                }
            }
        }
        return map;
    }

    
}