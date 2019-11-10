package com.hphothong.algorithms;

import com.hphothong.datastructures.UndirectedGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BreadthFirstSearchExampleTest {

    private UndirectedGraph<String> graph;

    @Before
    public void setUp() {
        this.graph = new UndirectedGraph<>();

        // Vertices
        UndirectedGraph.GraphVertex vertexA = this.graph.addVertex("A");
        UndirectedGraph.GraphVertex vertexB = this.graph.addVertex("B");
        UndirectedGraph.GraphVertex vertexC = this.graph.addVertex("C");
        UndirectedGraph.GraphVertex vertexD = this.graph.addVertex("D");
        UndirectedGraph.GraphVertex vertexE = this.graph.addVertex("E");
        UndirectedGraph.GraphVertex vertexF = this.graph.addVertex("F");
        UndirectedGraph.GraphVertex vertexG = this.graph.addVertex("G");

        // Edges
        this.graph.addEdge(vertexA, vertexB);
        this.graph.addEdge(vertexB, vertexE);
        this.graph.addEdge(vertexB, vertexG);
        this.graph.addEdge(vertexB, vertexG);
        this.graph.addEdge(vertexE, vertexF);
        this.graph.addEdge(vertexF, vertexC);
        this.graph.addEdge(vertexC, vertexD);
        this.graph.addEdge(vertexD, vertexG);
    }

    @Test
    public void testBreadthFirstSearch() {
        Collection<UndirectedGraph<String>.GraphVertex<String>> expectedVertices = this.graph.getGraphVertices();
        List<String> expectedValues = expectedVertices.stream().map(stringGraphVertex -> stringGraphVertex.getValue()).collect(Collectors.toList());

        Collection<UndirectedGraph<String>.GraphVertex<String>> actualVertices = new BreadthFirstSearchExample().breadthFirstSearch(this.graph);
        List<String> actualValues = actualVertices.stream().map(vertex -> vertex.getValue()).collect(Collectors.toList());

        for (String value : expectedValues) {
            assertTrue(actualValues.contains(value));
        }

        for (String value : actualValues) {
            assertTrue(expectedValues.contains(value));
        }

        assertEquals(expectedValues.size(), actualValues.size());
    }
}
