package com.graph;

public class ConectedComponents {

    public static void main(String[] args) {
      int [][] graph =  {{1,1,0},{1,1,0},{0,0,1}};
      findCircleNum(graph);
    }


    public static void dcf(int [][] isConnected, int i, int [][] visited){

        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j]==1 && visited[i][j]!=2){
                System.out.println(i+":" +j +":"+isConnected[i][j]);
                visited[i][j]=2;
                dcf(isConnected, j, visited);
            }
        }

    }

    public static int findCircleNum(int[][] isConnected) {
        int[][] visited = new int [isConnected.length][isConnected.length];
        for(int i=0 ;i<isConnected.length; i++){
           dcf(isConnected, i, visited);
            System.out.println(" row ended : "+ i);
        }
        return -1;
    }
}
