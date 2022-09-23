package com.nilesh.practice.atlassian;

import java.util.*;

class TeamVote  {

    Character tramName;
    //int [] votes;
    List<Integer> votes;


    public TeamVote(Character tramName,  int size) {
        this.tramName = tramName;
        this.votes =new ArrayList<>(size);
        for (int i=0; i< size ; i++){
            votes.add(0);
        }
    }

    public Character getTramName() {
        return tramName;
    }

    public List<Integer> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "TeamVote{" +
                "tramName=" + tramName +
                ", votes=" + votes +
                '}';
    }
}

public class RankAndVote {

    public static String rankTeams(String[] votes) {

        Map<Character, TeamVote> teamVoteMap = new HashMap<>();

        for (String s : votes) {
            for (int i = 0; i < s.length(); i++) {
                TeamVote teamVote = teamVoteMap.getOrDefault(s.charAt(i), new TeamVote(s.charAt(i),  s.length()));
                teamVote.getVotes().set(i, teamVote.getVotes().get(i)+1);
                teamVoteMap.put(s.charAt(i), teamVote);
            }
        }
        System.out.println(teamVoteMap);
        List<TeamVote> teamVotes = new ArrayList<>();
        for (TeamVote teamVote : teamVoteMap.values()) {
            teamVotes.add(teamVote);
        }
        Collections.sort(teamVotes, (a,b) ->{
            for(int i=0; i<a.getVotes().size(); i++){
                if(a.getVotes().get(i) == b.getVotes().get(i)) continue;
                return   a.getVotes().get(i) - b.getVotes().get(i)  ;

            }
            return -1;
        });

        System.out.println(teamVotes);

        StringBuilder result = new StringBuilder();
        for (int i=teamVotes.size()-1; i>=0; i--) {
            result.append(teamVotes.get(i).getTramName());
        }


        return result.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        //List<Integer> list = new ArrayList<>();
        //list.set()
        //System.out.println(rankTeams(arr));

        RankAndVote rankAndVote = new RankAndVote();

        String[][] island = {{"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}};

        System.out.println( rankAndVote.numIslands(island));



        //rankAndVote.numIslands();

    }


    //leet code - 911 (I used HashMap, Set and PriorityQueue in my solution.) , 1366
    //http job scheduler
    //tag mangement system
    //api rate limiter
    //Coding Round 2 - You will be given a list of file names, the collection the file belongs to and the size of each file. Write a program to find the top N collections by size and the total size of all the files in the system. Follow up - collections can be nested, find top N collections by size.

    /**
     * Imagine we are building an application that is used by many different customers. We want to avoid one customer being able to overload the system by sending too many requests, so we enforce a per-customer rate limit. The rate limit is defined as:
     *
     * “Each customer can make X requests per Y seconds”
     *
     * Assuming that customer ID is extracted somehow from the request, implement the following function.
     *
     *
     * // Perform rate limiting logic for provided customer ID. Return true if the
     * // request is allowed, and false if it is not.
     * boolean rateLimit(int customerId)
     *
     * one of our customers have bursty traffic, and are complaining about being rate limited. We want to better accomodate those customers, so we want to adopt a ‘credit’ based system. It will work as follows:
     *
     * For each bucket of time, any capacity available below the limit is converted into credits for that customer
     *
     * There is some maximum number of credits that a customer can accumulate
     *
     * When a customer exceeds their normal request limit for a window, the credit count starts to decrease. When there are 0 credits, the customer is rate limited.
     *
     */

/**
 * Code design Round -> Asked to design router class which takes a route as string and does some action with mapping the correct operation. Ask clarifying questions write the tests first, approach abstracted blueprint and then finally implement the logic. I used my own VS code with screen share as I had node and linter installed.
 */


/**
 * Design a Tagging system for JIRA and this system can be used with other products as well.
 * System should be highly Available and Fault Taulrance
 */


/**
 * Given list of {page-id, size, section-id} find the largest N sections in sorted order and also the overall size of all pages. [2nd round] --- Solved using hashmap and min-heap of size N. Was able to come up with correct space ( O(inputsize) ) and time complexity ( O(inputsize + NlogN )
 */

/**
 *  First Technical Round:- It was a code pairing round. Question-related to a similar     .
 */


public static Set<String> visited = new HashSet<>();


    public void findall(String[][] grid,  int row, int col) {

        if(row<0 || row >= grid.length || col<0 || col>=grid[0].length){
            return;
        }

        if(!visited.contains(row+""+col+"") && grid[row][col].equals("1")){
            visited.add(row+""+col+"");
            findall(grid, row, col+1);
            findall(grid, row+1, col);
        }
    }


    public int numIslands(String[][] grid) {
        int counter = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited.contains(i+""+j+"") && grid[i][j].equals("1")){
                    findall(grid,i,j);
                    counter ++;
                }
            }
        }
        return counter;
    }
}
