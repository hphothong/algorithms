package com.hphothong.algorithms;

import com.hphothong.datastructures.UndirectedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

public class BreadthFirstSearchExample<T> {

    public Collection<UndirectedGraph<T>.GraphVertex<T>> breadthFirstSearch(UndirectedGraph<T> graph) {
        Queue<UndirectedGraph<T>.GraphVertex<T>> queue = new ArrayDeque<>();
        Collection<UndirectedGraph<T>.GraphVertex<T>> visitedVertices = new ArrayList<>();

        UndirectedGraph<T>.GraphVertex<T> sourceVertex = graph.getSourceVertex();
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            UndirectedGraph<T>.GraphVertex<T> vertex = queue.remove();
            visitedVertices.add(vertex);

            for (UndirectedGraph<T>.GraphVertex<T> connection: vertex.getConnections()) {
                if (!visitedVertices.contains(connection) && !queue.contains(connection)) {
                    queue.add(connection);
                }
            }
        }
        return visitedVertices;
    }
}
