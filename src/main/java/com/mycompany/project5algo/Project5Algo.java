/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project5algo;
import java.util.*;

/**
 *
 * @author User
 */
public class Project5Algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input: ");
        int inf = Integer.MAX_VALUE;
        // change this when using gradle!
        int cases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        int intersections, roads, cities;
        for (int i = 0; i < cases; i++) {
            intersections = sc.nextInt();
            roads = sc.nextInt();
            cities = sc.nextInt();

            // initialize distance matrix for edges/roads <- everything is inf
            double[][] dist = new double[intersections][intersections];
            for (int j = 0; j < intersections; j++) {
                Arrays.fill(dist[j], inf);
                dist[j][j] = 0; // distance to self
            }

            for (int j = 0; j < roads; j++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                double distance = sc.nextDouble();
                dist[row][col] = distance;
                dist[col][row] = distance;
            }

            // initialize cities 
            Map<Integer, String> citiesMap = new HashMap<>();
            for (int j = 0; j < cities; j++) {
                int node = sc.nextInt();
                String name = sc.next();
                citiesMap.put(node, name);
            }

            // initialize signs
            int numSigns = sc.nextInt();
            List<Sign> signs = new ArrayList<>();
            for (int j = 0; j < numSigns; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                double d = sc.nextDouble();
                signs.add(new Sign(from, to, d));
            }

            // floyd - find shortest path 
            for (int k = 0; k < intersections; k++) {
                for (int j = 0; j < intersections; j++) {
                    for (int m = 0; m < intersections; m++) {
                        // check if path is valid
                        if (dist[j][k] != inf && dist[k][j] != inf) {
                            dist[j][m] = Math.min(dist[j][m], dist[j][k] + dist[k][m]);
                        }
                    }
                }
            }
            
            // print 2d array - for debugging
            for (int j = 0; j < dist.length; j++) { 
                for (int k = 0; k < dist[i].length; k++) { 
                    System.out.print(dist[j][k] + " "); 
                } 
                System.out.println(); 
            }            
            
            // go through each sign and check if shortest path goes through each node
            for (Sign sign : signs) {
                
            }
        }
        
        // parse input
        // create graph representation <- list of edges?
        // objects for roads, cities 
        // find shortest path <- floyds algorithm
        // output
        sc.close();
    }
}
