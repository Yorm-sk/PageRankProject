package com.solvd.page_rank.graphs;



    public class TestAMWGraph {
        public static void run() {
            String labels [] = {"site1", "site2", "site3", "site4", "site5"}; // ID узла
            int n = labels.length; // представляем количество узлов и количество ребер

            AMWGraph graph = new AMWGraph(n);
            for(String label:labels) {
                graph.insertVertex (label); // Вставляем узел
            }
            // Вставляем связи
            graph.insertConToMatrix(1, 2);
            graph.insertConToMatrix(2, 3);
            graph.insertConToMatrix(3, 4);
            graph.insertConToMatrix(4, 3);
            graph.insertConToMatrix(4, 5);
            graph.insertConToMatrix(5, 1);
            graph.insertConToMatrix(5, 2);
            graph.insertConToMatrix(5, 3);
            graph.insertConToMatrix(5, 4);



            System.out.println ("Количество узлов:" + graph.getNumOfVertex ());
            System.out.println ("Количество ребер:" + graph.getNumOfEdges ());

            //graph.deleteEdge (0, 1); // Удаляем ребро <V1, V2>
           // System.out.println ("Удалить сторону <V1, V2> после ...");
            System.out.println ("Количество узлов:" + graph.getNumOfVertex ());
            System.out.println ("Количество ребер:" + graph.getNumOfEdges ());

            System.out.println ("Матрица смежности:");

            for (int c = 0; c<= graph.getNumOfVertex()-1; c++) {
                System.out.println();
                for (int r = 0; r <= graph.getNumOfVertex()-1; r++) {
                    System.out.print(" " + graph.getElementOfMtrx(c, r));
                }
            }
    }

}
