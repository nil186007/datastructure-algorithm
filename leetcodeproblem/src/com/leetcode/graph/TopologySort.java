package com.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologySort {

    public static void main(String[] args) {
        String [] input = {"wrt","wrf","er","ett","rftt"};

        Graph graph = new Graph();
        List<String> words = Arrays.asList(input);
        graph.initializeGraph(words);

        System.out.println(graph.adjacencyList);
        System.out.println(graph.remainingCount);

        graph.populateAdjacencyList(words);

        System.out.println(graph.adjacencyList);
        System.out.println(graph.remainingCount);

        System.out.println(graph.topologicalSortedOrder());

    }




}
