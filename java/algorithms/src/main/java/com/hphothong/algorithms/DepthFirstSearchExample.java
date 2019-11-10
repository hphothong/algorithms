package com.hphothong.algorithms;

import com.hphothong.datastructures.UndirectedGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class DepthFirstSearchExample<T> {

    public Collection<UndirectedGraph<T>.GraphVertex<T>> depthFirstSearch(UndirectedGraph<T> graph) {
        Stack<UndirectedGraph<T>.GraphVertex<T>> stack = new Stack<>();
        Collection<UndirectedGraph<T>.GraphVertex<T>> visitedVertices = new ArrayList<>();

        UndirectedGraph<T>.GraphVertex<T> sourceVertex = graph.getSourceVertex();
        stack.push(sourceVertex);

        while (!stack.empty()) {
            UndirectedGraph<T>.GraphVertex<T> vertex = stack.pop();
            visitedVertices.add(vertex);

            for (UndirectedGraph<T>.GraphVertex<T> connection: vertex.getConnections()) {
                if (!visitedVertices.contains(connection) && !stack.contains(connection)) {
                    stack.push(connection);
                }
            }
        }

        return visitedVertices;
    }
}
