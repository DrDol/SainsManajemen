/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sainsmanajement;

import java.util.HashMap;
import java.util.Iterator;
    import org.jgrapht.graph.*;
    import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.traverse.ClosestFirstIterator;
import sainsmanajement.Obj;


/**
 *
 * @author ASUS
 */
public class SainsManajement {

    /**
     * @param args the command line arguments
     */
    static SimpleWeightedGraph<Obj, DefaultWeightedEdge> g;
    public static void main(String[] args) {
        Double totalCost = 0.0;
        int banyakData;
        String Start; String End; Double Weight; int Qty;
        g = new SimpleWeightedGraph<Obj, DefaultWeightedEdge>(DefaultWeightedEdge.class); 
        Map<String,Obj> map = new HashMap<>();
        //Add OBJ Kota dan Ekspedisi, serta melakukan mapping Nama dengan OBJnya
        Obj NCS= new Obj("NCS", 65, 150, true); map.put(NCS.name, NCS);
        Obj RPX= new Obj("RPX", 100, 150, true); map.put(RPX.name, RPX);
        Obj Sicepat= new Obj("Sicepat", 100, 600, true); map.put(Sicepat.name, Sicepat);
        Obj Blibli_Express= new Obj("Blibli_Express", 375, 800, true); map.put(Blibli_Express.name, Blibli_Express);
        Obj Ninja_Express= new Obj("Ninja_Express", 250, 1350, true);map.put(Ninja_Express.name, Ninja_Express);
        Obj Pos_Indonesia= new Obj("Pos_Indonesia", 320, 1470, true);map.put(Pos_Indonesia.name, Pos_Indonesia);
        Obj JNE= new Obj("JNE", 630, 3500, true);map.put(JNE.name, JNE);
        Obj Semarang= new Obj("Semarang", false);map.put(Semarang.name, Semarang);
        Obj Surabaya= new Obj("Surabaya", false);map.put(Surabaya.name, Surabaya);
        Obj Bandung= new Obj("Bandung", false);map.put(Bandung.name, Bandung);
        Obj Malang= new Obj("Malang", false);map.put(Malang.name, Malang);
        Obj Depok= new Obj("Depok", false);map.put(Depok.name, Depok);
        Obj Bogor= new Obj("Bogor", false);map.put(Bogor.name, Bogor);
        Obj Yogyakarta= new Obj("Yogyakarta", false);map.put(Yogyakarta.name, Yogyakarta);
        Obj Jakarta= new Obj("Jakarta", false);map.put(Jakarta.name, Jakarta);
        //Memasukan Obj menjadi Vertex
        g.addVertex(NCS);
        g.addVertex(Semarang);
        g.addVertex(Surabaya);
        g.addVertex(RPX);
        g.addVertex(Bandung);
        g.addVertex(Malang);
        g.addVertex(Sicepat);
        g.addVertex(Depok);
        g.addVertex(Bogor);
        g.addVertex(Yogyakarta);
        g.addVertex(Blibli_Express);
        g.addVertex(Jakarta);
        g.addVertex(Ninja_Express);
        g.addVertex(Pos_Indonesia);
        g.addVertex(JNE);
        
        //Memasukan detail edge
        DefaultWeightedEdge e1 = g.addEdge(NCS, Semarang); 
        g.setEdgeWeight(e1, 5500);
        DefaultWeightedEdge e2 = g.addEdge(NCS, Surabaya); 
        g.setEdgeWeight(e2, 5500);
        DefaultWeightedEdge e3 = g.addEdge(RPX, Bandung); 
        g.setEdgeWeight(e3, 7250);
        DefaultWeightedEdge e4 = g.addEdge(RPX, Surabaya); 
        g.setEdgeWeight(e4, 7250);
        DefaultWeightedEdge e5 = g.addEdge(RPX, Malang); 
        g.setEdgeWeight(e5, 7250);
        DefaultWeightedEdge e6 = g.addEdge(Sicepat, Depok); 
        g.setEdgeWeight(e6, 6500);
        DefaultWeightedEdge e7 = g.addEdge(Sicepat, Bogor); 
        g.setEdgeWeight(e7, 6500);
        DefaultWeightedEdge e8 = g.addEdge(Sicepat, Yogyakarta); 
        g.setEdgeWeight(e8, 6500);
        DefaultWeightedEdge e9 = g.addEdge(Sicepat, Surabaya); 
        g.setEdgeWeight(e9, 6500);
        DefaultWeightedEdge e10 = g.addEdge(Blibli_Express, Jakarta); 
        g.setEdgeWeight(e10, 7500);
        DefaultWeightedEdge e11 = g.addEdge(Blibli_Express, Bandung); 
        g.setEdgeWeight(e11, 7500);
        DefaultWeightedEdge e12 = g.addEdge(Blibli_Express, Semarang); 
        g.setEdgeWeight(e12, 7500);
        DefaultWeightedEdge e13 = g.addEdge(Ninja_Express, Jakarta); 
        g.setEdgeWeight(e13, 6500);
        DefaultWeightedEdge e14 = g.addEdge(Ninja_Express, Bogor); 
        g.setEdgeWeight(e14, 6500);
        DefaultWeightedEdge e15 = g.addEdge(Ninja_Express, Bandung); 
        g.setEdgeWeight(e15, 6500);
        DefaultWeightedEdge e16 = g.addEdge(Pos_Indonesia, Jakarta); 
        g.setEdgeWeight(e16, 7500);
        DefaultWeightedEdge e17 = g.addEdge(Pos_Indonesia, Depok); 
        g.setEdgeWeight(e17, 7500);
        DefaultWeightedEdge e18 = g.addEdge(Pos_Indonesia, Semarang); 
        g.setEdgeWeight(e18, 7500);
        DefaultWeightedEdge e19 = g.addEdge(Pos_Indonesia, Yogyakarta); 
        g.setEdgeWeight(e19, 7500);
        DefaultWeightedEdge e20 = g.addEdge(JNE, Jakarta); 
        g.setEdgeWeight(e20, 6000);
        DefaultWeightedEdge e21 = g.addEdge(JNE, Bandung); 
        g.setEdgeWeight(e21, 6000);
        DefaultWeightedEdge e22 = g.addEdge(JNE, Semarang); 
        g.setEdgeWeight(e22, 6000);
        DefaultWeightedEdge e23 = g.addEdge(JNE, Yogyakarta); 
        g.setEdgeWeight(e23, 6000);
        
        Scanner sc = new Scanner(System.in); 
        banyakData = sc.nextInt(); 

        for(int i=0;i<banyakData;++i){
            Start = sc.next();
            End = sc.next();
            Qty=sc.nextInt();
            Weight=sc.nextDouble();
            totalCost+=getRoute(map.get(Start),map.get(End),Qty,Weight);
        }
        System.out.println("Total Cost :"+totalCost);
    }
     public static double getRoute(Obj startVertex, Obj endVertex, int qty, Double weight)
    {
        Double cost=null;
        DijkstraShortestPath<Obj, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<Obj, DefaultWeightedEdge>(g);
        
        GraphPath<Obj, DefaultWeightedEdge> graphpath = dijkstra.getPath(startVertex, endVertex);
         if(graphpath == null)
         {
             System.out.println("Tidak ada Jalur");
         }

         List<Obj> path = graphpath.getVertexList();
         if(path.size()==1){
             Obj nearestNeighbourObj = null;
             ClosestFirstIterator<Obj, DefaultWeightedEdge> cfi =  new ClosestFirstIterator<Obj,DefaultWeightedEdge> (g, startVertex);
                while(cfi.hasNext()){
                    nearestNeighbourObj=cfi.next();
                    if(nearestNeighbourObj.Capacity>=weight && nearestNeighbourObj.Request>=qty) break;
                }
             String nearestNeighbour=nearestNeighbourObj.name;
             System.out.print(nearestNeighbour+ " to " + startVertex.name+ " ");
             cost=dijkstra.getPathWeight(startVertex, nearestNeighbourObj)*2*weight*qty;
             nearestNeighbourObj.Capacity-=weight;
             nearestNeighbourObj.Request-=qty;
             if(nearestNeighbourObj.isExpedition==true && (nearestNeighbourObj.Capacity==0.0 || nearestNeighbourObj.Request==0)){
                 System.out.println("Vertex Dihapus : "+nearestNeighbourObj.name);
                 g.removeVertex(nearestNeighbourObj);
             }
             System.out.println(cost);
         }else{
            for(int i = 1; i < path.size(); i++) {
                if(i%2==0) System.out.print(" to ");
                System.out.print(path.get(i).name);
                if(i%2==0) System.out.print(", ");
                if(i%2!=0){
                    path.get(i).Capacity-=weight;
                    path.get(i).Request-=qty;
                    if(path.get(i).isExpedition==true && (path.get(i).Capacity==0.0 || path.get(i).Request==0)) g.removeVertex(path.get(i));
                }
            }
            cost=dijkstra.getPathWeight(startVertex, endVertex)*weight*qty;
            System.out.println(cost);
        }
         
        return cost; 
    }
}
