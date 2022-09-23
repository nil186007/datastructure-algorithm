package com.code.nil.preparation.likedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<C> {


    public static void main(String[] args) {
        /*Node root = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4,
                                        new Node(5,
                                                new Node(6,
                                                        new Node(7,
                                                                new Node(8, null))))))));
        Node n = root;
        printList(n);
        System.out.println("===========");
        reverseList(n, 8);*/

        convert("PAYPALISHIRING", 3);
    }

    public static void reverseInGroup(Node root, int k) {
        Node start = root;
        boolean isKNodePresent = false;
        while (start != null) {
            Node current = start;
            int count = 0;
            while (current != null) {
                current = current.next;
                count++;
                if (count == k) {
                    isKNodePresent = true;
                    break;
                }
            }
            if (isKNodePresent) {
                Node newHead = reverseList(start, k);
            }
            start = current;
        }
    }

    public static Node reverseList(Node root, int k) {
        int count = k;
        Node prev = null;
        Node next = null;
        Node current = root;
        while (count > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }
        return prev;
    }

    public static Node reverseListRecur(Node root) {
        if (root == null || root.next == null) return root;
        Node rest = reverseListRecur(root.next);
        root.next.next = root;
        root.next = null;
        return rest;
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.println(root.value);
            root = root.next;
        }
    }

    public String longestPalindromeString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left, right);
    }

    public String longestPalindrome(String s) {
        String palindrome = "";
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            String currentPalindrome = "";
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                currentPalindrome = longestPalindromeString(s, i, i + 1);
            } else {
                currentPalindrome = longestPalindromeString(s, i - 1, i + 1);
            }
            if (currentPalindrome.length() > palindrome.length()) {
                palindrome = currentPalindrome;
            }
        }
        return palindrome;
    }

    public static void convert(String s, int numRows) {

        List<List<Character>> result = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < s.length();) {
            List<Character> l = new ArrayList<>();
            int c= counter % numRows;
            for (int j = 0; j < numRows; j++) {
                if ((counter == 0 || c == numRows - 1 ) && i< s.length()) {
                    l.add(s.charAt(i));
                    i++;
                } else {
                    if (j == numRows - c) {
                        l.add(s.charAt(i));
                        i++;
                    } else {
                        l.add('0');
                    }
                }
            }
            result.add(l);
            counter++;
        }
        System.out.println(result);
    }
}
