package com.solvd.page_rank.utils.graphs;


import java.util.ArrayList;


public class AMWGraph {
    private ArrayList vertexList; // Связанный список точек хранения
    private int [] [] edges; // Матрица смежности, используется для хранения ребер

    private int [][] matrixConn;
    private int numOfEdges; // Количество ребер

    public AMWGraph(int n) {
        // Инициализируем матрицу, одномерный массив и количество ребер
        edges=new int[n][n];
        matrixConn = new int[n][n];
        vertexList=new ArrayList(n);
        numOfEdges=0;
    }

    // Получаем количество узлов
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // Получаем количество ребер
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // Возвращаем данные узла i
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // Возвращаем вес v1, v2
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }

    // Вставляем узел
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    // Вставляем узел
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;
    }

    public void insertConToMatrix(int v1,int v2) {
        matrixConn[--v1][--v2]=1;
        numOfEdges++;
    }


    // Удаляем узел
    public void deleteEdge(int v1,int v2) {
        edges[v1][v2]=0;
        numOfEdges--;
    }

    // Получаем индекс первого соседнего узла
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    // По индексу предыдущего соседнего узла получить следующий соседний узел
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