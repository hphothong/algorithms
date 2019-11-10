package com.hphothong.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UndirectedGraphTest {

    private UndirectedGraph<Integer> graph;

    @Before
    public void setUp() {
        this.graph = new UndirectedGraph<>();
    }

    @Test
    public void testEmptyUndirectedGraph() {
        assertTrue(this.graph.isEmpty());
    }

    @Test
    public void testAddVertexUndirectedGraph() {
        UndirectedGraph<Integer>.GraphVertex<Integer> vertex = this.graph.addVertex(1);

        assertEquals(UndirectedGraph.GraphVertex.class, vertex.getClass());
        assertTrue(this.graph.contains(vertex));
        assertTrue(this.graph.contains(1));
    }

    @Test
    public void testGetVertexWithValueUndirectedGraph() {
        this.graph.addVertex(1);
        UndirectedGraph<Integer>.GraphVertex<Integer> vertex = this.graph.addVertex(2);

        assertEquals(vertex, this.graph.getVertexWithValue(2));
    }

    @Test
    public void testConnectedGraphUndirectedGraph() {
        UndirectedGraph<Integer>.GraphVertex<Integer> vertexA = this.graph.addVertex(1);
        UndirectedGraph<Integer>.GraphVertex<Integer> vertexB = this.graph.addVertex(2);
        UndirectedGraph<Integer>.GraphVertex<Integer> vertexC = this.graph.addVertex(3);
        vertexA.addConnection(vertexB);
        vertexB.addConnection(vertexC);

        assertEquals(3, this.graph.getGraphVertices().size());
        assertTrue(breadthFirstSearch(this.graph));
    }

    private boolean breadthFirstSearch(UndirectedGraph<Integer> graph) {
        Queue<UndirectedGraph<Integer>.GraphVertex<Integer>> queue = new ArrayDeque<>();
        Collection<UndirectedGraph<Integer>.GraphVertex<Integer>> visitedVertices = new ArrayList<>();

        Iterator<UndirectedGraph<Integer>.GraphVertex<Integer>> vertices = graph.getGraphVertices().iterator();

        UndirectedGraph<Integer>.GraphVertex<Integer> startVertex = vertices.next();

        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // Dequeue the next vertex
            UndirectedGraph<Integer>.GraphVertex<Integer> vertex = queue.remove();
            visitedVertices.add(vertex);

            // Check for edges that contain the vertex
           for (UndirectedGraph<Integer>.GraphVertex<Integer> connection: vertex.getConnections()) {
               if (!visitedVertices.contains(connection)) {
                   queue.add(connection);
               }
            }
        }

        return visitedVertices.containsAll(graph.getGraphVertices());
    }
}
