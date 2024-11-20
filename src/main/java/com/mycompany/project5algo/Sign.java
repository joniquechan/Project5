package com.mycompany.project5algo;

/**
 * This class is for the State object. 
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Sign.java
 * Created: Nov 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is for the Sign object where it contains two constructors to initializes a sign that was initially given
 * in the problem statement and the final sign that will be in the output of the solution. It also has two getters to get the total distance
 * and the name of a given sign. 
 */

public class Sign {
    public int from;
    public int to;
    public double distance;
    public String name;
    public long totalDistance;

    // constructor for the initial sign
    public Sign(int f, int t, double d) {
        from = f;
        to = t;
        distance = d;
    }

    // constructor for final sign
    public Sign(String n, long d) {
        name = n;
        totalDistance = d;
    }

    // method to get total distance of a sign
    public long getTotalDistance() {
        return totalDistance;
    }

    // method to get name  of a sign
    public String getName() {
        return name;
    }
}
