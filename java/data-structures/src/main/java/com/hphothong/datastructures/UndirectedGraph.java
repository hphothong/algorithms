package com.hphothong.datastructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph<T> {
    private Collection<GraphVertex<T>> graphVertices;

    public UndirectedGraph() {
        this.graphVertices = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.graphVertices.isEmpty();
    }

    public GraphVertex<T> addVertex(T value) {
        GraphVertex<T> vertex = new GraphVertex<T>(value);
        this.graphVertices.add(vertex);
        return vertex;
    }

    public GraphVertex<T> getVertexWithValue(T value) {
        for (GraphVertex<T> vertex: this.graphVertices) {
            if (vertex.getValue().equals(value)) {
                return vertex;
            }
        }
        return null;
    }

    public GraphVertex<T> getSourceVertex() {
        return this.graphVertices.iterator().next();
    }

    public Collection<GraphVertex<T>> getGraphVertices() {
        return this.graphVertices;
    }

    public void addEdge(GraphVertex<T> from, GraphVertex<T> to) {
        for (GraphVertex<T> vertex: this.graphVertices) {
            if (vertex.equals(from)) {
                vertex.addConnection(to);
            }
        }
    }

    public boolean contains(T value) {
        for (GraphVertex<T> vertex: this.graphVertices) {
            if (vertex.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(GraphVertex<T> vertex) {
        for (GraphVertex<T> graphVertex: this.graphVertices) {
            if (vertex.equals(graphVertex)) {
                return true;
            }
        }
        return false;
    }

    public class GraphVertex<T> {
        private T value;
        private Set<GraphVertex<T>> connections;

        public GraphVertex(T value) {
            this.value = value;
            this.connections = new HashSet<>();
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void addConnection(GraphVertex<T> vertex) {
            this.connections.add(vertex);
        }

        public Set<GraphVertex<T>> getConnections() { return this.connections; }

        public void clearConnections() {
            this.connections = new HashSet<>();
        }
    }
}
