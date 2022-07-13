package com.leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    Map<Character, List<Character>> adjacencyList = new HashMap<>();
    Map<Character, Integer> remainingCount = new HashMap<>();

    public void initializeGraph(List<String> words) {
        for (String s : words) {
            for (Character c : s.toCharArray()) {
                adjacencyList.put(c, new ArrayList<>());
                remainingCount.put(c, 0);
            }
        }
    }

    public void populateAdjacencyList(List<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);
            if (word1.startsWith(word2) && word1.length() > word2.length()) return;
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjacencyList.get(word1.charAt(j)).add(word2.charAt(j));
                    remainingCount.put(word2.charAt(j), remainingCount.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

    }

    public List<Character> topologicalSortedOrder() {
        Deque<Character> queue = new ArrayDeque<>();
        for (Character s : getAllCompletedTask()) {
            queue.offer(s);
        }
        List<Character> s = new ArrayList<>();
        while (!queue.isEmpty()) {
            Character currentVal = queue.poll();
            s.add(currentVal);
            for (Character adjacent : adjacencyList.get(currentVal)) {
                remainingCount.put(adjacent, remainingCount.get(adjacent) - 1);
                if (remainingCount.get(adjacent) == 0) {
                    queue.add(adjacent);
                }
            }
        }
        return s;
    }

    public List<Character> getAllCompletedTask() {
        return remainingCount.entrySet()
                .stream().filter(e -> e.getValue() == 0)
                .map(x -> x.getKey())
                .collect(Collectors.toList());
    }


}
