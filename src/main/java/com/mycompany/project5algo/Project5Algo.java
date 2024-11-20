package com.mycompany.project5algo;
import java.util.*;

/**
 * This class is the main file.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Project5Algo.java
 * Created: Nov 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is the main file that reads the input in, creates the initial highway state, finds the shortest path
 * between two pairs, sorts and prints the result. 
 */

public class Project5Algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inf = Integer.MAX_VALUE;
        int cases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        int intersections, roads, cities;

        for (int i = 0; i < cases; i++) {
            intersections = sc.nextInt();
            roads = sc.nextInt();
            cities = sc.nextInt();

            // initialize distance matrix for edges/roads
            double[][] dist = new double[intersections][intersections];
            for (int j = 0; j < intersections; j++) {
                // everything is initilally infinity
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

            // initialize map for cities
            Map<Integer, String> citiesMap = new HashMap<>();
            for (int j = 0; j < cities; j++) {
                int node = sc.nextInt();
                String name = sc.next();
                citiesMap.put(node, name);
            }

            // initialize a list of sign objects
            int numSigns = sc.nextInt();
            List<Sign> signs = new ArrayList<>();
            for (int j = 0; j < numSigns; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                double d = sc.nextDouble();
                signs.add(new Sign(from, to, d));
            }

            // floyd's algorithm to find the shortest path between each pair of nodes 
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
            
            // go through each sign and check if shortest path goes through each node
            int index = 1;
            for (Sign sign : signs) {
                int start = sign.from;
                int end = sign.to;
                double signDist = sign.distance;

                // list of valid signs
                List<Sign> validSigns = new ArrayList<>();
                
                // iterate through each entry in citiesMap
                for (Map.Entry<Integer, String> entry : citiesMap.entrySet()) {
                    int cityNode = entry.getKey();
                    String cityName = entry.getValue();
                    
                    // check if shortest path goes through both nodes in signs
                    if (dist[start][cityNode] == dist[start][end] + dist[end][cityNode]) {
                        double totalDistance = dist[end][cityNode] + (dist[start][end] - signDist);
                        validSigns.add(new Sign(cityName, Math.round(totalDistance)));
                    }
                }

                // sort sign list based on distance then name
                validSigns.sort(Comparator.comparing(Sign::getTotalDistance).thenComparing(Sign::getName));
                
                // print
                for (Sign s : validSigns) {
                    System.out.printf("%-19s %d%n", s.getName(), s.getTotalDistance());
                }
                
                // for gradel - so the last line wont have a new line
                if (index < signs.size()) {
                    System.out.println();
                }          
            }
        }

        sc.close();
    }
}
