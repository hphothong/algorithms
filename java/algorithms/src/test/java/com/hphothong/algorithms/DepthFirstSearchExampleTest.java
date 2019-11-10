package com.hphothong.algorithms;

import com.hphothong.datastructures.UndirectedGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepthFirstSearchExampleTest {

    private UndirectedGraph<String> graph;

    @Before
    public void setUp() {
        this.graph = new UndirectedGraph<>();

        // Vertices
        UndirectedGraph<String>.GraphVertex<String> vertexA = this.graph.addVertex("A");
        UndirectedGraph<String>.GraphVertex<String> vertexB = this.graph.addVertex("B");
        UndirectedGraph<String>.GraphVertex<String> vertexC = this.graph.addVertex("C");
        UndirectedGraph<String>.GraphVertex<String> vertexD = this.graph.addVertex("D");
        UndirectedGraph<String>.GraphVertex<String> vertexE = this.graph.addVertex("E");
        UndirectedGraph<String>.GraphVertex<String> vertexF = this.graph.addVertex("F");
        UndirectedGraph<String>.GraphVertex<String> vertexG = this.graph.addVertex("G");

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
    public void testDepthFirstSearch() {
        Collection<UndirectedGraph<String>.GraphVertex<String>> expectedVertices = this.graph.getGraphVertices();
        List<String> expectedValues = expectedVertices.stream().map(UndirectedGraph.GraphVertex::getValue).collect(Collectors.toList());

        Collection<UndirectedGraph<String>.GraphVertex<String>> actualVertices = new DepthFirstSearchExample<String>().depthFirstSearch(this.graph);
        List<String> actualValues = actualVertices.stream().map(UndirectedGraph.GraphVertex::getValue).collect(Collectors.toList());

        for (String value : expectedValues) {
            assertTrue(actualValues.contains(value));
        }

        for (String value : actualValues) {
            assertTrue(expectedValues.contains(value));
        }

        assertEquals(expectedValues.size(), actualValues.size());
    }
}
