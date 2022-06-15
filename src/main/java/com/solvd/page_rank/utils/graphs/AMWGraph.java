package com.solvd.page_rank.utils.graphs;


import java.util.ArrayList;


public class AMWGraph {
    private ArrayList vertexList; // Linked list of storage points
    private int [] [] edges; // Adjacency matrix, used to store edges

    private int [][] matrixConn; // matrix of directed connections for MyAlgorithm
    private int numOfEdges; // Number of edges

    public AMWGraph(int n) {
        // Initialize the matrix, one-dimensional array, and the number of edges
        edges=new int[n][n];
        matrixConn = new int[n][n];
        vertexList=new ArrayList(n);
        numOfEdges=0;
    }

    // Get the number of nodes
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // Get the number of edges
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // Return node data i
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // Return weight v1, v2
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }

    // Insert node
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    // Insert node
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;
    }

    public void insertConToMatrix(int v1,int v2) {
        matrixConn[--v1][--v2]=1;
        numOfEdges++;
    }


    // Delete the node
    public void deleteEdge(int v1,int v2) {
        edges[v1][v2]=0;
        numOfEdges--;
    }

    // Get the index of the first neighbor node
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    // Get the next neighbor by neighbor packet index
    public int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }

    public int getElementOfMtrx(int col, int row) {
        return  matrixConn[col][row];
    }

    public int[][] getMtrx() {
        return matrixConn;
    }
}